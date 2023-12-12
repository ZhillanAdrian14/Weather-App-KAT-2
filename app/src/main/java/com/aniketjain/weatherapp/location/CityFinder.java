package com.aniketjain.weatherapp.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CityFinder {

    public static void setLongitudeLatitude(Location location) {
        try {
            if (location != null) {
                LocationCord.lat = String.valueOf(location.getLatitude());
                LocationCord.lon = String.valueOf(location.getLongitude());
                Log.d("location_lat", LocationCord.lat);
                Log.d("location_lon", LocationCord.lon);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static String getCityNameUsingNetwork(Context context, Location location) {
        String city = "";
        try {
            if (location != null) {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (addresses != null && addresses.size() > 0) {
                    city = addresses.get(0).getLocality();
                    Log.d("city", city);
                } else {
                    Log.d("city", "City not found");
                }
            }
        } catch (IOException e) {
            Log.e("city", "Error while finding the city.", e);
        }
        return city;
    }
}
