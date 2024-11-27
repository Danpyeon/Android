package com.example.a202116007_kjh_android;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 알람이 발생했을 때 사용자에게 알림
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager != null) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "bus_alarm_channel")
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setContentTitle("버스 출발 알림")
                    .setContentText("버스가 곧 출발합니다.")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true);

            notificationManager.notify(1, builder.build());
        }
    }
}
