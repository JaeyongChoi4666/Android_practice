package com.example.electionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.electionapp.vo.Member;
import com.google.gson.Gson;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText edID, edPW;
    Button btnLogin, btnJoin;
    RequestQueue requestQueue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edID=findViewById(R.id.edUserID);
        edPW=findViewById(R.id.edPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnJoin=findViewById(R.id.btnJoin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginConfirmRequest(edID.getText().toString(), edPW.getText().toString());
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent joinIntent=new Intent(getApplicationContext(),JoinActivity.class);
                startActivity(joinIntent);
            }
        });

        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }
    }

    private void loginConfirmRequest(String ID, String PW){
        String url="http://10.100.102.62:8099/loginGet?ID="+ID+"&PW="+PW;
        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.equals("")){
                    Gson gson=new Gson();
                    Member member=gson.fromJson(response,Member.class);
                    Intent main2Intent=new Intent(LoginActivity.this,MainActivity2.class);
                    main2Intent.putExtra("member_id",member.getMember_id());
                    main2Intent.putExtra("univ_name",member.getUniv_name());
                    main2Intent.putExtra("dept_name",member.getDept_name());
                    main2Intent.putExtra("member_name",member.getMember_name());
                    main2Intent.putExtra("member_number",member.getMember_number());
                    main2Intent.putExtra("member_grade",member.getMember_grade());
                    startActivity(main2Intent);
                }else{
                    Toast.makeText(getApplicationContext(),"회원가입을 하지 않았거나 암호가 틀렸습니다",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"알 수 없는 에러가 발생했습니다",Toast.LENGTH_LONG).show();
            }
        });
        request.setShouldCache(false);
        requestQueue.add(request);
    }
}