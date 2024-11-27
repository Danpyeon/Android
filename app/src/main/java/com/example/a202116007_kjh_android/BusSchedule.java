package com.example.a202116007_kjh_android;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class BusSchedule {
    private String departureTime;
    private String destination;
    private String busType;

    public BusSchedule(String departureTime, String destination, String busType) {
        this.departureTime = departureTime;
        this.destination = destination;
        this.busType = busType;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getBusType() {
        return busType;
    }
}



