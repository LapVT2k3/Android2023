package com.lapvt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class B3Activity extends AppCompatActivity {

    private EditText edtText;
    private EditText edtNumber;
    private TextView tvText;
    private TextView tvNumber;
    private CheckBox cbCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b3);

        edtText = findViewById(R.id.edtText);
        edtNumber = findViewById(R.id.edtNumber);
        tvText = findViewById(R.id.tvText);
        tvNumber = findViewById(R.id.tvNumber);
        cbCheck = findViewById(R.id.cbCheck);

        // Lắng nghe sự kiện người dùng nhập cái gì vào ô editText
        edtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Trước khi người dùng nhập
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Người dùng đang nhập
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Sau khi người dùng nhập (hay dùng)

                // Lấy dữ liệu người dùng đang nhập và hiển thị ở textView "tvNumber"
                // C1:
                tvNumber.setText(editable.toString());
                // C2:
//                tvNumber.setText(edtNumber.getText().toString().trim());

            }
        });

        // Trả về true khi checkBox được tích và ngược lại
        // cbCheck.isChecked()

        // Lắng nghe sự kiện người dùng tick vào checkBox
        // C1:
//        cbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (compoundButton.isChecked()) {
//                    Toast.makeText(B3Activity.this, "Bạn đã tích", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(B3Activity.this, "Bạn không tích", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        // C2 (khuyến khích):
        cbCheck.setOnCheckedChangeListener((compoundButton, b) -> {
            if (compoundButton.isChecked()) {
                Toast.makeText(B3Activity.this, "Bạn đã tích", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(B3Activity.this, "Bạn không tích", Toast.LENGTH_SHORT).show();
            }
        });
    }
}