package com.example.test.ui.home;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

import java.util.List;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.ViewHolder> {
    List<RV2Data> rv2DataList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgView1;
        private TextView txtView2;
        private TextView txtView3;
        private TextView txtView4;

        public ViewHolder(View view) {
            super(view);
            imgView1 = view.findViewById(R.id.dailyWeather1);
            txtView2 = view.findViewById(R.id.dailyWeather2);
            txtView3 = view.findViewById(R.id.dailyWeather3);
            txtView4 = view.findViewById(R.id.dailyWeather4);
        }
    }

    public CustomAdapter2(List<RV2Data> rv2DataList) {
        this.rv2DataList = rv2DataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sample2, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgView1.setImageResource(rv2DataList.get(position).getWeatherImg2());
        holder.txtView2.setText(rv2DataList.get(position).getDayList());
        holder.txtView3.setText(rv2DataList.get(position).getDescriptionList());
        holder.txtView4.setText(rv2DataList.get(position).getTemp2());
    }

    @Override
    public int getItemCount() {
        return rv2DataList.size();
    }
}
