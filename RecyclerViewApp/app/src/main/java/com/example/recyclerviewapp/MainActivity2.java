package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    PersonAdapter adapter;
    LinearLayoutManager manager;
    //GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView=findViewById(R.id.recyclerView1);
        adapter=new PersonAdapter();
        //gridLayoutManager=new GridLayoutManager(this,2);
        manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter.addItem(new Person("토니 스타크","010-1111-1111"));
        adapter.addItem(new Person("스티브 로저스","010-2222-2222"));
        adapter.addItem(new Person("브루스 배너","010-3333-3333"));
        adapter.addItem(new Person("피터 파커","010-4444-4444"));
        adapter.addItem(new Person("스티븐 스트레인지","010-5555-5555"));
        adapter.addItem(new Person("닉 퓨리","010-6666-6666"));
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder viewHolder, View view, int position) {
                Person item=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),item.getName(), Toast.LENGTH_SHORT).show();
    //                Intent intent=new Intent(getApplicationContext(),PersonActivity.class);
    //                intent.putExtra("item",item);
    //                startActivity(intent);
            }
        });
    }
}