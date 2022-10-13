package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AutoCompleteTextView;

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

}