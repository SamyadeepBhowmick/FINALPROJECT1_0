package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firebaseAuth=FirebaseAuth.getInstance();
        if (!(firebaseAuth.getCurrentUser()==null)){
            startActivity(new Intent(this,Main7Activity.class));
            finish();
        }
        dl=findViewById(R.id.dlayout);
        abdt=new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(abdt.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void students(View view) {
        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(intent);
    }

    public void faculties(View view) {
        Intent intent=new Intent(Main2Activity.this,Main5Activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.about){
            Intent j1=new Intent();
            j1.setClass(Main2Activity.this,Main13Activity.class);
            startActivity(j1);
        }
        else if(id==R.id.guidelines){
            Intent j1=new Intent();
            j1.setClass(Main2Activity.this,Main14Activity.class);
            startActivity(j1);
        }
        else if(id==R.id.passcode){
            Intent j1=new Intent();
            j1.setClass(Main2Activity.this,Main15Activity.class);
            startActivity(j1);
        }

        return false;
    }
}
