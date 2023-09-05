package com.lapvt.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lapvt.myapplication.buoi7.Buoi7Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBuoi7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuoi7 = findViewById(R.id.btnBuoi7);

        btnBuoi7.setOnClickListener(view -> {
            Intent intent = new Intent(this, Buoi7Activity.class);
            startActivity(intent);
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