package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements OnPersonItemClickListener{
    ArrayList<Person> items=new ArrayList<Person>();
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.layout1,parent,false);
        return new ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person item=items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Person item){
        items.add(item);
    }
    public void setItems(ArrayList<Person> items){
        this.items=items;
    }

    public Person getItem(int position){
        return items.get(position);
    }
    public void setItem(int position,Person item){
        items.set(position,item);
    }

    public void setOnItemClickListener(OnPersonItemClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onItemClick(ViewHolder viewHolder, View view, int position) {
        if(listener!=null){
            listener.onItemClick(viewHolder,view,position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPhone;

        public ViewHolder(@NonNull View itemView,final OnPersonItemClickListener listener) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvPhone=itemView.findViewById(R.id.tvPhone);
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

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(Person person){
            tvName.setText(person.getName());
            tvPhone.setText(person.getMobile());
        }
    }
}
