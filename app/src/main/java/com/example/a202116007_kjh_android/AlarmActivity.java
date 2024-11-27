package com.example.a202116007_kjh_android;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlarmActivity extends AppCompatActivity {
    private RecyclerView favoritesRecyclerView;
    private FavoritesAdapter favoritesAdapter;
    private List<BusSchedule> favoriteSchedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        favoritesRecyclerView = findViewById(R.id.recyclerViewFavorites);
        favoriteSchedules = loadFavoriteSchedules();

        favoritesAdapter = new FavoritesAdapter(favoriteSchedules, this::setAlarm);
        favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        favoritesRecyclerView.setAdapter(favoritesAdapter);
    }

    private List<BusSchedule> loadFavoriteSchedules() {
        // 로컬 데이터에서 즐겨찾기한 시간표 로드 (간단히 예시 데이터 사용)
        List<BusSchedule> schedules = new ArrayList<>();
        schedules.add(new BusSchedule("08:25", "청춘관", "B호차"));
        // 추가 데이터...
        return schedules;
    }

    private void setAlarm(BusSchedule schedule) {
        // 알람 설정 (예: 버스 출발 10분 전 알림)
        Calendar calendar = Calendar.getInstance();
        String[] timeParts = schedule.getDepartureTime().split(":");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeParts[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(timeParts[1]) - 10);

        Intent intent = new Intent(AlarmActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(this, schedule.getDepartureTime() + "에 알람이 설정되었습니다.", Toast.LENGTH_SHORT).show();
    }
}
