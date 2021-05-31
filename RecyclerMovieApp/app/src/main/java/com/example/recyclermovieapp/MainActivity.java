package com.example.recyclermovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    GridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView1);
        adapter=new MovieAdapter();
        manager=new GridLayoutManager(this,3);

        adapter.addItem(new Movie("mov01",R.drawable.mov01));
        adapter.addItem(new Movie("mov02",R.drawable.mov02));
        adapter.addItem(new Movie("mov03",R.drawable.mov03));
        adapter.addItem(new Movie("mov04",R.drawable.mov04));
        adapter.addItem(new Movie("mov05",R.drawable.mov05));
        adapter.addItem(new Movie("mov06",R.drawable.mov06));
        adapter.addItem(new Movie("mov07",R.drawable.mov07));
        adapter.addItem(new Movie("mov08",R.drawable.mov08));
        adapter.addItem(new Movie("mov09",R.drawable.mov09));
        adapter.addItem(new Movie("mov10",R.drawable.mov10));
        adapter.addItem(new Movie("mov11",R.drawable.mov11));
        adapter.addItem(new Movie("mov12",R.drawable.mov12));
        adapter.addItem(new Movie("mov13",R.drawable.mov13));
        adapter.addItem(new Movie("mov14",R.drawable.mov14));
        adapter.addItem(new Movie("mov15",R.drawable.mov15));
        adapter.addItem(new Movie("mov16",R.drawable.mov16));
        adapter.addItem(new Movie("mov17",R.drawable.mov17));
        adapter.addItem(new Movie("mov18",R.drawable.mov18));

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnMovieItemClickListener() {
            @Override
            public void onItemClick(MovieAdapter.ViewHolder holder, View view, int position) {
                Movie item=adapter.getItem(position);
                String mvName=item.getMvName();
                int poster=item.getPoster();
                Intent intent=new Intent(getApplicationContext(),MovieActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("mvName",mvName);
                intent.putExtra("poster",poster);
                Toast.makeText(getApplicationContext(),item.getMvName(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}