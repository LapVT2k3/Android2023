package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
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
    private String passInput;
    private String passInputAgain;


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

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = editable.toString().trim();
                if (name.length() < 6) {
                    edtAccount.setError("Tên tài khoản tối thiểu 6 ký tự");
                } else {
                    edtAccount.setError(null);
                }
            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String pass = editable.toString().trim();
                if (pass.length() < 8) {
                    edtPassword.setError("Mật khẩu tối thiểu 8 ký tự");
                } else {
                    edtPassword.setError(null);
                }
                passInput = editable.toString().trim();
            }
        });

        edtPasswordAgain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String passAgain = editable.toString().trim();
                if (passAgain.length() < 8) {
                    edtPassword.setError("Mật khẩu nhập lại tối thiểu 8 ký tự");
                } else {
                    edtPassword.setError(null);
                }

                passInputAgain = editable.toString().trim();
                if (passInput.equals(passInputAgain)) {
                    edtPassword.setBackground(ContextCompat.getDrawable(Bai1Activity.this, R.drawable.shape_edittext));
                    tvNotification.setText("Mật khẩu hợp lệ");
                } else {
                    edtPassword.setBackground(ContextCompat.getDrawable(Bai1Activity.this, R.drawable.shape_edittext_error));
                    tvNotification.setText("Mật khẩu không trùng khớp");
                }
            }
        });

        btnContinue.setOnClickListener(view -> {
            startActivity(new Intent(this, Bai2Activity.class));
        });
    }
}