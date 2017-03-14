package com.russellmeili.caasera;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BMIActivity extends BaseActivity {
    TextView txtWebContent = null;

    EditText edtHeight, edtWeight;
    TextView lblBMI, lblFatString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        edtHeight = (EditText) findViewById(R.id.edtHeight);
        edtWeight = (EditText) findViewById(R.id.edtWeight);
        lblBMI = (TextView) findViewById(R.id.txtBMI);
        lblFatString = (TextView) findViewById(R.id.lblFatString);
        txtWebContent = (TextView) findViewById(R.id.txtWebContent);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://caasera.azurewebsites.net/api/1.0/student";
        // Request a string for the URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtWebContent.setText("Response: " + response.substring(0, 500));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txtWebContent.setText("That didn't work!!!");
                    }
                });
        queue.add(stringRequest);
    }

    public void calculateOnClick(View v) {
        Log.i("BMI", "Calculate Button Clicked");
        // Get the height and weight
        Double height = Double.parseDouble(edtHeight.getText().toString());
        Double weight = Double.parseDouble(edtWeight.getText().toString());

        // Do the BMI Calc
        // (weight / (height * height)) * 703.0
        Double bmi = (weight / (height * height)) * 703.0;

        // Set the result into the BMI Text label
        lblBMI.setText(String.format("%.2f", bmi));
        lblFatString.setText("You are a big fatty");
    }

    public void saveResultsOnClick(View v) {
        Log.i("BMI", "Saving results...");
        File file = getApplicationContext().getFileStreamPath("bmiLog");
        if (file != null && file.exists()) {
            Log.i("BMI", "File already exists");
        }
        try {
            String logEntry = edtHeight.getText().toString() +
                    "," + edtWeight.getText().toString() +
                    "," + lblBMI.getText().toString() +
                    "\n";
            FileOutputStream out = openFileOutput("bmiLog", Context.MODE_APPEND);
            out.write("World\n".getBytes());
            out.close();
            Log.i("BMI", "Saved Entry");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
