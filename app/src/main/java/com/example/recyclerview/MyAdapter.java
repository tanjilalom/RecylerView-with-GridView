package com.example.recyclerview;

import static com.example.recyclerview.R.layout.samplelayout;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static ClickListener clickListener;
    Context context;
    String[] title, des;
    int [] img;

    public MyAdapter(MainActivity contex, String[] title, String[] des, int[] img) {
        this.context = contex;
        this.title = title;
        this.des = des;
        this.img = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.samplelayout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleview.setText(title[position]);
        holder.desview.setText(des[position]);
        holder.imageview.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        TextView titleview, desview;
        ImageView imageview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleview = itemView.findViewById(R.id.titleview);
            desview = itemView.findViewById(R.id.desview);
            imageview = itemView.findViewById(R.id.imageview);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return false;
        }
    }


    public interface ClickListener{

        void onItemClick (int position, View v);
        void onItemLongClick (int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener){
        MyAdapter.clickListener = clickListener;
    }




}
