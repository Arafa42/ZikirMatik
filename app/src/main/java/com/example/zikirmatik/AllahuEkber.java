package com.example.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

public class AllahuEkber extends AppCompatActivity {

    Button tellerKnopPlus,tellerKnopMin;
    TextView tellerText;
    int teller=0;
    FirebaseAuth fAuth = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allahu_ekber);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tellerKnopPlus = findViewById(R.id.buttonPlus1);
        tellerKnopMin = findViewById(R.id.buttonMin1);
        tellerText = findViewById(R.id.nummer1);





        tellerKnopPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                teller++;
                tellerText.setText(Integer.toString(teller));

                SharedPreferences sharedPreferences = getSharedPreferences("myKey",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("teller",tellerText.getText().toString().trim());
                editor.apply();
                Intent intent = new Intent(AllahuEkber.this,OzetAllahuEkber.class);
                //startActivity(intent);

            }
        });

        tellerKnopMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(teller > 0) {
                    teller--;
                    tellerText.setText(Integer.toString(teller));

                    SharedPreferences sharedPreferences = getSharedPreferences("myKey",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("teller",tellerText.getText().toString().trim());
                    editor.apply();
                    Intent intent = new Intent(AllahuEkber.this,OzetAllahuEkber.class);
                }
            }
        });








        getObjectFromPreferences(fAuth.getCurrentUser().getUid());


    }





    public void saveObjectToPreferences(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("teller1", teller);
        editor.apply();
    }


    public void getObjectFromPreferences(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        teller = prefs.getInt("teller1", MODE_PRIVATE);
        tellerText.setText(String.valueOf(teller));
    }





    @Override
    protected void onPause(){
        super.onPause();
        saveObjectToPreferences(fAuth.getCurrentUser().getUid());
    }

}
