package com.example.zikirmatik;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class Profile extends AppCompatActivity {

    TextView firstName, lastName, email, phone;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button logout;
    Switch vibra;
    public static boolean vibraCheck=true;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        phone = findViewById(R.id.profilePhone);
        firstName = findViewById(R.id.profileFirstName);
        lastName = findViewById(R.id.profileLastName);
        email = findViewById(R.id.profileEmail);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();
        logout = findViewById(R.id.logout);
        vibra = findViewById(R.id.vibra);

        sharedPreferences = getSharedPreferences("vibra",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        vibra.setChecked(sharedPreferences.getBoolean("switch",true));
        vibra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){editor.putBoolean("switch",true);}
                else{editor.putBoolean("switch",false);}
                editor.apply();
                vibraCheck = vibra.isChecked();
            }
        });




        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                phone.setText(documentSnapshot.getString("Phone"));
                firstName.setText(documentSnapshot.getString("FirstName"));
                lastName.setText(documentSnapshot.getString("LastName"));
                email.setText(documentSnapshot.getString("Email"));
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setSelectedItemId(R.id.profile);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        return true;
                    case R.id.charts:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), History.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }

        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fAuth.getInstance().signOut();//logout
                Intent i = new Intent(Profile.this, Login.class);
                startActivity(i);
                finish();
            }
        });



    }



}