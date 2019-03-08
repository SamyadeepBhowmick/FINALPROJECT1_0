package com.cnippet.finalproject1_0;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Main11Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    Button button;
    String dateselected;
    TextView textView2;
    DatabaseReference databaseArtists;
    ListView listViewArtists;
    List<UserDate> UserList;
    String datei,yeari,streami,semi,subi,code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        databaseArtists= FirebaseDatabase.getInstance().getReference();
        listViewArtists=(ListView)findViewById(R.id.listview2);
        UserList=new ArrayList<>();

        Intent i=getIntent();
        code=i.getStringExtra("code");
        yeari=i.getStringExtra("year");
        streami=i.getStringExtra("stream");
        semi=i.getStringExtra("sem");
        subi=i.getStringExtra("sub");



        textView2=(TextView)findViewById(R.id.textView9);
        button=(Button)findViewById(R.id.button14);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        dateselected= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        textView2.setText(dateselected);
        datei=dateselected;

    }

    public void attendance(View view) {
            if (!textView2.equals("")) {
                Toast.makeText(this,"Loading Namelist",Toast.LENGTH_LONG).show();

                databaseArtists.child(code).child(datei).child(yeari).child(streami).child(semi).child(subi).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        UserList.clear();

                        for (DataSnapshot UserSnapshot : dataSnapshot.getChildren()) {

                            UserDate userinfo = UserSnapshot.getValue(UserDate.class);
                            UserList.add(userinfo);
                        }

                        DateList adapter = new DateList(Main11Activity.this, UserList);
                        listViewArtists.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            } else {
                Toast.makeText(this, "Field Empty", Toast.LENGTH_LONG).show();
            }
    }
}
