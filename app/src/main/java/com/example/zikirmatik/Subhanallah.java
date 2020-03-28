package com.example.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Subhanallah extends AppCompatActivity {

    Button tellerKnopPlus,tellerKnopMin;
    TextView tellerText;
    int teller=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subhanallah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tellerKnopPlus = findViewById(R.id.buttonPlus);
        tellerKnopMin = findViewById(R.id.buttonMin);
        tellerText = findViewById(R.id.nummer10);


        tellerKnopPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                teller++;
                tellerText.setText(Integer.toString(teller));

            }
        });

        tellerKnopMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(teller > 0) {
                    teller--;
                    tellerText.setText(Integer.toString(teller));
                }
            }
        });



    LoadData();

    }


    public void saveData(){


        SharedPreferences sharedPreferences = getSharedPreferences("saveTeller10",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("tellerWaarde10",teller);
        editor.apply();
    }



    public void LoadData(){

        SharedPreferences sharedPreferences = getSharedPreferences("saveTeller10",MODE_PRIVATE);
        teller = sharedPreferences.getInt("tellerWaarde10",MODE_PRIVATE);

        tellerText.setText(String.valueOf(teller));


    }



    @Override
    protected void onPause(){
        super.onPause();
        saveData();
    }
}
