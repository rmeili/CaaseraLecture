package com.russellmeili.caasera;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class Landing2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing2);
    }

    public void btnLoginOnClick(View v) {
        finish();
    }

    public void btnPrev(View v) {
        Log.i("CLICK", "Previous button was clicked.");

        startActivity(new Intent(this, Landing1.class));
    }

    public void btnNext(View v) {
        Log.i("CLICK", "Next button was clicked.");

        startActivity(new Intent(this, Landing3.class));
    }
}
