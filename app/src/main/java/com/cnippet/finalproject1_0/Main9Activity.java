package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class Main9Activity extends AppCompatActivity {
    String namei;
    String[] yearlist={"Select Year","1st Year","2nd Year","3rd Year","4th Year"};
    String[] streamlist={"Select Stream","CSE","IT","ECE","EE"};
    String[] eosemlist={"Select Semester","Odd","Even"};
    String[] cse1o={"Select Subject","CS","IT","EC","EE"};
    String[] cse1e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] cse2o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] cse2e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] cse3o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] cse3e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] cse4o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] cse4e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] it1o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] it1e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] it2o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] it2e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] it3o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] it3e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] it4o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] it4e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ece1o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ece1e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ece2o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ece2e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ece3o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ece3e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ece4o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ece4e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ee1o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ee1e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ee2o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ee2e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ee3o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ee3e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ee4o={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};
    String[] ee4e={"Select","CSE","IT","ECE","EE","BCA","MCA","BBA"};

    Spinner spin3,spin2,spin1,spin;
    String yearselected,streamselected,semselected,subselected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        Intent i=getIntent();
        namei=i.getStringExtra("code");

        spin=(Spinner)findViewById(R.id.spinner);
        spin1=(Spinner)findViewById(R.id.spinner2);
        spin2=(Spinner)findViewById(R.id.spinner3);
        spin3=(Spinner)findViewById(R.id.spinner4);


        ArrayAdapter year=new ArrayAdapter(this,android.R.layout.simple_spinner_item,yearlist);
        year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(year);

        ArrayAdapter stream = new ArrayAdapter(this, android.R.layout.simple_spinner_item, streamlist);
        stream.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(stream);

        ArrayAdapter sem=new ArrayAdapter(this,android.R.layout.simple_spinner_item,eosemlist);
        year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(sem);

        ArrayAdapter sub= new ArrayAdapter(this, android.R.layout.simple_spinner_item,cse1o);
        sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(sub);


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                yearselected=spin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                yearselected="0";

            }
        });
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                streamselected=spin1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                streamselected="0";
            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semselected=spin2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                semselected="0";
            }
        });
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subselected=spin3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                subselected="0";
            }
        });

    }
    public void takeattendance(View view) {
        if(!yearselected.equals("Select Year") && !streamselected.equals("Select Stream") && !semselected.equals("Select Semester") && !subselected.equals("Select Subject"))
        {

            Toast.makeText(this, "Loading Namelist", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Main9Activity.this, Main10Activity.class);
            intent.putExtra("codepass", namei);
            intent.putExtra("name", yearselected);
            intent.putExtra("stream", streamselected);
            intent.putExtra("sem", semselected);
            intent.putExtra("sub", subselected);
            startActivity(intent);


        }
    }
}
