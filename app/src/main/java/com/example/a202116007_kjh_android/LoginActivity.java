package com.example.a202116007_kjh_android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    private EditText studentIdEditText, nameEditText;
    private Button loginButton;
    private TextView userNameTextView;
    private TextView nextBusTextView;
    private TextView followingBusTextView;
    private RecyclerView timetableRecyclerView;
    private TimetableAdapter timetableAdapter;
    private List<BusSchedule> busSchedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentIdEditText = findViewById(R.id.editTextStudentId);
        nameEditText = findViewById(R.id.editTextName);
        loginButton = findViewById(R.id.buttonLogin);
        userNameTextView = findViewById(R.id.userName);
        nextBusTextView = findViewById(R.id.textViewNextBus);
        followingBusTextView = findViewById(R.id.followingBus);
        timetableRecyclerView = findViewById(R.id.recyclerViewTimetable);

        loginButton.setOnClickListener(v -> {
            String studentId = studentIdEditText.getText().toString();
            String name = nameEditText.getText().toString();

            if (!studentId.isEmpty() && !name.isEmpty()) {
                // 로그인 정보 저장
                SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("studentId", studentId);
                editor.putString("name", name);
                editor.apply();

                // 로그인 성공 후 메인 화면 구성
                setContentView(R.layout.activity_main);
                setupMainScreen(name);
            } else {
                Toast.makeText(LoginActivity.this, "모든 정보를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupMainScreen(String userName) {
        userNameTextView.setText("환영합니다, " + userName + "님");

        // 버스 시간표 데이터 로드
        busSchedules = loadBusSchedules();

        // 가장 가까운 버스 시간 표시
        updateNextBusTime();

        // 시간표 RecyclerView 설정
        timetableAdapter = new TimetableAdapter(busSchedules);
        timetableRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        timetableRecyclerView.setAdapter(timetableAdapter);
    }

    private List<BusSchedule> loadBusSchedules() {
        // 이미지 기반 버스 시간표 데이터 추가
        List<BusSchedule> schedules = new ArrayList<>();
        // 오전 시간표 (A호차, B호차 구분)
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
        return schedules;
    }

    private void updateNextBusTime() {
        // 현재 시간 기준으로 가장 가까운 버스 시간 계산
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        boolean foundNextBus = false;
        for (BusSchedule schedule : busSchedules) {
            if (schedule.getDepartureTime().compareTo(currentTime) > 0) {
                if (!foundNextBus) {
                    nextBusTextView.setText("다음 버스: " + schedule.getDepartureTime() + " (" + schedule.getDestination() + ", " + schedule.getBusType() + ")");
                    foundNextBus = true;
                } else {
                    followingBusTextView.setText("그 다음 버스: " + schedule.getDepartureTime() + " (" + schedule.getDestination() + ", " + schedule.getBusType() + ")");
                    break;
                }
            }
        }
    }
}
