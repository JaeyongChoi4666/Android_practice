package com.example.recyclerviewapp;

import android.view.View;

public interface OnPersonItemClickListener {
    public void onItemClick(PersonAdapter.ViewHolder viewHolder, View view, int position);
}
