package com.example.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_tel;
    static final int PERMISSIONS_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn_tel = findViewById(R.id.btn_tel);
        btn_tel.setOnClickListener(this);
    }
    public void onClick(View v) {
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_CALL_PHONE);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1199"));
            Toast.makeText(getApplicationContext(), "실행합니다.", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }

    }
       // Button button1 = findViewById(R.id.button1); //findViewByld()를 통해 xml파일에서 작성한 버튼의 ID를 가져옴

//        button1.setOnClickListener(new View.OnClickListener(){ //가져온 버튼에 클릭이벤트 명령 줌. onClick()를 필수로 오버라이드 해야함
//
//            public void onClick(View v){
//                Toast.makeText(getApplicationContext(), "실행합니다.", Toast.LENGTH_LONG).show(); //핸트폰에 토스트 메세지 뿌려줌. ex)알람이 설정되었습니다 같은..
//            }
//        });
    }

