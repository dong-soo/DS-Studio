package com.example.horsemuscle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_title; // 변수를 선언
    Button btn_buy; // 버튼선언
    EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_title = findViewById(R.id.tv_title); //뷰를 id를 통해서 연결
        btn_buy = findViewById(R.id.btn_buy); // 뷰를 id를 통해서 연결
        et_name = findViewById(R.id.et_name); //뷰를 id를 통해서 연결

        tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_title.setText("Horse Muscle");
            }
        });


        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , HistoryActivity.class); // 메인에서 히스토리로 옮기고싶어요
                startActivity(intent);
                Toast.makeText(MainActivity.this,et_name.getText().toString()+"가(이) 구매되었습니다." , Toast.LENGTH_SHORT).show(); // 구매되었습니다 문구 띄우기
            }
        });

    }
}