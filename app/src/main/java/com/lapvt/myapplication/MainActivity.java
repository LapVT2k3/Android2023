package com.lapvt.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lapvt.myapplication.btvn_b5.Btvn5B1Activity;
import com.lapvt.myapplication.buoi5.KotlinActivity;
import com.lapvt.myapplication.buoi5.OnClick;
import com.lapvt.myapplication.buoi5.PTB2Activity;
import com.lapvt.myapplication.buoi5.StudentKotlin;

public class MainActivity extends AppCompatActivity implements OnClick, View.OnClickListener {
    private Button btnKotlin;
    private Button btnPtb2Kotlin;
    private Button btnBtvn5_1;
    private Button btnBtvn5_2;
    private Button btnBtvn5_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKotlin = findViewById(R.id.btnKotlin);
        btnPtb2Kotlin = findViewById(R.id.btnPtb2Kotlin);
        btnBtvn5_1 = findViewById(R.id.btnBtvn5_1);
        btnBtvn5_2 = findViewById(R.id.btnBtvn5_2);
        btnBtvn5_3 = findViewById(R.id.btnBtvn5_3);

        btnKotlin.setOnClickListener(view -> {
            Intent intent = new Intent(this, KotlinActivity.class);
            startActivity(intent);
        });

        btnPtb2Kotlin.setOnClickListener(view -> {
            Intent intent = new Intent(this, PTB2Activity.class);
            startActivity(intent);
        });

        btnBtvn5_1.setOnClickListener(view -> {
            Intent intent = new Intent(this, Btvn5B1Activity.class);
            startActivity(intent);
        });

//        btnBtvn5_2.setOnClickListener(view -> {
//            Intent intent = new Intent(this, Btvn5B2Activity.class);
//            startActivity(intent);
//        });
//
//        btnBtvn5_3.setOnClickListener(view -> {
//            Intent intent = new Intent(this, Btvn5B3Activity.class);
//            startActivity(intent);
//        });
    }

    // Hàm không trả về giá trị (hàm void)
    private void logExample(String result) {
        Log.d("hihiabc", "");
        Log.e("hihi", "");
    }

    private int tinhTong(int a, int b) {
        return a + b;
    }

    @Override
    public void clicked() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}