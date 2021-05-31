package com.example.locationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {
    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });
        AutoPermissions.Companion.loadAllPermissions(this,101);
    }

    private void startLocationService(){
        LocationManager manager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try{
            Location location=manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null){
                double latidude=location.getLatitude();
                double longitude=location.getLongitude();
                String message="최근 위치-위도:"+latidude+", 경도:"+longitude+"\n";
                textView.append(message);
            }

            GPSListener gpsListener=new GPSListener();
            long minTime=10000;
            float minDistance=0;
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    minTime,minDistance,gpsListener
            );
            textView.append("내 위치 확인 요청함\n");
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    class GPSListener implements LocationListener{

        @Override
        public void onLocationChanged(@NonNull Location location) {
            double latidude=location.getLatitude();
            double longitude=location.getLongitude();
            String message="최근 위치-위도:"+latidude+", 경도:"+longitude+"\n";
            textView.append(message);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }

    @Override
    public void onDenied(int i, String[] strings) {
        Toast.makeText(this, "위치정보 불러오기 실패",Toast.LENGTH_SHORT);
    }

    @Override
    public void onGranted(int i, String[] strings) {
        Toast.makeText(this, "위치정보 불러오기 성공",Toast.LENGTH_SHORT);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this,requestCode,permissions,this);
    }
}