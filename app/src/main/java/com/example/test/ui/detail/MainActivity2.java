package com.example.test.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.test.model.Weather;
import com.example.test.ui.home.CustomAdapter;
import com.example.test.R;
import com.example.test.ui.home.RV1Data;
import com.example.test.ui.home.RV3Data;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter programAdapter;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView recyclerView2;
    CustomAdapter3 programAdapter2;
    RecyclerView.LayoutManager layoutManager2;

    Weather weatherData;
    int pressure;
    int humidity;
    String humid = "12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.rvText3);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        List<RV1Data> rv1DataList = new ArrayList<>();
        rv1DataList.add(new RV1Data(R.drawable.rain, "21℃", "4:00 PM"));
        rv1DataList.add(new RV1Data(R.drawable.night_storm, "20℃", "5:00 PM"));
        rv1DataList.add(new RV1Data(R.drawable.night_storm, "19℃", "6:00 PM"));
        rv1DataList.add(new RV1Data(R.drawable.night_storm, "19℃", "6:00 PM"));
        rv1DataList.add(new RV1Data(R.drawable.rain, "20℃", "8:00 PM"));
        rv1DataList.add(new RV1Data(R.drawable.night_storm, "22℃", "9:00 PM"));
        programAdapter = new CustomAdapter(rv1DataList);
        recyclerView.setAdapter(programAdapter);

        recyclerView2 = findViewById(R.id.rvText4);
        layoutManager2 = new GridLayoutManager(this, 2);
        recyclerView2.setLayoutManager(layoutManager2);
        List<RV3Data> rv3DataList = new ArrayList<>();
        rv3DataList.add(new RV3Data(R.drawable.ic_humidity, "86%" , "Humidity"));
        rv3DataList.add(new RV3Data(R.drawable.ic_air_pressure, "940hPa", "Air Pressure"));
        rv3DataList.add(new RV3Data(R.drawable.ic_wind, "1 km/h", "Wind Velocity"));
        rv3DataList.add(new RV3Data(R.drawable.ic_fog, "14%", "Fog"));
        programAdapter2 = new CustomAdapter3(rv3DataList);
        recyclerView2.setAdapter(programAdapter2);

        ImageView menuIcon = findViewById(R.id.mode_menu);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

        new Async().execute();
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

    private class Async extends AsyncTask<Void, String, Weather> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Weather doInBackground(Void... voids) {
            URL url;
            HttpURLConnection urlConnection = null;
            StringBuilder readTextBuf = new StringBuilder();

            try {
                url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=ef7d0f574f4f130be5273b3c5e07988d");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    readTextBuf.append(line);
                }

                int code = urlConnection.getResponseCode();
                if (code !=  200) {throw new IOException("Invalid response from server: " + code);}

                Gson gson = new Gson();
                JsonParser parser = new JsonParser();
                Object reader = parser.parse(readTextBuf.toString());
                String inputWeather = reader.toString();
                weatherData = gson.fromJson(inputWeather, Weather.class);
            } catch (IOException exception1) {
                exception1.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return weatherData;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);
            humidity = weatherData.getMain().getHumidity();
            humid = String.valueOf(weatherData.getMain().getHumidity());
            System.out.println(humid);
            pressure = weatherData.getMain().getPressure();
        }
    }
}