package com.atakmap.android.genuasplugin.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="components")
public class ComponentEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String callSign;
    public String type;
    public double longitude;
    public double latitude;

    public ComponentEntity(String callSign, String type, double longitude, double latitude) {
        this.callSign = callSign;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
