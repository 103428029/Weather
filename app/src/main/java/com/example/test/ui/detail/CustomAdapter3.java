package com.example.test.ui.detail;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.ui.home.RV3Data;

import java.util.List;

public class CustomAdapter3 extends  RecyclerView.Adapter<CustomAdapter3.ViewHolder>{
    List<RV3Data> rv3DataList;

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

    public CustomAdapter3(List<RV3Data> rv3DataList) {
        this.rv3DataList = rv3DataList;
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
        holder.imgView1.setImageResource(rv3DataList.get(position).getDetailImg());
        holder.txtView2.setText(rv3DataList.get(position).getDetailData());
        holder.txtView3.setText(rv3DataList.get(position).getDetailDesc());
    }

    @Override
    public int getItemCount() {
        return rv3DataList.size();
    }

}
