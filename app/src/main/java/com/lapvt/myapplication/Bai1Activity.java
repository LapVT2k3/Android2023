package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai1Activity extends AppCompatActivity {

    private TextView tvBack;
    private EditText edtAccount;
    private EditText edtPassword;
    private EditText edtPasswordAgain;
    private Button btnContinue;
    private TextView tvNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        tvBack = findViewById(R.id.tvBack);
        edtAccount = findViewById(R.id.edtAccount);
        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordAgain = findViewById(R.id.edtPasswordAgain);
        btnContinue = findViewById(R.id.btnContinue);
        tvNotification = findViewById(R.id.tvNotification);

        tvBack.setOnClickListener(view -> {
//            Toast.makeText()
        });
    }
}