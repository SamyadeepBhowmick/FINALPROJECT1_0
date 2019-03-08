package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main10Activity extends AppCompatActivity {
    DatabaseReference databaseArtists;
    TextView textView,textView2;
    ListView listViewArtists;
    int count1=0,count2=0,positionof=0,p=0;
    String code,namei,streami,semi,subi;
    String date;
    DatabaseReference databaseReference1;

    View view1;

    List<User> UserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Intent i=getIntent();
        code=i.getStringExtra("codepass");
        namei=i.getStringExtra("name");
        streami=i.getStringExtra("stream");
        semi=i.getStringExtra("sem");
        subi=i.getStringExtra("sub");


        Calendar calendar=Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        textView2=findViewById(R.id.textView3);
        textView2.setText(currentDate);

        date=currentDate;
        databaseReference1= FirebaseDatabase.getInstance().getReference();


        databaseArtists= FirebaseDatabase.getInstance().getReference();
        listViewArtists=(ListView)findViewById(R.id.listview);
        //textView=findViewById(R.id.textView3);
        UserList=new ArrayList<>();



        listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // view.setSelected(true);
                User user=UserList.get(position);
                positionof=position;
                showUpdateDialog(user.getNam(),user.getPtte(),user.getAtte(),user.getRoll());
                view1=view;

            }
        });

        listViewArtists.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                User user=UserList.get(position);

                showDeleteDialog(user.getRoll());
                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseArtists.child(code).child(namei).child(streami).child(semi).child(subi).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                UserList.clear();

                for (DataSnapshot UserSnapshot : dataSnapshot.getChildren()) {

                    User userinfo = UserSnapshot.getValue(User.class);
                    UserList.add(userinfo);

                }
                p++;

                if (p==1)
                {

                    UserList adapter = new UserList(Main10Activity.this, UserList);
                    listViewArtists.setAdapter(adapter);

                }
                else
                {
                    UserList adapter = new UserList(Main10Activity.this, UserList);
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showUpdateDialog(final String nameid,final String ptte, final String atte,final String roll){
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final View dialogView=inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogView);

        final Button buttonUpdate=(Button)dialogView.findViewById(R.id.buttonUpdate);
        final Button buttonDelete=(Button)dialogView.findViewById(R.id.buttonDelete);

        final AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.setTitle("Update roll:"+roll);
        alertDialog.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1++;

                int name= Integer.parseInt(ptte);
                name=name+1;
                String name2= String.valueOf(name);


                Update(nameid,name2,atte,roll);
                view1.setSelected(true);
                view1.setBackgroundColor(Color.argb(255,196,236,161));
                alertDialog.dismiss();


            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2++;

                int name= Integer.parseInt(atte);
                name=name+1;
                String name2= String.valueOf(name);

                delete(nameid,ptte,name2,roll);
                view1.setSelected(true);
                view1.setBackgroundColor(Color.argb(255,242,172,151));
                alertDialog.dismiss();

            }
        });


    }

    private void showDeleteDialog(final String roll) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog2, null);
        dialogBuilder.setView(dialogView);

        final Button buttonDel=(Button)dialogView.findViewById(R.id.buttonDel);

        final AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.setTitle("Delete roll:"+roll);
        alertDialog.show();

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteData(roll);
                alertDialog.dismiss();
                UserList adapter = new UserList(Main10Activity.this, UserList);
                listViewArtists.setAdapter(adapter);
            }
        });

    }

    private void deleteData(String roll){
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference(code).child(namei).child(streami).child(semi).child(subi).child(roll);
        databaseReference.removeValue();

        Toast.makeText(this,"Name deleted",Toast.LENGTH_LONG).show();
    }


    private void delete(String name,String ptte,String atte,String roll){
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference(code).child(namei).child(streami).child(semi).child(subi).child(roll);
        User user=new User(name,ptte,atte,roll,date);
        databaseReference.setValue(user);

        UserDate userDate=new UserDate(name,"A",roll);
        databaseReference1.child(code).child(date).child(namei).child(streami).child(semi).child(subi).child(roll).setValue(userDate);;


        Toast.makeText(this,"Absent given",Toast.LENGTH_LONG).show();

    }

    private boolean Update(String name,String ptte,String atte,String roll){
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference(code).child(namei).child(streami).child(semi).child(subi).child(roll);
        User user=new User(name,ptte,atte,roll,date);
        databaseReference.setValue(user);

        UserDate userDate=new UserDate(name,"P",roll);
        databaseReference1.child(code).child(date).child(namei).child(streami).child(semi).child(subi).child(roll).setValue(userDate);

        Toast.makeText(this,"Present given",Toast.LENGTH_LONG).show();
        return true;

    }

    public void view(View view) {
        String pp;
        if(count1==0 && count2==0)
        {
            pp="0";
        }
        else {
            pp = String.valueOf((count1 * 100) / (count1 + count2));
        }
        pp=pp+"%";
        String p=String.valueOf(count1);
        String a=String.valueOf(count2);
        Intent intent = new Intent(Main10Activity.this, Main12Activity.class);
        intent.putExtra("percentage", pp);
        intent.putExtra("present", p);
        intent.putExtra("absent", a);
        startActivity(intent);
    }
}
