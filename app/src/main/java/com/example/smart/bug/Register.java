package com.example.smart.bug;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private Button r, l;
    private EditText name, email, pass;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        r = (Button) findViewById(R.id.B_R);
        email = findViewById(R.id.E_E);
        pass = findViewById(R.id.E_P);

        firebaseAuth = FirebaseAuth.getInstance();


        r.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(Register.this, "Registering in..", Toast.LENGTH_SHORT).show();
                RegisterUser();
            }
        });
    }


    private void RegisterUser(){
        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Register.this,LogIn.class));

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this, "Error: "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
