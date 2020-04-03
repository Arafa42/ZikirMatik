package com.example.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class OzetElhamdulillah extends AppCompatActivity {

    TextView toplamSayi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ozet_elhamdulillah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toplamSayi = findViewById(R.id.zikirTplmSayi);

        SharedPreferences sharedPreferences = getSharedPreferences("myKey2",MODE_PRIVATE);
        String tellerPlus = sharedPreferences.getString("teller","");
        toplamSayi.setText(tellerPlus);

    }
}
