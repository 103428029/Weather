package com.example.test.ui.home;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.ViewHolder> {
    int[] signList;
    String[] weekDayList;
    String[] descList;
    String[] tempList2;

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

    public CustomAdapter2(int[] signList, String[] weekDayList, String[] descList, String[] tempList2) {
        this.signList = signList;
        this.weekDayList = weekDayList;
        this.descList = descList;
        this.tempList2 = tempList2;
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
        holder.imgView1.setImageResource(signList[position]);
        holder.txtView2.setText(weekDayList[position]);
        holder.txtView3.setText(descList[position]);
        holder.txtView4.setText(tempList2[position]);
    }

    @Override
    public int getItemCount() {
        return signList.length;
    }
}
