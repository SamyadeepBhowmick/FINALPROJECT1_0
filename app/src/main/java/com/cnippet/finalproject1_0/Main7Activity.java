package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Main7Activity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    String namei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent i=getIntent();
        namei=i.getStringExtra("passcode");
        mAuth=FirebaseAuth.getInstance();
    }

    public void registerStudents(View view) {
        Intent intent = new Intent(Main7Activity.this, Main8Activity.class);
        intent.putExtra("code", namei);
        startActivity(intent);
    }

    public void takeattendance(View view) {
        Intent intent = new Intent(Main7Activity.this, Main9Activity.class);
        intent.putExtra("code",namei);
        startActivity(intent);
    }

    public void logOut(View view) {
        mAuth.signOut();
        Intent intent=new Intent();
        intent.setClass(Main7Activity.this,Main2Activity.class);
        startActivity(intent);
        Toast.makeText(this,"Logged out",Toast.LENGTH_LONG).show();
        finish();
    }

}

