package com.example.toastapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText edNum1, edNum2;
    TextView tv;
    ProgressBar progressBar;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNum1=findViewById(R.id.editTextNumber);
        edNum2=findViewById(R.id.editTextNumber2);
        tv=findViewById(R.id.editText);
        progressBar=findViewById(R.id.progressBar2);
        progressBar.setIndeterminate(false);
        progressBar.setProgress(80);

    }
    public void onButtonPro(View view){
        switch (view.getId()){
            case R.id.leftBtn:
                progressDialog=new ProgressDialog(this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("데이터를 확인하는 중");
                progressDialog.show();
            case R.id.rightBtn:
                if(progressDialog!=null){
                    progressDialog.dismiss();
                }
        }
    }

    public void onButtonClicked(View view){
        Snackbar.make(view,"스낵바입니다",Snackbar.LENGTH_SHORT).show();

//        LayoutInflater inflater=getLayoutInflater();
//        View layout=inflater.inflate(R.layout.toastboard,findViewById(R.id.toast_layout));
//        TextView tV=layout.findViewById(R.id.tV);
//        Toast toast=new Toast(this);
//        tV.setText("모양바꾼 토스트");
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setView(layout);
//        toast.show();

//        try {
//            Toast toastView=Toast.makeText(this,"위치가 바뀐 토스트 메시지입니다",Toast.LENGTH_SHORT);
//            int xOffset=Integer.parseInt(edNum1.getText().toString());
//            int yOffset=Integer.parseInt(edNum2.getText().toString());
//            toastView.setGravity(Gravity.TOP|Gravity.LEFT,xOffset,yOffset);
//            toastView.show();
//        }catch (NumberFormatException e){
//            e.printStackTrace();
//        }
    }

    public void onDialogBtnClicked(View view){
        AlertDialog.Builder dlg=new AlertDialog.Builder(this);
        dlg.setTitle("안내");
        dlg.setMessage("정말 종료하시겠습니까?");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("예 버튼을 눌렀습니다");
            }
        });
        dlg.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("아니오 버튼을 눌렀습니다");
            }
        });
        dlg.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("취소 버튼을 눌렀습니다");
            }
        });
        AlertDialog dialog=dlg.create();
        dialog.show();
    }
}