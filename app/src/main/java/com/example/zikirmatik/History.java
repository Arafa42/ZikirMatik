package com.example.zikirmatik;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class History extends AppCompatActivity {

    ListView listView;
    int teller=0,teller1=0,teller2=0,teller3=0,teller4=0,teller5=0,teller6=0,teller7=0,teller8=0,teller9=0,teller10=0,teller11=0;
    TextView numara;
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    ImageButton trashcan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setSelectedItemId(R.id.charts);
        listView = findViewById(R.id.listview);
        numara = findViewById(R.id.numara);
        trashcan = findViewById(R.id.trashcan);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Bismillahi Subhanallahi ve Bihamdihi");
        arrayList.add("Lâ ilâhe illallâhu vahdehu lâşerîke leh, lehu'l mülkü ve lehu'l hamdü ve hüve alâ külli şey'in kadîr");
        arrayList.add("Lâ ilâhe illallâhu'l Melikül Hakkul Mübin");
        arrayList.add("Lâ ilâhe illallah");
        arrayList.add("Lâ Havle Velâ Kuvvete İllâ Billâh");
        arrayList.add("Sübhânallahi ve bi–hamdihî sübhânallahi’l–azîm");
        arrayList.add("Sübhânallâhi velhamdülillâhi velâ ilâhe illallahü vallâhü ekber");
        arrayList.add("Estağfirullah");
        arrayList.add("Sübhânallah");
        arrayList.add("Elhamdülillah");
        arrayList.add("Allahu ekber");
        arrayList.add("Esmaül hüsna");



        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){Intent i = new Intent(History.this,OzetBismillahiSubhanallahi.class);startActivity(i);}
                if(position == 1){Intent i = new Intent(History.this,OzetIlahe_Vahdehu.class);startActivity(i);}
                if(position == 2){Intent i = new Intent(History.this,OzetIlahe_Melikul.class);startActivity(i);}
                if(position == 3){Intent i = new Intent(History.this,OzetLaIlaheIllallah.class);startActivity(i);}
                if(position == 4){Intent i = new Intent(History.this,OzetLaHavleVela.class);startActivity(i);}
                if(position == 5){Intent i = new Intent(History.this,OzetSubhanallahiBiHamdihi.class);startActivity(i);}
                if(position == 6){Intent i = new Intent(History.this,OzetSubhanallahiVelhamdulillahi.class);startActivity(i);}
                if(position == 7){Intent i = new Intent(History.this,OzetEstagfirullah.class);startActivity(i);}
                if(position == 8){Intent i = new Intent(History.this,OzetSubhanallah.class);startActivity(i);}
                if(position == 9){Intent i = new Intent(History.this,OzetElhamdulillah.class);startActivity(i);}
                if(position == 10){Intent i = new Intent(History.this,OzetAllahuEkber.class);startActivity(i);}
                if(position == 11){Intent i = new Intent(History.this,OzetEsmaUlHusna.class);startActivity(i);}



            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.history:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.charts:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }

        });

        getObjectFromPreferences(fAuth.getCurrentUser().getUid());


        trashcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teller=0;
                teller1=0;
                teller2=0;
                teller3=0;
                teller4=0;
                teller5=0;
                teller6=0;
                teller7=0;
                teller8=0;
                teller9=0;
                teller10=0;
                teller11=0;
                numara.setText(Integer.toString(teller+teller1+teller2+teller3+teller4+teller5+teller6+teller7+teller8+teller9+teller10+teller11));

            }
        });
    }


    public void saveObjectToPreferences(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("teller1", teller);
        editor.putInt("teller2", teller1);
        editor.putInt("teller3", teller2);
        editor.putInt("teller4", teller3);
        editor.putInt("teller5", teller4);
        editor.putInt("teller6", teller5);
        editor.putInt("teller7", teller6);
        editor.putInt("teller8", teller7);
        editor.putInt("teller9", teller8);
        editor.putInt("teller10", teller9);
        editor.putInt("teller11", teller10);
        editor.putInt("teller12", teller11);
        editor.apply();
    }


    public void getObjectFromPreferences(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        teller = prefs.getInt("teller1", MODE_PRIVATE);
        teller1 = prefs.getInt("teller2", MODE_PRIVATE);
        teller2 = prefs.getInt("teller3", MODE_PRIVATE);
        teller3 = prefs.getInt("teller4", MODE_PRIVATE);
        teller4 = prefs.getInt("teller5", MODE_PRIVATE);
        teller5 = prefs.getInt("teller6", MODE_PRIVATE);
        teller6 = prefs.getInt("teller7", MODE_PRIVATE);
        teller7 = prefs.getInt("teller8", MODE_PRIVATE);
        teller8 = prefs.getInt("teller9", MODE_PRIVATE);
        teller9 = prefs.getInt("teller10", MODE_PRIVATE);
        teller10 = prefs.getInt("teller11", MODE_PRIVATE);
        teller11 = prefs.getInt("teller12", MODE_PRIVATE);

        numara.setText(String.valueOf(teller+teller1+teller2+teller3+teller4+teller5+teller6+teller7+teller8+teller9+teller10+teller11));
    }





    @Override
    protected void onPause(){
        super.onPause();
        saveObjectToPreferences(fAuth.getCurrentUser().getUid());
    }


}
