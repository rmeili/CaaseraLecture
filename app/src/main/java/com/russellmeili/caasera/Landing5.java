package com.russellmeili.caasera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Landing5 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing5);
    }

    public void btnLoginOnClick(View v) {
        finish();
    }

    public void btnPrev(View v) {
        Log.i("CLICK", "Previous button was clicked.");

        startActivity(new Intent(this, Landing4.class));
    }
}
