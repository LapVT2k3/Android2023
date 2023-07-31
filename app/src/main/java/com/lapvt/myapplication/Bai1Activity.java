package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai1Activity extends AppCompatActivity {

    private EditText edtAccount;
    private EditText edtPassword;
    private EditText edtPasswordAgain;
    private TextView tvNotification;

    private int cntBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        TextView tvBack = findViewById(R.id.tvBack);
        edtAccount = findViewById(R.id.edtAccount);
        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordAgain = findViewById(R.id.edtPasswordAgain);
        Button btnContinue = findViewById(R.id.btnContinue);
        tvNotification = findViewById(R.id.tvNotification);

        cntBack = 0;
        tvBack.setOnClickListener(view -> {
            cntBack++;
            if (cntBack == 1) {
                Toast.makeText(Bai1Activity.this, "Bấm lần nữa để thoát", Toast.LENGTH_SHORT).show();
            } else if (cntBack == 2) {
                finishAffinity();
            }

        });

        edtAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtAccount.setBackgroundColor(Color.parseColor("#F4F6FA"));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtPassword.setBackgroundColor(Color.parseColor("#F4F6FA"));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtPasswordAgain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtPasswordAgain.setBackgroundColor(Color.parseColor("#F4F6FA"));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnContinue.setOnClickListener(view -> {
            String account = edtAccount.getText().toString();
            String password = edtPassword.getText().toString();
            String password_again = edtPasswordAgain.getText().toString();
            String notification = "";

            if (account.length() < 6) {
                edtAccount.setBackgroundColor(Color.parseColor("#FFEEEC"));
                notification += "Tài khoản có ít hơn 6 ký tự.\n";
            }
            if (password.length() < 8) {
                edtPassword.setBackgroundColor(Color.parseColor("#FFEEEC"));
                edtPasswordAgain.setBackgroundColor(Color.parseColor("#FFEEEC"));
                notification += "Mật khẩu có ít hơn 8 ký tự.\n";
            } else if (!password.equals(password_again)) {
                edtPasswordAgain.setBackgroundColor(Color.parseColor("#FFEEEC"));
                notification += "Mật khẩu nhập lại không trùng với mật khẩu trước đó.\n";
            }
            if (notification.equals("")) {
                notification = "Đăng ký thành công!";
                tvNotification.setText(notification);
                Toast.makeText(Bai1Activity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

            } else {
                notification += "Vui lòng nhập lại!";
                tvNotification.setText(notification);
            }

        });
    }
}