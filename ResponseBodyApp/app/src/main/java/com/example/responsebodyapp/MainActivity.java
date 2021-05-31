package com.example.responsebodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn1,btn2,btn3;
    TextView textView;
    static RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edText);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        textView=findViewById(R.id.textView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receiveMakeRequest();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMakeRequest();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boardListMakeRequest();
            }
        });
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }
    }

    private void receiveMakeRequest(){
        String url="http://10.100.102.62:8099/androidGet?bno="+editText.getText().toString();
        //String url="https://literate-t.tistory.com/54";
        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println(error.getMessage());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }

    private void sendMakeRequest(){
        String url="http://10.100.102.62:8099/androidPost";
        //String url="https://developer.android.com/training/volley?hl=ko";
        StringRequest request=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println(error.getMessage());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>();
                params.put("title","해리포터");
                params.put("content","호그와트에서 일어나는 일");
                params.put("writer","조앤.K.롤링");
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }

    private void boardListMakeRequest(){
        String url="http://10.100.102.62:8099/boardList";
        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        process(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println(error.getMessage());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }

    private void process(String response){
        Gson gson=new Gson();
        Board[] boards=gson.fromJson(response,Board[].class);
        for(int i=0;i<boards.length;i++){
            textView.append("bno: "+boards[i].getBno()+"\n");
            textView.append("title: "+boards[i].getTitle()+"\n");
            textView.append("content: "+boards[i].getContent()+"\n");
            textView.append("writer: "+boards[i].getWriter()+"\n");
        }
    }

    private void println(String str){
        textView.append(str+"\n");
    }
}