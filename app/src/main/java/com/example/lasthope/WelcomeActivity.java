package com.example.lasthope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class WelcomeActivity extends AppCompatActivity {
    EditText emailEdit;
    EditText passwordText;
    FirebaseAuth mAuth;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        loginBtn = findViewById(R.id.loginBtn);
        emailEdit = findViewById(R.id.editTextTextEmailAddress);
        passwordText = findViewById(R.id.editTextTextPassword);
        mAuth = FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signInWithEmailAndPassword(emailEdit.getText().toString(), passwordText.getText().toString()).addOnCompleteListener(WelcomeActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(WelcomeActivity.this, "done", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(WelcomeActivity.this, "UnDone", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });


    }
}