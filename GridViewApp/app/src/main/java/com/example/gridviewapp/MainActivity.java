package com.example.gridviewapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    MyGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화포스터");
        gridView=findViewById(R.id.gridView1);
        adapter=new MyGridAdapter(this);
//        MyGridAdapter adapter=new MyGridAdapter(this);
        gridView.setAdapter(adapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        int point=intent.getIntExtra("point",0);
        adapter.setPoint(intent.getIntExtra("point",0),intent.getIntExtra("position",0));
        adapter.notifyDataSetChanged();
        super.onNewIntent(intent);

    }

    //    public class MyGridAdapter extends BaseAdapter{
//        Context context;
//        String[] title={"토이스토리4","호빗,다섯군대의 전투","제이슨본","반지의 제왕","정직한 후보","나쁜녀석들:포에버",
//                "겨울왕국2","알라딘","극한직업","파프럼홈","레옹","주먹왕랄프","타짜:원아이드잭","걸캅스","도굴","엔드게임",
//                "엑시트","캡틴마블","봉오동전투","분노의질주:홉스&쇼"};
//        int[] imgIds={R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
//                R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
//                R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15
//                ,R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20};
//
//        public MyGridAdapter(Context context){
//            this.context=context;
//        }
//
//        @Override
//        public int getCount() {
//            return title.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView imageView=new ImageView(context);
//            imageView.setLayoutParams(new GridView.LayoutParams(300,400));
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageView.setPadding(5,5,5,5);
//            imageView.setImageResource(imgIds[position]);
//
//            final int pos=position;
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    View dlgView=(View) View.inflate(getApplicationContext(),R.layout.dialog,null);
//                    AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
//                    TextView textView=dlgView.findViewById(R.id.textView);
//                    ImageView poster=dlgView.findViewById(R.id.poster);
//                    textView.setText(title[pos]);
//                    poster.setImageResource(imgIds[pos]);
//                    dlg.setTitle("큰 포스터");
//                    dlg.setIcon(R.mipmap.ic_launcher);
//                    dlg.setView(dlgView);
//                    dlg.setNegativeButton("닫기",null);
//                    dlg.show();
//                }
//            });
//
//
//            return imageView;
//        }
//    }
}