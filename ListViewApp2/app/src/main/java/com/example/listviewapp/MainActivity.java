package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    MyListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview1);
        adapter=new MyListAdapter(this);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }

    public class MyListAdapter extends BaseAdapter{
        String[] title={"반지의 제왕","겨울왕국","알라딘","극한직업","파프럼홈","엔드게임","엑시트","캡틴마블","나홀로집에","더록"};
        Context context;
        public MyListAdapter(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView=new TextView(context);
            textView.setText(title[position]);
            textView.setLayoutParams(new ViewGroup.LayoutParams(400,100));
            textView.setPadding(10,10,10,10);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(),PosterActivity.class);
                    intent.putExtra("position",position);
                    intent.putExtra("title",title[position]);
                    startActivity(intent);
                }
            });
            return textView;
        }
    }
}