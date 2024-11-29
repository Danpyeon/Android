package com.example.a202116007_kjh_android;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class BusSchedule {
    private String time;
    private String location;
    private String bus;

    public BusSchedule(String time, String location, String bus) {
        this.time = time;
        this.location = location;
        this.bus = bus;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getBus() {
        return bus;
    }
}



