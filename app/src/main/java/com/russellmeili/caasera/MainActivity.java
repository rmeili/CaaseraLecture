package com.russellmeili.caasera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    EditText edtLoginName;
    EditText edtPassword;
    CheckBox chbLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLoginName = (EditText) findViewById(R.id.edtLoginName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        chbLoggedIn = (CheckBox) findViewById(R.id.chbStayLoggedIn);
    }

    public void btnLoginOnClick(View v) {
        Log.i("CLICK", getString(R.string.loginButtonClicked));
        Log.i("CLICK", edtLoginName.getText().toString());
        username = edtLoginName.getText().toString();
        password = edtPassword.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://caasera.azurewebsites.net/api/1.0/student";
        // Request a string for the URL
        JsonObjectRequest jsonRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //txtWebContent.setText("Response: " + response.toString() );
                        ToastIt(getString(R.string.successfulLogin,
                                edtLoginName.getText().toString() + " ",
                                chbLoggedIn.isChecked()));

                        // TODO: Get the studentInfo JSON object
                        startActivity(new Intent(getApplicationContext(), LessonHomeActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("BMI", getString(R.string.loginError) + error.networkResponse.statusCode);
                        ToastIt(getString(R.string.idiotString));

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


    public void btnCancelOnClick(View v) {
        Log.i("CLICK", "Cancel button was clicked.");
        edtLoginName.setText("");
        edtPassword.setText("");
        Toast.makeText(this, "You successfully canceled login", Toast.LENGTH_LONG).show();
    }

    public void switchToBMIOnClick(View v) {
        startActivity(new Intent(this, BMIActivity.class));
    }
}
