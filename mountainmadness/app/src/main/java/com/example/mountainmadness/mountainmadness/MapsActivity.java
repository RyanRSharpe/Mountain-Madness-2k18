package com.example.mountainmadness.mountainmadness;

import android.location.Location;
import android.os.Bundle;
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

    final Task<Location> loc;
        final boolean flag1 = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0;
        final boolean flag2 = ContextCompat.checkSelfPermission(this,"android.permission.ACCESS_COARSE_LOCATION") == 0;
     if(flag1 && flag2){
//        loc = mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
//        @Override
//        public void onSuccess(Location location) {
//            // Got last known location. In some rare situations this can be null.
//            if (location != null) {
//                // Logic to handle location object
//            }
//        }
//        });
//        if(loc == null){
//            Toast.makeText(this, "Badder Shit", Toast.LENGTH_SHORT).show();
//        }else{
//        final Location l = loc.getResult();
//        Button butt = findViewById(R.id.map_button);
//        butt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MapsActivity.this, l.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });}
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
        else{
         Button butt = findViewById(R.id.map_button);
         butt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(MapsActivity.this, Boolean.toString(flag1) + " " + Boolean.toString(flag2), Toast.LENGTH_SHORT).show();
             }
         });

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
    }
}
