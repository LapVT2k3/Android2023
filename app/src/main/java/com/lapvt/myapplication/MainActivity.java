package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.lapvt.myapplication.recyclerview.RecyclerViewActivity;
import com.lapvt.myapplication.recyclerviewb1.RecyclerViewB1Activity;
import com.lapvt.myapplication.recyclerviewb2.RecyclerViewB2Activity;

public class MainActivity extends AppCompatActivity {

    private Button btnClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClickMe = findViewById(R.id.btnClickMe);

        btnClickMe.setOnClickListener(view -> {
            Intent intent = new Intent(this, RecyclerViewB2Activity.class);
            startActivity(intent);
        });
    }
}