package com.example.electionapp.ui.close;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.electionapp.CloseViewActivity;
import com.example.electionapp.ElectionAdapter;
import com.example.electionapp.OnElectionItemClickListener;
import com.example.electionapp.ProcessViewActivity;
import com.example.electionapp.R;
import com.example.electionapp.vo.Election;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CloseFragment extends Fragment {
    ElectionAdapter adapter;
    RequestQueue requestQueue;
    ArrayList<Election> items=new ArrayList<>();

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getContext());
        }
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_close, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_close);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Bundle bundle=getArguments();
        String univ_name=bundle.getString("univ_name");
        getElectionList(univ_name);
        adapter = new ElectionAdapter();
        adapter.setItems(items);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemListener(new OnElectionItemClickListener() {
            @Override
            public void onItemClick(ElectionAdapter.ViewHolder viewHolder, View view, int position) {
                Intent closeIntent=new Intent(getContext(), CloseViewActivity.class);
                closeIntent.putExtra("univ_name", univ_name);
                closeIntent.putExtra("election_name", items.get(position).getElection_name());
                closeIntent.putExtra("count_candidate", items.get(position).getCount_candidate());
                closeIntent.putExtra("election_winner_code", items.get(position).getWinner_code());
                Log.i("intent winner:",items.get(position).getWinner_code()+"");
                startActivity(closeIntent);
            }
        });
        return rootView;
    }

    public void getElectionList(String univ_name){
        String url="http://10.100.102.62:8099/closeElectionList?univ_name="+univ_name;
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.equals("")){
                    Gson gson=new Gson();
                    Election[] elections=gson.fromJson(response,Election[].class);
                    for(int i=0;i<elections.length;i++) {
                        items.add(elections[i]);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setShouldCache(false);
        requestQueue.add(request);
    }
}