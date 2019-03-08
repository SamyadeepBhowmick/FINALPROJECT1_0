package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends AppCompatActivity {
    String[] yearlist={"Select Year","1st Year","2nd Year","3rd Year","4th Year"};
    String[] streamlist={"Select Stream","CSE","IT","ECE","EE"};
    String[] eosemlist={"Select Semester","Odd","Even"};
    String[] cse1o={"Select Subject","CS","IT","EC","EE"};
    String ab,code="";
    int f=0,f1=0;

    Spinner spin3,spin2,spin1,spin;
    String yearselected,streamselected,semselected,subselected,dateselected,rollselected;
    EditText editText,editText2;
    DatabaseReference databaseReference;
    TextView textView,textView2,textView3;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        spin=(Spinner)findViewById(R.id.spinner);
        spin1=(Spinner)findViewById(R.id.spinner2);
        spin2=(Spinner)findViewById(R.id.spinner3);
        spin3=(Spinner)findViewById(R.id.spinner4);


        editText=findViewById(R.id.editText7);
        editText2=findViewById(R.id.editText9);
        textView=findViewById(R.id.textView4);
        textView3=findViewById(R.id.textView5);

        textView3.setPaintFlags(textView3.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        ArrayAdapter year=new ArrayAdapter(this,android.R.layout.simple_spinner_item,yearlist);
        year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(year);

        ArrayAdapter stream = new ArrayAdapter(this, android.R.layout.simple_spinner_item, streamlist);
        stream.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(stream);

        ArrayAdapter sem = new ArrayAdapter(this, android.R.layout.simple_spinner_item, eosemlist);
        stream.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
        rollselected=editText.getText().toString();
        ab=editText2.getText().toString();
            if (!TextUtils.isEmpty(rollselected) && rollselected.length()==11 && !yearselected.equals("Select Year") && !streamselected.equals("Select Stream") && !semselected.equals("Select semester") && !subselected.equals("Select Subject"))
            {
                if(ab.equals("123hello")){
                    code="hello123";
                    f1=1;
                }
                else if(ab.equals("124hello")){
                    code="hello124";
                    f1=1;
                }
                else if(ab.equals("125hello")){
                    code="hello125";
                    f1=1;
                }
                if (f1==1) {

                    databaseReference.child(code).child(yearselected).child(streamselected).child(semselected).child(subselected).child(rollselected).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            String pp;
                            String ptte = dataSnapshot.child("ptte").getValue().toString();
                            String atte = dataSnapshot.child("atte").getValue().toString();
                            int ptte1 = Integer.parseInt(ptte);
                            int atte1 = Integer.parseInt(atte);
                            if (ptte1 == 0 && atte1 == 0) {
                                pp = "0";
                            } else {
                                pp = String.valueOf((ptte1 * 100) / (ptte1 + atte1));
                            }
                            pp = pp + "%";
                            textView.setText(pp);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
                else {
                    Toast.makeText(this,"Student Passcode Incorrect",Toast.LENGTH_LONG).show();

                }

            }
            else{
                Toast.makeText(this,"Fields Invalid",Toast.LENGTH_LONG).show();
            }

    }

    public void details(View view) {
        ab=editText2.getText().toString();
        if (ab.equals("123hello"))
        {
            code = "hello123";
            f=1;
        }
        else if (ab.equals("124hello"))
        {
            code = "hello124";
            f=1;
        }
        else if (ab.equals("125hello"))
        {
            code = "hello125";
            f=1;
        }
        if (!yearselected.equals("Select Year") && !streamselected.equals("Select Stream") && !semselected.equals("Select Semester") && !subselected.equals("Select Subject") && !TextUtils.isEmpty(ab) && f==1) {


            Intent intent = new Intent(Main3Activity.this, Main11Activity.class);
            intent.putExtra("code", code);
            intent.putExtra("year", yearselected);
            intent.putExtra("stream", streamselected);
            intent.putExtra("sem", semselected);
            intent.putExtra("sub", subselected);
            startActivity(intent);
        }
        else if (f==0)
        {
            Toast.makeText(this,"Student Passcode Incorrect",Toast.LENGTH_LONG).show();
        }
        else
            {
                Toast.makeText(this,"Enter all fields.",Toast.LENGTH_LONG).show();

            }

    }
}
