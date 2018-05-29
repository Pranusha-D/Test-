package com.example.ppranush.mvpdaggerrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ppranush.mvpdaggerrecyclerview.R;
import com.example.ppranush.mvpdaggerrecyclerview.model.RecyclerViewPojo;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<RecyclerViewPojo> myList;
    public RecyclerViewAdapter(List<RecyclerViewPojo> recyclerViewPojoList) {
        this.myList = recyclerViewPojoList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;
        public ImageView logo;

        public MyViewHolder(View view) {
            super(view);
            logo = (ImageView) view.findViewById(R.id.iv);
            title = (TextView) view.findViewById(R.id.tv_title);
            description = (TextView) view.findViewById(R.id.tv_description);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_layout, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecyclerViewPojo recyclerViewPojo = myList.get(position);
        holder.logo.setImageResource(recyclerViewPojo.getImageView());
        holder.title.setText(recyclerViewPojo.getTitle());
        holder.description.setText(recyclerViewPojo.getDescription());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
