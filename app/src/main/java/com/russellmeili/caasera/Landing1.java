package com.russellmeili.caasera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Landing1 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing1);
    }

    public void btnLoginOnClick(View v) {
        finish();
    }

    public void btnFreeTrialOnClick(View v) {
        startActivity(new Intent(getApplicationContext(), FreeTrial.class));
    }

    public void btnNext(View v) {
        Log.i("CLICK", "Next button was clicked.");

        startActivity(new Intent(this, Landing2.class));
    }
}
