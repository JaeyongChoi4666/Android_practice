package com.example.mapapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, AutoPermissionsListener {

    private GoogleMap mMap;
    double latidude;
    double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        AutoPermissions.Companion.loadAllPermissions(this,101);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        startLocationService();
        LatLng busan = new LatLng(35.156, 129.0595);
        LatLng Lotte = new LatLng(35.1569, 129.0566);
        LatLng MyPosition = new LatLng(latidude, longitude);

        mMap.addMarker(new MarkerOptions().position(busan).title("부산 IT 교육센터"));
        mMap.addMarker(new MarkerOptions().position(Lotte).title("롯데 백화점 본점"));
        mMap.addMarker(new MarkerOptions().position(MyPosition).title("내위치"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MyPosition,14));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(busan));
    }

    @Override
    public void onDenied(int i, String[] strings) {

    }

    @Override
    public void onGranted(int i, String[] strings) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this,requestCode,permissions,this);
    }

    private void startLocationService(){
        LocationManager manager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try{
            Location location=manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null){
                latidude=location.getLatitude();
                longitude=location.getLongitude();
            }

            GPSListener gpsListener=new GPSListener();
            long minTime=1000;
            float minDistance=0;
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    minTime,minDistance,gpsListener
            );
        }catch(SecurityException e){
            e.printStackTrace();
        }


    }

    class GPSListener implements LocationListener {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            latidude=location.getLatitude();
            longitude=location.getLongitude();
            LatLng MyPosition = new LatLng(latidude, longitude);
            mMap.addMarker(new MarkerOptions().position(MyPosition).title("내위치"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MyPosition,14));
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
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);

        return true;
    }

}