package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter progAdapter;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView recyclerView2;
    CustomAdapter2 customAdapter2;
    RecyclerView.LayoutManager layoutManager2;

    int[] weatherImg = {R.drawable.rain, R.drawable.night_storm, R.drawable.night_storm, R.drawable.rain, R.drawable.rain, R.drawable.night_storm};
    String[] temp = {"21℃", "20℃", "19℃", "21℃", "20℃", "22℃"};
    String[] time = {"4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM"};

    int[] weatherImg2 = {R.drawable.rain3, R.drawable.rain4, R.drawable.rain4, R.drawable.rain3};
    String[] dayList = {"Wednesday", "Thursday", "Friday", "Saturday"};
    String[] descriptionList = {"Chance of heavy rain.", "Chance of lightning.", "Chance of lightning.", "Likely to have light rain"};
    String[] temp2 = {"20℃", "21℃", "19℃", "20℃"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy gfgPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(gfgPolicy);

        recyclerView = findViewById(R.id.rvText);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        progAdapter = new CustomAdapter(weatherImg, temp, time);
        recyclerView.setAdapter(progAdapter);

        recyclerView2 = findViewById(R.id.rvText2);
        layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        customAdapter2 = new CustomAdapter2(weatherImg2, dayList, descriptionList, temp2);
        recyclerView2.setAdapter(customAdapter2);

        Spinner spinnerLocation = findViewById(R.id.location_dropdown_menu);
        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.location, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLocation.setAdapter(adapter);

    }

    public void newScreen(View view) {
        Intent in = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(in);
    }

    private class TestAsyncTask extends AsyncTask <String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ProgressDialog p = new ProgressDialog(MainActivity.this);
            p.setMessage("Please wait...");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            URL url;
            HttpURLConnection urlConnection = null;
            StringBuffer readTextBuf = new StringBuffer();

            try {
//            int code = urlConnection.getResponseCode();
//            if (code !=  200) {
//                throw new IOException("Invalid response from server: " + code);
//            }
                url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=ef7d0f574f4f130be5273b3c5e07988d");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    readTextBuf.append(line);
                    line = bufferedReader.readLine();
                }
                System.out.print("oololololo"+line);
            } catch (IOException exception1) {
                exception1.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);

        }
    }
}