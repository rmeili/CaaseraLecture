package com.russellmeili.caasera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.Spinner;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

public class LessonHomeActivity extends BaseActivity /*implements OnClickListener*/ {

    ExpandableListView lessons;
    //ArrayAdapter<CharSequence> adapter;

    private LinkedHashMap<String, Group_heading> mySection = new LinkedHashMap<>();
    private ArrayList<Group_heading> SectionList = new ArrayList<>();

    private MyCustomListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_home);

        Spinner spinner = (Spinner) findViewById(R.id.department);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dept_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        //Just add some data to start with
        AddProduct();

        //get reference to the ExpandableListView
        lessons = (ExpandableListView) findViewById(R.id.lvLessons);
        //create the adapter by passing your ArrayList data
        listAdapter = new MyCustomListAdapter(LessonHomeActivity.this, SectionList);
        //attach the adapter to the list
        lessons.setAdapter(listAdapter);

        //expand all Groups
        expandAll();

//        //add new item to the List
//        Button add = (Button) findViewById(R.id.add);
//        add.setOnClickListener(this);

        //listener for child row click
        lessons.setOnChildClickListener(myListItemClicked);
        //listener for group heading click
        lessons.setOnGroupClickListener(myListGroupClicked);

        // adapter = ArrayAdapter.createFromResource(this,
        //       R.array.countries_array, android.R.layout.simple_list_item_1);
        //lessons.setAdapter( adapter );

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://caasera.azurewebsites.net/api/1.0/student";
        // Request a string for the URL
        JsonObjectRequest jsonRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // response.get("currentSubscription").get("currentLessons").get("studentAssignments").get(0).get("title");
                        //      response.get
//                        List<String> items = new ArrayList<String>();
//                        try {
//                            JSONArray temp = (JSONArray) ((JSONObject)((JSONObject)response.get("currentSubscription")).get("currentLesson")).get("studentAssignments"));
//                            int count = temp.length();
//                            for( int i=0; i< count; i++){
//                                items.add((String)((JSONObject)temp.get(i)).get("title"));
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }

                        // Create Jackson ObjectMapper instance
                        ObjectMapper objectMapper = new ObjectMapper();

                        // Convert json string to object
                        List<String> items = new ArrayList<String>();
                        try {
                            studentInfo = objectMapper.readValue(response.toString(), StudentInfo.class);
                            studentInfo.getCurrentSubscription().getCurrentLesson().getTitle();
                            int count = studentInfo.getCurrentSubscription().getCurrentLesson().getStudentAssignments().size();
                            for (int i = 0; i < count; i++) {
                                items.add(studentInfo.getCurrentSubscription().getCurrentLesson().getTitle());
//                            Log.i("BMI", studentInfo.getFirstName());
//                            Log.i("BMI", studentInfo.getCurrentSubscription().getCurrentLesson().getTitle());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

//
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
//                        lessons.setAdapter(adapter);
                        lessons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                ToastIt(adapter.getItem(position) + ": " + position + " id: " + id);
                            }
                        });
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ToastIt(getString(R.string.didntWork));
                    }
                }


        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                String credentials = username + ":" + password;
                String auth = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                Log.i("BMI", auth);
                headers.put("Authorization", auth);
                return headers;
            }
        };
        queue.add(jsonRequest);
    }

//    public void onClick(View v) {
//
//        switch (v.getId()) {
//
//            //add entry to the List
//            case R.id.add:
//
//                Spinner spinner = (Spinner) findViewById(R.id.department);
//                String department = spinner.getSelectedItem().toString();
//                EditText editText = (EditText) findViewById(R.id.product);
//                String product = editText.getText().toString();
//                editText.setText("");
//
//                //add a new item to the list
//                int groupPosition = addProduct(department,product);
//                //notify the list so that changes can take effect
//                listAdapter.notifyDataSetChanged();
//
//                //collapse all groups
//                collapseAll();
//                //expand the group where item was just added
//                lessons.expandGroup(groupPosition);
//                //set the current group to be selected so that it becomes visible
//                lessons.setSelectedGroup(groupPosition);
//
//                break;
//        }
//    }

    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            lessons.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            lessons.collapseGroup(i);
        }
    }

    //load some initial data into out list
    private void AddProduct() {

//        addProduct("Vegetable","Potato");
//        addProduct("Vegetable","Cabbage");
//        addProduct("Vegetable","Onion");
//
//        addProduct("Fruits","Apple");
//        addProduct("Fruits","Orange");
    }

    //our child listener
    private OnChildClickListener myListItemClicked = new OnChildClickListener() {

        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {

            //get the group header
            Group_heading group_heading = SectionList.get(groupPosition);
            //get the child info
            Child_row child_row = group_heading.getProductList().get(childPosition);
            //display it or do something with it
            Toast.makeText(getBaseContext(), "Clicked on Detail " + group_heading.getName()
                    + "/" + child_row.getName(), Toast.LENGTH_LONG).show();
            return false;
        }
    };

    //our group listener
    private OnGroupClickListener myListGroupClicked = new OnGroupClickListener() {

        public boolean onGroupClick(ExpandableListView parent, View v,
                                    int groupPosition, long id) {

            //get the group header
            Group_heading group_heading = SectionList.get(groupPosition);
            //display it or do something with it
            Toast.makeText(getBaseContext(), "Child on Header " + group_heading.getName(),
                    Toast.LENGTH_LONG).show();

            return false;
        }
    };

    //here we maintain our products in various departments
    private int addProduct(String department, String product) {

        int groupPosition = 0;

        //check the hash map if the group already exists
        Group_heading group_heading = mySection.get(department);
        //add the group if doesn't exists
        if (group_heading == null) {
            group_heading = new Group_heading();
            group_heading.setName(department);
            mySection.put(department, group_heading);
            SectionList.add(group_heading);
        }

        //get the children for the group
        ArrayList<Child_row> productList = group_heading.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        Child_row child_row = new Child_row();
        child_row.setSequence(String.valueOf(listSize));
        child_row.setName(product);
        productList.add(child_row);
        group_heading.setProductList(productList);

        //find the group position inside the list
        groupPosition = SectionList.indexOf(group_heading);

        return groupPosition;
    }
}
