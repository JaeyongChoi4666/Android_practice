package com.example.electionapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electionapp.vo.Election;

import java.util.ArrayList;

public class ElectionAdapter extends RecyclerView.Adapter<ElectionAdapter.ViewHolder> implements OnElectionItemClickListener {
    ArrayList<Election> items=new ArrayList<Election>();
    private OnElectionItemClickListener listener;

    @NonNull
    @Override
    public ElectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.electionlayout,parent,false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ElectionAdapter.ViewHolder holder, int position) {
        Election item=items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Election> items) {
        this.items=items;
    }
    public void addItem(Election item){
        items.add(item);
    }
    public Election getItem(int position){
        return items.get(position);
    }

    @Override
    public void onItemClick(ViewHolder viewHolder, View view, int position) {
        if(listener!=null){
            listener.onItemClick(viewHolder,view,position);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvUniv, tvElectionName;

        public ViewHolder(@NonNull View itemView, final OnElectionItemClickListener listener) {
            super(itemView);
            tvUniv=itemView.findViewById(R.id.tvUniv);
            tvElectionName=itemView.findViewById(R.id.tvElectionName);
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
        public void setItem(Election item){
            tvUniv.setText(item.getUniv_name());
            tvElectionName.setText(item.getElection_name());
        }
    }

    public void setOnItemListener(OnElectionItemClickListener listener){
        this.listener=listener;
    }
}
