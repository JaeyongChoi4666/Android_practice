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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.electionapp.vo.Hbj;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProcessViewActivity extends AppCompatActivity {
    ViewPager pager;
    ProcessAdapter adapter;
    TextView tvTitle;
    Button btnVote,btnBack;
    RequestQueue requestQueue;
    ArrayList<Hbj> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_view);

        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }

        Intent intent=getIntent();
        String univ_name=intent.getStringExtra("univ_name");
        String election_name=intent.getStringExtra("election_name");
        int count_candidate=intent.getIntExtra("count_candidate",0);
        String member_id=intent.getStringExtra("member_id");
        tvTitle=findViewById(R.id.electionTitle);
        tvTitle.setText(univ_name+" "+election_name);

        pager=findViewById(R.id.viewPagerProcess);
        adapter=new ProcessAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        hbjInfoRequest(univ_name,election_name,count_candidate);

        btnVote=findViewById(R.id.btnVote);
        btnBack=findViewById(R.id.btnBack);
        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView giho=pager.findViewById(R.id.hbjNum);
                String selected = giho.getText().toString();
                voteToSelectedHbj(univ_name,election_name,member_id,selected);
                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void hbjInfoRequest(String univ_name,String election_name,int count_candidate){
        String url="http://10.100.102.62:8099/searchHbjList?univ_name="+univ_name+"&election_name="+election_name;
        StringRequest Hbjrequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!response.equals("")){
                            Gson gson=new Gson();
                            Hbj[] hbjs=gson.fromJson(response,Hbj[].class);
                            for(int i=0;i< hbjs.length;i++){
                                items.add(hbjs[i]);
                            }
                            for(int i=0;i<count_candidate;i++){
                                ProcessPageFragment fragment=new ProcessPageFragment();
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

    public void voteToSelectedHbj(String univ_name,String election_name,String member_id,String hbj_giho){
        Log.i("univ_name",univ_name);
        Log.i("election_name",election_name);
        Log.i("member_id",member_id);
        Log.i("hbj_giho",hbj_giho);
        String url="http://10.100.102.62:8099/voteToWho";
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("투표후 반환값",response);
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("univ_name",univ_name);
                params.put("election_name",election_name);
                params.put("member_id",member_id);
                params.put("hbj_giho",hbj_giho);
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }
}