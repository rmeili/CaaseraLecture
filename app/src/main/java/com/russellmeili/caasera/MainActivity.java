package com.russellmeili.caasera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        Log.i("CLICK", "Login button was clicked.");
        Log.i("CLICK", edtLoginName.getText().toString());
        ToastIt("You successfully Logged in: " +
                edtLoginName.getText().toString() + " " +
                chbLoggedIn.isChecked());

        startActivity(new Intent(this, Landing1.class));
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
