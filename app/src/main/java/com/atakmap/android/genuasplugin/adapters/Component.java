package com.atakmap.android.genuasplugin.adapters;

import android.location.Location;

public class Component {
    private String callSign;
    private String type;
    private double longitude;
    private double latitude;

    public Component(String callSign, String type, double longitude, double latitude) {
        this.callSign = callSign;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getCallSign() {
        return callSign;
    }

    public String getType() {
        return type;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
