package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.jackandphantom.circularprogressbar.CircleProgressbar;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        final CircleProgressbar circleProgressbar = (CircleProgressbar)findViewById(R.id.progress);
        circleProgressbar.setForegroundProgressColor(Color.GREEN);
        //circleProgressbar.setBackgroundColor(Color.GREEN);
        circleProgressbar.setBackgroundProgressWidth(60);
        circleProgressbar.setForegroundProgressWidth(50);
        circleProgressbar.enabledTouch(true);
        circleProgressbar.setRoundedCorner(true);
        circleProgressbar.setClockwise(true);
        int animationDuration = 4000;
        circleProgressbar.setProgressWithAnimation(95, animationDuration);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent();
                i.setClass(MainActivity.this,Main2Activity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}