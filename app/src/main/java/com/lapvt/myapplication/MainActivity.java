package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Khi tạo biến trong activity thì chúng ta nên để private
    private Button btnClickMe;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Quy tắc đặt tên hàm:
//        TinhGiaTri(); -> Sai
//        tinhGiaTri(); -> Đúng

        btnClickMe = findViewById(R.id.btnClickMe);

        btnClickMe.setOnClickListener(view -> debug());
    }

    private void debug() {
        int result = 0;
        for (int i = 1; i <= 20; i++) {
            result = result + i;
        }
        Log.d("alo", result + "");
        Log.e("alo", result + "");
    }
}