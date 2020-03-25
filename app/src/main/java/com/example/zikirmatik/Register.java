package com.example.zikirmatik;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zikirmatik.Login;
import com.example.zikirmatik.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;



public class Register extends AppCompatActivity {


    EditText lastname, firstname, email, password, phone;
    Button register;
    TextView login;
    FirebaseAuth fAuth;
    FirebaseFirestore firestore;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        lastname = findViewById(R.id.lastname);
        firstname = findViewById(R.id.firstname);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        register = findViewById(R.id.confirm);
        login = findViewById(R.id.login);
        fAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailtext = email.getText().toString();
                String passwordtext = password.getText().toString();
                final String firstnametext = firstname.getText().toString();
                final String lastnametext = lastname.getText().toString();
                final String phonetext = phone.getText().toString();


                if (TextUtils.isEmpty(emailtext)) {
                    email.setError("Email required.");
                    return;
                }

                if (TextUtils.isEmpty(passwordtext)) {
                    password.setError("Password required.");
                    return;
                }

                if (passwordtext.length() < 6) {
                    password.setError("Password must be 6 characters at least.");
                    return;
                }


                fAuth.createUserWithEmailAndPassword(emailtext, passwordtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User created", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = firestore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("FirstName", firstnametext);
                            user.put("LastName", lastnametext);
                            user.put("Phone", phonetext);
                            user.put("Email", emailtext);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "onSuccess : user Profile is created for" + userID);
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


    }
}
