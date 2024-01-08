package com.example.lasthope;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginFragment extends Fragment {
    EditText emailEdit;
    EditText passwordText;
    FirebaseAuth mAuth;
    Button loginBtn;
    Context context;
    public LoginFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        loginBtn = view.findViewById(R.id.loginBtn);
        emailEdit = view.findViewById(R.id.editTextTextEmailAddress);
        passwordText = view.findViewById(R.id.editTextTextPassword);
        mAuth = FirebaseAuth.getInstance();
        String name = new String();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    if (snapshot.child("email").getValue(String.class).equals(emailEdit.getText().toString())){
                        DBHelper helper = new DBHelper(context);
                        User user = new User(Integer.parseInt(snapshot.getKey()),snapshot.child("name").getValue(String.class), snapshot.child("email").getValue(String.class), snapshot.child("adress").getValue(String.class), snapshot.child("tlf").getValue(String.class), snapshot.child("progress").getValue(Integer.class), snapshot.child("paied").getValue(Integer.class), snapshot.child("rest").getValue(Integer.class));
                        helper.setUser(user);
                        System.out.println(user.name);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signInWithEmailAndPassword(emailEdit.getText().toString(), passwordText.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(context, "done ", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context, "UnDone", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context =context;
    }

}
