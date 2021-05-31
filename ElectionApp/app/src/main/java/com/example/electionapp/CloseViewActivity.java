package com.example.electionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.electionapp.vo.Hbj;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CloseViewActivity extends AppCompatActivity {
    ViewPager pager;
    CloseAdapter adapter;
    TextView electionTitle;
    Button btnBack;
    RequestQueue requestQueue;
    ArrayList<Hbj> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close_view);

        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }

        Intent intent=getIntent();
        String univ_name=intent.getStringExtra("univ_name");
        String election_name=intent.getStringExtra("election_name");
        int count_candidate=intent.getIntExtra("count_candidate",0);
        int election_winner_code=intent.getIntExtra("election_winner_code",0);
        electionTitle=findViewById(R.id.electionTitle);
        electionTitle.setText(univ_name+" "+election_name);

        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pager=findViewById(R.id.viewPagerClose);
        adapter=new CloseAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        hbjInfoRequest(univ_name,election_name,count_candidate,election_winner_code);
    }

    public void hbjInfoRequest(String univ_name,String election_name,int count_candidate,int election_winner_code){
        String url="http://10.100.102.62:8099/searchHbjList?univ_name="+univ_name+"&election_name="+election_name;
        StringRequest Hbjrequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("onResponse:",response);
                        if(!response.equals("")){
                            Gson gson=new Gson();
                            Hbj[] hbjs=gson.fromJson(response,Hbj[].class);
                            for(int i=0;i< hbjs.length;i++){
                                items.add(hbjs[i]);
                            }
                            for(int i=0;i<count_candidate;i++){
                                ClosePageFragment fragment=new ClosePageFragment();
                                Bundle bundle=new Bundle();
                                bundle.putString("univ_name",univ_name);
                                bundle.putString("election_name",election_name);
                                bundle.putString("hbj_name",items.get(i).getHbj_name());
                                bundle.putString("hbj_gender",items.get(i).getHbj_gender());
                                bundle.putString("hbj_grade",items.get(i).getHbj_grade());
                                bundle.putString("hbj_giho",items.get(i).getHbj_giho());
                                bundle.putString("hbj_prom1",items.get(i).getHbj_prom1());
                                bundle.putString("hbj_prom2",items.get(i).getHbj_prom2());
                                bundle.putString("hbj_prom3",items.get(i).getHbj_prom3());
                                bundle.putInt("picNum",i+1);
                                bundle.putInt("hbj_vote",items.get(i).getHbj_vote());
                                bundle.putInt("hbj_code",items.get(i).getHbj_code());
                                bundle.putInt("election_winner_code",election_winner_code);
                                fragment.setArguments(bundle);
                                adapter.addItem(fragment);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"알 수 없는 에러가 발생했습니다",Toast.LENGTH_LONG).show();
            }
        });
        Hbjrequest.setShouldCache(false);
        requestQueue.add(Hbjrequest);
    }
}