package com.wordpress.medicourses.cursointroductoriocienciassalud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder>{

    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageViewIcon;
        public TextView openSection;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
            openSection = (TextView) itemView.findViewById(R.id.opensection);
        }
    }

    public CustomeAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {

        viewHolder.textViewName.setText(dataSet.get(i).getName());
        viewHolder.imageViewIcon.setImageResource(dataSet.get(i).getImage());
        viewHolder.openSection.setId(dataSet.get(i).getId());
    }
}
