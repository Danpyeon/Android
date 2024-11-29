package com.example.a202116007_kjh_android;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    private TextView textViewTime;
    private TextView textViewNextBus;
    private List<BusSchedule> schedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textViewWelcome = findViewById(R.id.textViewWelcome);

        // 전달된 학번과 이름 데이터를 Intent로 받기
        String userId = getIntent().getStringExtra("USER_ID");
        String userName = getIntent().getStringExtra("USER_NAME");

        // 환영 메시지 출력
        String welcomeMessage = "환영합니다, " + userName + "님! (학번: " + userId + ")";
        textViewWelcome.setText(welcomeMessage);

        // 시간표 초기화
        schedules = new ArrayList<>();
        initializeSchedules();

        // 현재 시간 업데이트
        updateCurrentTime();

        // 가장 가까운 버스 시간 찾기
        updateNextBusInfo();
    }

    private void initializeSchedules() {
        //오전
        schedules.add(new BusSchedule("08:00", "학교", "A호차"));
        schedules.add(new BusSchedule("08:05", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("08:10", "청춘관", "A호차"));
        schedules.add(new BusSchedule("08:25", "학교", "A호차"));
        schedules.add(new BusSchedule("08:30", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("08:35", "청춘관", "A호차"));
        schedules.add(new BusSchedule("08:40", "학교", "A호차"));
        schedules.add(new BusSchedule("08:45", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("08:50", "청춘관", "A호차"));
        schedules.add(new BusSchedule("08:15", "학교", "B호차"));
        schedules.add(new BusSchedule("08:20", "청춘관", "B호차"));
        schedules.add(new BusSchedule("08:40", "학교", "B호차"));
        schedules.add(new BusSchedule("08:50", "청춘관", "B호차"));
        schedules.add(new BusSchedule("09:20", "학교", "A호차"));
        schedules.add(new BusSchedule("09:25", "청춘관", "A호차"));
        schedules.add(new BusSchedule("09:40", "학교", "A호차"));
        schedules.add(new BusSchedule("09:45", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("09:50", "청춘관", "A호차"));
        schedules.add(new BusSchedule("10:30", "학교", "A호차"));
        schedules.add(new BusSchedule("10:35", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("10:40", "청춘관", "A호차"));
        schedules.add(new BusSchedule("11:30", "학교", "A호차"));
        schedules.add(new BusSchedule("11:35", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("11:40", "청춘관", "A호차"));

        // 오후 시간표
        schedules.add(new BusSchedule("13:30", "학교", "A호차"));
        schedules.add(new BusSchedule("13:35", "청춘관", "A호차"));
        schedules.add(new BusSchedule("13:40", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("14:10", "학교", "A호차"));
        schedules.add(new BusSchedule("14:15", "청춘관", "A호차"));
        schedules.add(new BusSchedule("14:20", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("15:10", "학교", "A호차"));
        schedules.add(new BusSchedule("15:15", "청춘관", "A호차"));
        schedules.add(new BusSchedule("15:20", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("15:30", "학교", "A호차"));
        schedules.add(new BusSchedule("15:35", "청춘관", "A호차"));
        schedules.add(new BusSchedule("15:40", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("16:10", "학교", "A호차"));
        schedules.add(new BusSchedule("16:15", "청춘관", "A호차"));
        schedules.add(new BusSchedule("16:20", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("16:30", "학교", "A호차"));
        schedules.add(new BusSchedule("16:35", "청춘관", "A호차"));
        schedules.add(new BusSchedule("16:40", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("17:10", "학교", "A호차"));
        schedules.add(new BusSchedule("17:15", "청춘관", "A호차"));
        schedules.add(new BusSchedule("17:20", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("17:30", "학교", "A호차"));
        schedules.add(new BusSchedule("17:35", "청춘관", "A호차"));
        schedules.add(new BusSchedule("17:40", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("18:10", "학교", "A호차"));
        schedules.add(new BusSchedule("18:15", "청춘관", "A호차"));
        schedules.add(new BusSchedule("18:20", "문화체육센터", "A호차"));
        schedules.add(new BusSchedule("23:00", "학교", "A호차"));
        schedules.add(new BusSchedule("23:05", "청춘관", "A호차"));
    }

    private void updateCurrentTime() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
                textViewTime.setText("현재 시간: " + currentTime);
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    private void updateNextBusInfo() {
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        BusSchedule nextBus = null;

        for (BusSchedule schedule : schedules) {
            if (schedule.getTime().compareTo(currentTime) > 0) {
                nextBus = schedule;
                break;
            }
        }

        if (nextBus != null) {
            textViewNextBus.setText("다음 버스: " + nextBus.getTime() + " - " + nextBus.getLocation() + " (" + nextBus.getBus() + ")");
        } else {
            textViewNextBus.setText("더 이상 버스가 없습니다.");
        }
    }
}
