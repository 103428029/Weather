package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    DayWeather dayWeather;
    int[] weatherList;
    String[] tempList;
    String[] timeList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView1;
        private TextView textView2;
        
        private TextView textView3;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            imageView1 = view.findViewById(R.id.dayWeather);
            textView2 = view.findViewById(R.id.dayTemp);
            textView3 = view.findViewById(R.id.dayTime);
        }
    }

    public CustomAdapter(int[] weatherList, String[] tempList, String[] timeList) {
        this.weatherList = weatherList;
        this.tempList = tempList;
        this.timeList = timeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.imageView1.setImageResource(weatherList[position]);
        viewHolder.textView2.setText(tempList[position]);
        viewHolder.textView3.setText(timeList[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return weatherList.length;
    }
}
