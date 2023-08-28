package com.lapvt.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lapvt.myapplication.buoi4.RecyclerViewGridActivity;
import com.lapvt.myapplication.buoi4.RecyclerViewHorizontalActivity;
import com.lapvt.myapplication.buoi4.RecyclerViewMergeAdapterActivity;
import com.lapvt.myapplication.buoi4.RecyclerViewVerticalActivity;
import com.lapvt.myapplication.buoi5.KotlinActivity;
import com.lapvt.myapplication.buoi5.OnClick;
import com.lapvt.myapplication.buoi5.PTB2Activity;
import com.lapvt.myapplication.buoi5.StudentKotlin;

import com.lapvt.myapplication.buoi6.Buoi6Activity;
import com.lapvt.myapplication.recyclerview.RecyclerViewActivity;
import com.lapvt.myapplication.recyclerviewb1.RecyclerViewB1Activity;
import com.lapvt.myapplication.recyclerviewb2.RecyclerViewB2Activity;
import com.lapvt.myapplication.recyclerviewb3.RecyclerViewB3Activity;

public class MainActivity extends AppCompatActivity implements OnClick, View.OnClickListener {

    private Button btnVertical;
    private Button btnHorizontal;
    private Button btnGrid;
    private Button btnMerge;
    private Button btnKotlin;
    private Button btnPtb2Kotlin;
    private Button btnBuoi6;

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVertical = findViewById(R.id.btnVertical);
        btnHorizontal = findViewById(R.id.btnHorizontal);
        btnGrid = findViewById(R.id.btnGrid);
        btnMerge = findViewById(R.id.btnMerge);
        btnKotlin = findViewById(R.id.btnKotlin);
        btnPtb2Kotlin = findViewById(R.id.btnPtb2Kotlin);
        btnBuoi6 = findViewById(R.id.btnBuoi6);

        btnVertical.setOnClickListener(view -> {
            Intent intent = new Intent(this, RecyclerViewVerticalActivity.class);
            startActivity(intent);
        });

        btnHorizontal.setOnClickListener(view -> {
            Intent intent = new Intent(this, RecyclerViewHorizontalActivity.class);
            startActivity(intent);
        });

        btnGrid.setOnClickListener(view -> {
            Intent intent = new Intent(this, RecyclerViewGridActivity.class);
            startActivity(intent);
        });

        btnMerge.setOnClickListener(view -> {
            Intent intent = new Intent(this, RecyclerViewMergeAdapterActivity.class);
            startActivity(intent);
        });

        btnKotlin.setOnClickListener(view -> {
            Intent intent = new Intent(this, KotlinActivity.class);
            startActivity(intent);
        });

        btnPtb2Kotlin.setOnClickListener(view -> {
            Intent intent = new Intent(this, PTB2Activity.class);
            startActivity(intent);
        });

        btnBuoi6.setOnClickListener(view -> {
            Intent intent = new Intent(this, Buoi6Activity.class);
            startActivity(intent);
        });

        StudentKotlin studentKotlin = new StudentKotlin(1.5, "Nam");
        studentKotlin.setName("Vũ Trung Lập");
        studentKotlin.setAge(20);

        Buoi6Activity.Database.INSTANCE.suaDuLieu();
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