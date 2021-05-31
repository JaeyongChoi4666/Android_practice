package com.example.gridviewapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyGridAdapter extends BaseAdapter {
    Context context;
    String[] title={"토이스토리4","호빗,다섯군대의 전투","제이슨본","반지의 제왕","정직한 후보","나쁜녀석들:포에버",
            "겨울왕국2","알라딘","극한직업","파프럼홈","레옹","주먹왕랄프","타짜:원아이드잭","걸캅스","도굴","엔드게임",
            "엑시트","캡틴마블","봉오동전투","분노의질주:홉스&쇼"};
    int[] imgIds={R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
            R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
            R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15
            ,R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20};
    double[] points={0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};

    public MyGridAdapter(Context context){
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewGroup viewGroup=(ViewGroup) ViewGroup.inflate(context,R.layout.sublayout,null);
        TextView titleView=viewGroup.findViewById(R.id.uptextView);
        ImageView imageView=viewGroup.findViewById(R.id.imageView);
        TextView pointView=viewGroup.findViewById(R.id.downtextView);

        titleView.setText(title[position]);
        imageView.setImageResource(imgIds[position]);
        pointView.setText("평점:"+points[position]);

        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MovieActivity.class);
                intent.putExtra("imgId",imgIds[position]);
                intent.putExtra("title",title[position]);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });
        return viewGroup;
    }
    public void setPoint(int point,int position){
        this.points[position]=point;
    }

}
