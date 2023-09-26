package com.lapvt.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lapvt.myapplication.btvn_b7.Screen1Activity;
import com.lapvt.myapplication.btvn_b8.B8Screen1Activity;
import com.lapvt.myapplication.buoi7.Buoi7Activity;
import com.lapvt.myapplication.buoi8.Buoi8Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBuoi7;
    private Button btnBtvnB7;
    private Button btnCall;
    private Button btnCheckEvent;
    private Button btnBuoi8;
    private Button btnBtvnB8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuoi7 = findViewById(R.id.btnBuoi7);
        btnBtvnB7 = findViewById(R.id.btnBtvnB7);
        btnCall = findViewById(R.id.btnCall);
        btnCheckEvent = findViewById(R.id.btnCheckEvent);
        btnBuoi8 = findViewById(R.id.btnBuoi8);
        btnBtvnB8 = findViewById(R.id.btnBtvnB8);

        btnBuoi7.setOnClickListener(view -> {
            Intent intent = new Intent(this, Buoi7Activity.class);
            startActivity(intent);
        });

        btnBtvnB7.setOnClickListener(view -> {
            Intent intent = new Intent(this, Screen1Activity.class);
            startActivity(intent);
        });

        btnCall.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "0353649148"));
            startActivity(intent);
        });

        btnCheckEvent.setOnClickListener(new SingleClickListener() {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                startActivity(new Intent(MainActivity.this, Screen1Activity.class));
            }
        });

        btnBuoi8.setOnClickListener(new SingleClickListener() {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                startActivity(new Intent(MainActivity.this, Buoi8Activity.class));
            }
        });

        btnBtvnB8.setOnClickListener(new SingleClickListener() {
            @Override
            public void onClick(View view) {
                super.onClick(view);
                startActivity(new Intent(MainActivity.this, B8Screen1Activity.class));
            }
        });
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
    public void onClick(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}