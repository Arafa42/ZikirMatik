package com.example.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class OzetSubhanallahiVelhamdulillahi extends AppCompatActivity {

    TextView toplamSayi;
    ImageButton buttonDel;
    FirebaseAuth fauth = FirebaseAuth.getInstance();
    int teller=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ozet_subhanallahi_velhamdulillahi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toplamSayi = findViewById(R.id.zikirTplmSayi);
        buttonDel = findViewById(R.id.buttonDel);


        getObjectFromPreferences(fauth.getCurrentUser().getUid());


        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teller=0;
                toplamSayi.setText(Integer.toString(teller));
            }
        });

    }

    public void saveObjectToPreferences(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("teller12", teller);
        editor.apply();
    }


    public void getObjectFromPreferences(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        teller = prefs.getInt("teller12", MODE_PRIVATE);
        toplamSayi.setText(String.valueOf(teller));
    }





    @Override
    protected void onPause(){
        super.onPause();
        saveObjectToPreferences(fauth.getCurrentUser().getUid());
    }

}
