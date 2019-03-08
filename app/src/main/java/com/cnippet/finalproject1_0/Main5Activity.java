package com.cnippet.finalproject1_0;

import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main5Activity extends AppCompatActivity {
    EditText editText1, editText2;
    private FirebaseAuth mAuth;
    TextView textView;
    String a[]={"hello123","hello124","hello125"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        editText1 = findViewById(R.id.editText2);
        editText2 = findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView2);

        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        mAuth = FirebaseAuth.getInstance();

    }

    private void userLogin(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            log();
                        } else {

                            Toast.makeText(Main5Activity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }


    public void loginf(View view) {
        String email = editText1.getText().toString();
        String pass = editText2.getText().toString();
        String pass1;
        int i=0,c=0;
        while (i<=2) {
            pass1=a[i];
            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && pass1.equals(pass)) {
                c++;
                break;
            }
            i++;
        }
        if(c==1)
        userLogin(email, pass);
        else
            Toast.makeText(Main5Activity.this, "Login failed", Toast.LENGTH_SHORT).show();

    }

    private void log() {
        FirebaseUser firebaseUser = mAuth.getInstance().getCurrentUser();
        boolean emailflag = firebaseUser.isEmailVerified();

        if (emailflag) {
            Toast.makeText(Main5Activity.this, "Logged in", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Main5Activity.this, Main7Activity.class);
            intent.putExtra("passcode", editText2.getText().toString());
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(Main5Activity.this, "Verify email", Toast.LENGTH_SHORT).show();
            mAuth.signOut();

        }
    }


    public void register(View view) {
        Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
        startActivity(intent);
    }
}



