package com.example.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class EsmaUlHusna extends AppCompatActivity {

    Button tellerKnopPlus,tellerKnopMin;
    TextView tellerText;
    int teller=0;
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    Vibrator vibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esma_ul_husna);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tellerKnopPlus = findViewById(R.id.buttonPlus);
        tellerKnopMin = findViewById(R.id.buttonMin);
        tellerText = findViewById(R.id.nummer4);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        tellerKnopPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                teller++;
                tellerText.setText(Integer.toString(teller));
                if(Profile.vibraCheck) { vibe.vibrate(75); }


            }
        });

        tellerKnopMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(teller > 0) {
                    teller--;
                    tellerText.setText(Integer.toString(teller));
                    if(Profile.vibraCheck) { vibe.vibrate(20); }
                }
            }
        });



        getObjectFromPreferences(fAuth.getCurrentUser().getUid());


    }

    public void saveObjectToPreferences(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("teller4", teller);
        editor.apply();
    }


    public void getObjectFromPreferences(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        teller = prefs.getInt("teller4", MODE_PRIVATE);
        tellerText.setText(String.valueOf(teller));
    }



    @Override
    protected void onPause(){
        super.onPause();
        saveObjectToPreferences(fAuth.getCurrentUser().getUid());
    }
}
