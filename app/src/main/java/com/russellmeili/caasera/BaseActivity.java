package com.russellmeili.caasera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by russm on 3/12/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public GestureDetectorCompat gestureObject;
    protected Class[] ladingPages = {
            LessonHomeActivity.class,
            MainActivity.class,
            Landing1.class,
            Landing2.class,
            Landing3.class,
            Landing4.class,
            Landing5.class,
            //LessonHomeActivity.class,
            FreeTrial.class
    };
    static int currentPage = 0;
    static String username = "";
    static String password = "";
    static StudentInfo studentInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureObject = new GestureDetectorCompat(this, new BaseActivity.LearnGesture());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    // Activity methods that all activities can use
    public void ToastIt(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            Log.i("BMI", "X1: " + event1.getX() + " Y1: " + event1.getY());
            Log.i("BMI", "X2: " + event2.getX() + " Y2: " + event2.getY());
            Log.i("BMI", "VelocityX: " + velocityX);
            Log.i("BMI", "VelocityY: " + velocityY);

            if (event2.getX() > event1.getX()) { // Swiping left to right
                Log.i("BMI", "Left to Right Swipe");
                if (currentPage > 0) {
                    currentPage--;
                    finish();
                    // TODO: don't switch if same activity
                    startActivity(new Intent(getApplicationContext(), ladingPages[currentPage]));
                }

            } else if (event2.getX() < event1.getX()) { // Swiping right to left
                Log.i("BMI", "Right to Left Swipe");
                if (currentPage < ladingPages.length - 1) {
                    currentPage++;
                    finish();
                    startActivity(new Intent(getApplicationContext(), ladingPages[currentPage]));
                }
            }
            return true;
        }
    }
}
