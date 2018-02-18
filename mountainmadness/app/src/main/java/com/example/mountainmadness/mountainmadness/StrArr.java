package com.example.mountainmadness.mountainmadness;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Ryan1 on 2/18/2018.
 */

public class StrArr {
    public static boolean render_flag = false;
    public static ArrayList<String> strArr = new ArrayList<String>(0);
    public static ArrayList<LatLng> LatLngArr = new ArrayList<LatLng>(0);
    //Arrays.asList("a", "b", "c", "d", "e")
    public static void addBack(String s, LatLng ll){
        if(strArr.size()==0){
            strArr.add(s);
            LatLngArr.add(ll);
        }
        String x = strArr.get(strArr.size()-1).toString();
        if( s.compareTo(x)!=0){
            strArr.add(s);
            LatLngArr.add(ll);
        }
    }

}
