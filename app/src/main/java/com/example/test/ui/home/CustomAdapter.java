package com.example.test.ui.home;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    List<RV1Data> rv1DataList;

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

    public CustomAdapter(List<RV1Data> rv1DataList) {
        this.rv1DataList = rv1DataList;
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
        RV1Data item = rv1DataList.get(position);
        viewHolder.imageView1.setImageResource(rv1DataList.get(position).getWeatherImg());
        viewHolder.textView2.setText(rv1DataList.get(position).getTemp());
        viewHolder.textView3.setText(rv1DataList.get(position).getTime());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return rv1DataList.size();
    }
}
