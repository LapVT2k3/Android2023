package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.lapvt.myapplication.buoi4.RecyclerViewGridActivity;
import com.lapvt.myapplication.buoi4.RecyclerViewHorizontalActivity;
import com.lapvt.myapplication.buoi4.RecyclerViewMergeAdapterActivity;
import com.lapvt.myapplication.buoi4.RecyclerViewVerticalActivity;
import com.lapvt.myapplication.recyclerview.RecyclerViewActivity;
import com.lapvt.myapplication.recyclerviewb1.RecyclerViewB1Activity;
import com.lapvt.myapplication.recyclerviewb2.RecyclerViewB2Activity;
import com.lapvt.myapplication.recyclerviewb3.RecyclerViewB3Activity;

public class MainActivity extends AppCompatActivity {

    private Button btnVertical;
    private Button btnHorizontal;
    private Button btnGrid;
    private Button btnMerge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnVertical = findViewById(R.id.btnVertical);
//        btnHorizontal = findViewById(R.id.btnHorizontal);
//        btnGrid = findViewById(R.id.btnGrid);
//        btnMerge = findViewById(R.id.btnMerge);
//
//        btnVertical.setOnClickListener(view -> {
//            Intent intent = new Intent(this, RecyclerViewVerticalActivity.class);
//            startActivity(intent);
//        });
//
//        btnHorizontal.setOnClickListener(view -> {
//            Intent intent = new Intent(this, RecyclerViewHorizontalActivity.class);
//            startActivity(intent);
//        });
//
//        btnGrid.setOnClickListener(view -> {
//            Intent intent = new Intent(this, RecyclerViewGridActivity.class);
//            startActivity(intent);
//        });
//
//        btnMerge.setOnClickListener(view -> {
//            Intent intent = new Intent(this, RecyclerViewMergeAdapterActivity.class);
//            startActivity(intent);
//        });
    }
}