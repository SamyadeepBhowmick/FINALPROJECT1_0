package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main12Activity extends AppCompatActivity {
    TextView textView11,textView13,textView15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        textView11=findViewById(R.id.textView11);
        textView13=findViewById(R.id.textView13);
        textView15=findViewById(R.id.textView15);


        Intent i=getIntent();
        textView15.setText(i.getStringExtra("percentage"));
        textView11.setText(i.getStringExtra("present"));
        textView13.setText(i.getStringExtra("absent"));

    }
}
