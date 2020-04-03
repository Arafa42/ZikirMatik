package com.example.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class OzetLaIlaheIllallah extends AppCompatActivity {

    TextView toplamSayi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ozet_la_ilahe_illallah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        toplamSayi = findViewById(R.id.zikirTplmSayi);

        SharedPreferences sharedPreferences = getSharedPreferences("myKey8",MODE_PRIVATE);
        String tellerPlus = sharedPreferences.getString("teller","");
        toplamSayi.setText(tellerPlus);

    }
}
