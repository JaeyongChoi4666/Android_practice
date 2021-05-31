package com.example.electionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.electionapp.vo.Dept;
import com.example.electionapp.vo.Member;
import com.example.electionapp.vo.Univ;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends AppCompatActivity {
    Button btnJoin, btnCancel;
    EditText edUserName,edUserNumber,edUserID,edUserPW;
    RequestQueue requestQueue;

    ArrayList<String> univList=new ArrayList<>();
    ArrayList<String> deptList=new ArrayList<>();
    ArrayAdapter<String> univAdapter;
    ArrayAdapter<String> deptAdapter;
    Spinner univSpinner,deptSpinner,gradeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        univSpinner = findViewById(R.id.spinnerUniv);
        getUnivList();
        univAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,univList);
        univSpinner.setAdapter(univAdapter);

        univSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                deptSpinner = findViewById(R.id.spinnerDept);
                getDeptList(univList.get(position));
                deptAdapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,deptList);
                deptSpinner.setAdapter(deptAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gradeSpinner = findViewById(R.id.spinnerGrade);
        ArrayAdapter gradeAdapter = ArrayAdapter.createFromResource(this,
                R.array.grade, android.R.layout.simple_spinner_item);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(gradeAdapter);

        btnJoin=findViewById(R.id.btnJoin);
        btnCancel=findViewById(R.id.btnCancel);
        edUserName=findViewById(R.id.edUserName);
        edUserNumber=findViewById(R.id.edUserNumber);
        edUserID=findViewById(R.id.edUserID);
        edUserPW=findViewById(R.id.edUserPW);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinRequest();
                Intent mainIntent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }

    private void getUnivList(){
        String url="http://10.100.102.62:8099/univGet";
        StringRequest requestUniv=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.equals("")){
                    Gson gson=new Gson();
                    Univ[] univ=gson.fromJson(response,Univ[].class);
                    for(int i=0;i<univ.length;i++){
                        univList.add(univ[i].getUniv_name());
                    }
                    univAdapter.notifyDataSetChanged();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"알 수 없는 에러가 발생했습니다",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        requestUniv.setShouldCache(false);
        requestQueue.add(requestUniv);
    }

    private void getDeptList(String univ_name){
        String url="http://10.100.102.62:8099/deptGet?univ_name="+univ_name;
        StringRequest requestDept=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!response.equals("")){
                            Gson gson=new Gson();
                            Dept[] dept=gson.fromJson(response,Dept[].class);
                            deptList.clear();
                            for(int i=0;i<dept.length;i++){
                                deptList.add(dept[i].getDept_name());
                            }
                            deptAdapter.notifyDataSetChanged();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"알 수 없는 에러가 발생했습니다",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        requestDept.setShouldCache(false);
        requestQueue.add(requestDept);
    }

    private void joinRequest(){
        String member_id=edUserID.getText().toString();
        String member_pw=edUserPW.getText().toString();
        String univ_name=univSpinner.getSelectedItem().toString();
        String dept_name=deptSpinner.getSelectedItem().toString();
        String member_name=edUserName.getText().toString();
        String member_number=edUserNumber.getText().toString();
        String member_grade=gradeSpinner.getSelectedItem().toString();

        String url="http://10.100.102.62:8099/joinPost";
        StringRequest requestJoin=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("1")){
                    Toast.makeText(getApplicationContext(),"정상적으로 회원가입이 완료되었습니다",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"회원가입에 실패하였습니다",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"알 수 없는 에러가 발생했습니다",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("member_id",member_id);
                params.put("member_pw",member_pw);
                params.put("univ_name",univ_name);
                params.put("dept_name",dept_name);
                params.put("member_name",member_name);
                params.put("member_number",member_number);
                params.put("member_grade",member_grade);
                return params;
            }
        };
        requestJoin.setShouldCache(false);
        requestQueue.add(requestJoin);
    }
}