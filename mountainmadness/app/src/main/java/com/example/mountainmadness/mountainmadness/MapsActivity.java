package com.example.mountainmadness.mountainmadness;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        String msg = "test";

        FloatingActionButton glcfab = (FloatingActionButton) findViewById(R.id.gCL);
        glcfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent startIntent = new Intent(getApplicationContext(), glcActivity.class);
                startActivity(startIntent);
            }
        });

        final Task<Location> loc;
        final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
        int i = 10;
        while(i==10) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

            } else {
                i=9;
            }
        }

        loc = mFusedLocationClient.getLastLocation();
        if(loc == null){
            //Toast.makeText(MapsActivity.this, "last loc null", Toast.LENGTH_SHORT).show();
            Button butt = findViewById(R.id.map_button);
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MapsActivity.this,"last loc null", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Button butt = findViewById(R.id.map_button);
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MapsActivity.this, loc.getResult().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            //Toast.makeText(this, loc.toString(), Toast.LENGTH_SHORT).show();
        }



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


        // Add a marker in Sydney and move the camera
        LatLng SFU = new LatLng(49, -122);
        mMap.addMarker(new MarkerOptions().position(SFU).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SFU));

//        int i = 0;
//        LatLng current = new LatLng(0,0);
//        double latitude = 0;
//        double longitude = 0;
//        while(StrArr.LatLngArr.size() > i){
//            latitude = StrArr.LatLngArr[i].get(latitude);
//            mMap.addMarker (new MarkerOptions().position().title(i));
//            i++;
//        }
    }
}
