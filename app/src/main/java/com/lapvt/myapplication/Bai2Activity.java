package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai2Activity extends AppCompatActivity {

    private EditText edtPhoneNumber;
    private EditText edtEmail;
    private EditText edtFullName;
    private EditText edtAgencyName;
    private EditText edtPassword;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        TextView tvBack = findViewById(R.id.tvBack);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        edtEmail = findViewById(R.id.edtEmail);
        edtFullName = findViewById(R.id.edtFullName);
        edtAgencyName = findViewById(R.id.edtAgencyName);
        edtPassword = findViewById(R.id.edtPassword);
        Button btnContinue = findViewById(R.id.btnContinue);
        TextView tvNotification = findViewById(R.id.tvNotification);

        tvBack.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, Bai1Activity.class);
            startActivity(intent1);
        });

        edtPhoneNumber.setOnTouchListener((view, motionEvent) -> {
            edtPhoneNumber.setBackgroundColor(Color.parseColor("#F4F6FA"));
            return false;
        });

        edtEmail.setOnTouchListener((view, motionEvent) -> {
            edtEmail.setBackgroundColor(Color.parseColor("#F4F6FA"));
            return false;
        });

        edtFullName.setOnTouchListener((view, motionEvent) -> {
            edtFullName.setBackgroundColor(Color.parseColor("#F4F6FA"));
            return false;
        });

        edtAgencyName.setOnTouchListener((view, motionEvent) -> {
            edtAgencyName.setBackgroundColor(Color.parseColor("#F4F6FA"));
            return false;
        });

        edtPassword.setOnTouchListener((view, motionEvent) -> {
            edtPassword.setBackgroundColor(Color.parseColor("#F4F6FA"));
            return false;
        });

        btnContinue.setOnClickListener(view -> {
            String phoneNumber = edtPhoneNumber.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String fullName = edtFullName.getText().toString().trim();
            String agencyName = edtAgencyName.getText().toString().trim();
            String password = edtPassword.getText().toString();
            String notification = "";

            if (phoneNumber.equals("")) {
                notification += "Vui lòng nhập số điện thoại.\n";
                edtPhoneNumber.setBackgroundColor(Color.parseColor("#FFEEEC"));
            } else if (!isValidPhoneNumber(phoneNumber)) {
                notification += "Số điện thoại không hợp lệ. Vui lòng nhập lại.\n";
                edtPhoneNumber.setBackgroundColor(Color.parseColor("#FFEEEC"));
            }
            if (email.equals("")) {
                notification += "Vui lòng nhập email.\n";
                edtEmail.setBackgroundColor(Color.parseColor("#FFEEEC"));
            } else if (!isValidEmail(email)) {
                notification += "Email không hợp lệ. Vui lòng nhập lại.\n";
            }
            if (fullName.equals("")) {
                notification += "Vui lòng nhập tên đầy đủ.\n";
                edtFullName.setBackgroundColor(Color.parseColor("#FFEEEC"));
            }
            if (agencyName.equals("")) {
                notification += "Vui lòng nhập tên cơ quan.\n";
                edtAgencyName.setBackgroundColor(Color.parseColor("#FFEEEC"));
            }
            if (password.length() == 0) {
                notification += "Vui lòng nhập mật khẩu.\n";
                edtPassword.setBackgroundColor(Color.parseColor("#FFEEEC"));
            } else if (password.length() < 8) {
                notification += "Mật khẩu không hợp lệ. Vui lòng nhập lại.\n";
                edtPassword.setBackgroundColor(Color.parseColor("#FFEEEC"));
            }
            if (notification.equals("")) {
                Toast.makeText(Bai2Activity.this, "Nhập thông tin thành công", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Bai3Activity.class);
                startActivity(intent2);
            } else {
                tvNotification.setText(notification);
            }
        });


    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return Patterns.PHONE.matcher(phoneNumber).matches();
    }
}