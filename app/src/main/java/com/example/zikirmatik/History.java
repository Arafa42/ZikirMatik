package com.example.zikirmatik;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class History extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setSelectedItemId(R.id.charts);
        listView = findViewById(R.id.listview);


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

    }


}
