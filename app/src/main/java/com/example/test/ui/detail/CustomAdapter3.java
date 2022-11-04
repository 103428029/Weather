package com.example.test.ui.detail;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

public class CustomAdapter3 extends  RecyclerView.Adapter<CustomAdapter3.ViewHolder>{
    int[] condImgList;
    String[] condFigureList;
    String[] condDescList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgView1;
        private TextView txtView2;
        private  TextView txtView3;

        public ViewHolder(View view) {
            super(view);
            imgView1 = view.findViewById(R.id.condImg);
            txtView2 = view.findViewById(R.id.condFigure);
            txtView3 = view.findViewById(R.id.condDesc);
        }
    }

    public CustomAdapter3(int[] condImgList, String[] condFigureList, String[] condDescList) {
        this.condImgList = condImgList;
        this.condFigureList = condFigureList;
        this.condDescList = condDescList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sample3, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgView1.setImageResource(condImgList[position]);
        holder.txtView2.setText(condFigureList[position]);
        holder.txtView3.setText(condDescList[position]);
    }

    @Override
    public int getItemCount() {
        return condImgList.length;
    }

}
