package com.example.gallaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    MyGalleryAdapter adapter;
    ImageView imageView;
    int[] ids={R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
            R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");
        gallery=findViewById(R.id.gallery);
        imageView=findViewById(R.id.imageView);
        adapter=new MyGalleryAdapter(this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(ids[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public class MyGalleryAdapter extends BaseAdapter{
        Context context;

        MyGalleryAdapter(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return ids.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView=new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(10,10,10,10);
            imageView.setImageResource(ids[position]);

            return imageView;
        }
    }
}