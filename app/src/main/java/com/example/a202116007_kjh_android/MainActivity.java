package com.example.a202116007_kjh_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextId = findViewById(R.id.editTextId); // 학번 입력 필드
        EditText editTextName = findViewById(R.id.editTextName); // 이름 입력 필드
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString(); // 학번 입력값
                String name = editTextName.getText().toString(); // 이름 입력값

                if (!id.isEmpty() && !name.isEmpty()) {
                    // 로그인 성
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("USER_ID", id); // 학번 전달
                    intent.putExtra("USER_NAME", name); // 이름 전달
                    startActivity(intent);
                    finish();
                } else {
                    //에러 처리
                    Toast.makeText(MainActivity.this, "학번과 이름을 모두 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        } );
    }
}
