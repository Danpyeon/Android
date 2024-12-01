package com.example.a202116007_kjh_android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a202116007_kjh_android.BusSchedule;
import com.example.a202116007_kjh_android.R;

import java.util.ArrayList;
import java.util.List;

public class TimetableActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTimetable;
    private TimetableAdapter adapter;
    private List<BusSchedule> schedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        recyclerViewTimetable = findViewById(R.id.recyclerViewTimetable);
        recyclerViewTimetable.setLayoutManager(new LinearLayoutManager(this));

        schedules = new ArrayList<>();
        initializeSchedules();

        // 오전/오후 데이터 나누기
        String type = getIntent().getStringExtra("TIMETABLE_TYPE");
        List<BusSchedule> filteredSchedules = new ArrayList<>();
        if ("morning".equals(type)) {
            filteredSchedules = filterSchedulesByTime("00:00", "12:00");
        } else if ("afternoon".equals(type)) {
            filteredSchedules = filterSchedulesByTime("12:00", "23:59");
        }

        adapter = new TimetableAdapter(filteredSchedules);
        recyclerViewTimetable.setAdapter(adapter);
    }

    // 초기 시간표 데이터
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

    // 시간 범위로 필터링
    private List<BusSchedule> filterSchedulesByTime(String startTime, String endTime) {
        List<BusSchedule> filtered = new ArrayList<>();
        for (BusSchedule schedule : schedules) {
            if (schedule.getTime().compareTo(startTime) >= 0 && schedule.getTime().compareTo(endTime) < 0) {
                filtered.add(schedule);
            }
        }
        return filtered;
    }
}
