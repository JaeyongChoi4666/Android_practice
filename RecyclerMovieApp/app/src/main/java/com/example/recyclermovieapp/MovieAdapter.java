package com.example.recyclermovieapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> implements OnMovieItemClickListener{
    ArrayList<Movie> items=new ArrayList<Movie>();
    OnMovieItemClickListener listener;

    public void setOnItemClickListener(OnMovieItemClickListener listener){
        this.listener=listener;
    }

    public Movie getItem(int position){
        return items.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View movieView=inflater.inflate(R.layout.sublayout,parent,false);
        return new ViewHolder(movieView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie item=items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(Movie item){
        items.add(item);
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener!=null){
            listener.onItemClick(holder,view,position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView,final OnMovieItemClickListener listener) {
            super(itemView);
            textTitle=itemView.findViewById(R.id.textTitle);
            imageView=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(listener!=null){
                        listener.onItemClick(ViewHolder.this,v,position);
                    }
                }
            });
        }

        public void setItem(Movie item){
            textTitle.setText(item.getMvName());
            imageView.setImageResource(item.getPoster());
        }
    }
}
