package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main13Activity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        textView=findViewById(R.id.textView16);

        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);


    }

    public void mail(View view) {
        String sto=textView.getText().toString();
        Intent email=new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL,new String[]{sto});
        email.putExtra(Intent.EXTRA_SUBJECT,"Regarding Present Please");


        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "choose an email client"));
    }
}
