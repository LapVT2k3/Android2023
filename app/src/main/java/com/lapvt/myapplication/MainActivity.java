package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.lapvt.myapplication.recyclerview.RecyclerViewActivity;
import com.lapvt.myapplication.recyclerviewb1.RecyclerViewB1Activity;
import com.lapvt.myapplication.recyclerviewb2.RecyclerViewB2Activity;
import com.lapvt.myapplication.recyclerviewb3.RecyclerViewB3Activity;

public class MainActivity extends AppCompatActivity {

    private Button btnB1;
    private Button btnB2;
    private Button btnB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnB1 = findViewById(R.id.btnB1);
        btnB2 = findViewById(R.id.btnB2);
        btnB3 = findViewById(R.id.btnB3);

        btnB1.setOnClickListener(view -> {
            Intent intent = new Intent(this, RecyclerViewB1Activity.class);
            startActivity(intent);
        });

        btnB2.setOnClickListener(view -> {
            Intent intent = new Intent(this, RecyclerViewB2Activity.class);
            startActivity(intent);
        });

        btnB3.setOnClickListener(view -> {
            Intent intent = new Intent(this, RecyclerViewB3Activity.class);
            startActivity(intent);
        });
    }
}