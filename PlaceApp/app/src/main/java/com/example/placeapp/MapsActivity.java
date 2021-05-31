package com.example.placeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setTitle("구글 지도 활용");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        LatLng busan = new LatLng(35.156, 129.0595);
        LatLng LotteDpt = new LatLng(35.1569, 129.0564);
        LatLng bexco = new LatLng(35.1686, 129.1360);
        LatLng arcticPole = new LatLng(-90, 0);

        mMap.addMarker(new MarkerOptions().position(busan).title("부산IT교육센터"));
        mMap.addMarker(new MarkerOptions().position(LotteDpt).title("롯데백화점"));
        mMap.addMarker(new MarkerOptions().position(bexco).title("벡스코"));
        mMap.addMarker(new MarkerOptions().position(arcticPole).title("남극점"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(busan,14));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(busan));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"위성지도");
        menu.add(0,2,0,"일반지도");
        SubMenu subMenu=menu.addSubMenu("사용자 등록지점");
        subMenu.add(0,3,0,"부산IT교육센터");
        subMenu.add(0,4,0,"롯데백화점");
        subMenu.add(0,5,0,"벡스코");
        subMenu.add(0,6,0,"남극점");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.1558, 129.0595),17));
                return true;
            case 4:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.1569, 129.0564),17));
                return true;
            case 5:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.1686, 129.1360),17));
                return true;
            case 6:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-89.9524, 94.0618),12));
                return true;
        }
        return false;
    }
}