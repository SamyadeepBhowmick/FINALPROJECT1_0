package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Main6Activity extends AppCompatActivity {
    EditText editText3,editText4,editText5;
    Button b1;
    private FirebaseAuth mAuth;
    String a[]={"hello123","hello124","hello125"};
    String passu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        editText3=findViewById(R.id.editText2);
        editText4=findViewById(R.id.editText);
        editText5=findViewById(R.id.editText3);
        mAuth = FirebaseAuth.getInstance();


    }

    private void createAccount(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            emailverify();

                        } else {
                            Toast.makeText(Main6Activity.this, "Authentication Failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


    public void register(View view) {
        String email=editText3.getText().toString();
        String pass=editText4.getText().toString();
        String pass2=editText5.getText().toString();
        int c=0;
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(pass2)) {
            int i=0;
            while (i<=2) {
                passu=a[i];
                if (pass.equals(pass2) && passu.equals(pass)) {
                    c++;
                    break;
                }
                i++;

            }
            if(c==1)
            createAccount(editText3.getText().toString(), editText4.getText().toString());
            else
                Toast.makeText(Main6Activity.this, "Password Mismatch", Toast.LENGTH_SHORT).show();


        }
        else
            {
            Toast.makeText(Main6Activity.this, "Field empty", Toast.LENGTH_SHORT).show();
        }

    }

    private void emailverify(){
        FirebaseUser firebaseUser=mAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Main6Activity.this,"Verification Email Sent",Toast.LENGTH_LONG).show();
                        mAuth.signOut();
                        startActivity(new Intent(Main6Activity.this,Main5Activity.class));
                        finish();
                    }
                }
            });
        }


    }

}

