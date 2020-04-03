package com.example.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class OzetAllahuEkber extends AppCompatActivity {

    TextView toplamSayi;
    ImageButton buttonDel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ozet_allahu_ekber);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toplamSayi = findViewById(R.id.zikirTplmSayi);
        buttonDel = findViewById(R.id.buttonDel);

        SharedPreferences sharedPreferences = getSharedPreferences("myKey",MODE_PRIVATE);
        String tellerPlus = sharedPreferences.getString("teller","0");
        toplamSayi.setText(tellerPlus);


        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toplamSayi.setText("0");

            }
        });



    }
}
