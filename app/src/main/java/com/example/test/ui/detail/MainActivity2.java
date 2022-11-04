package com.example.test.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.test.ui.home.CustomAdapter;
import com.example.test.R;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter progAdapter;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView recyclerView2;
    CustomAdapter3 progAdapter2;
    RecyclerView.LayoutManager layoutManager2;


    int[] weatherImg = {R.drawable.rain, R.drawable.night_storm, R.drawable.night_storm, R.drawable.rain, R.drawable.rain, R.drawable.night_storm};
    String[] temp = {"21℃", "20℃", "19℃", "21℃", "20℃", "22℃"};
    String[] time = {"4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM"};

    int[] detailImg1 = {R.drawable.ic_humidity, R.drawable.ic_air_pressure, R.drawable.ic_wind, R.drawable.ic_fog};
    String[] detailData = {"86%", "940hPa","1 km/h", "14%"};
    String[] detailDesc = {"Humidity", "Air Pressure", "Wind Velocity", "Fog"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.rvText3);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        progAdapter = new CustomAdapter(weatherImg, temp, time);
        recyclerView.setAdapter(progAdapter);

        recyclerView2 = findViewById(R.id.rvText4);
        layoutManager2 = new GridLayoutManager(this, 2);
        recyclerView2.setLayoutManager(layoutManager2);
        progAdapter2 = new CustomAdapter3(detailImg1, detailData, detailDesc);
        recyclerView2.setAdapter(progAdapter2);

        ImageView menuIcon = findViewById(R.id.mode_menu);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
    }

    public void homeScreen(View view) {
        finish();
    }

    private void showMenu(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        PopupMenu popupMenu = new PopupMenu(MainActivity2.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.light && isDarkModeOn) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean("isDarkModeOn", false);
                    editor.apply();
                    Toast.makeText(MainActivity2.this, "Light Mode Enabled", Toast.LENGTH_LONG).show();
                    finish();
                }
                if(item.getItemId() == R.id.dark) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean("isDarkModeOn", true);
                    editor.apply();
                    Toast.makeText(MainActivity2.this, "Dark Mode Enabled", Toast.LENGTH_LONG).show();
                    finish();
                }
                return false;
            }
        });
        popupMenu.show();
    }
}