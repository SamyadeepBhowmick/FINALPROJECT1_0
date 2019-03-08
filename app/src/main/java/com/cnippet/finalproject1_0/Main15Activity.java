package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main15Activity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);
        textView=findViewById(R.id.textView35);

        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

    }
    public void mail(View view) {
        String sto=textView.getText().toString();
        Intent email=new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL,new String[]{sto});
        email.putExtra(Intent.EXTRA_SUBJECT,"To claim College Passcode and Student Passcode");


        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "choose an email client"));
    }
}
