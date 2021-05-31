package com.example.electionapp;

import android.view.View;

public interface OnElectionItemClickListener {
    public void onItemClick(ElectionAdapter.ViewHolder viewHolder, View view, int position);
}
