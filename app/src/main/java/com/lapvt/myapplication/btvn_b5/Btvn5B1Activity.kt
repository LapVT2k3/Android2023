package com.lapvt.myapplication.btvn_b5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.lapvt.myapplication.R

class Btvn5B1Activity : AppCompatActivity() {
    private var tvTitleName: TextView? = null;
    private var tvTitleBirthday: TextView? = null;
    private var tvTitleNumberPhone: TextView? = null;
    private var tvTitleEmail: TextView? = null;
    private var tvTitleCMT: TextView? = null;
    private var edtName: EditText? = null;
    private var edtBirthday: EditText? = null;
    private var edtNumberPhone: EditText? = null;
    private var edtEmail: EditText? = null;
    private var edtCMT: EditText? = null;
    private var btnUpdate: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn5_b1)

        tvTitleName = findViewById(R.id.tvTitleName)
        tvTitleBirthday = findViewById(R.id.tvTitleBirthday)
        tvTitleNumberPhone = findViewById(R.id.tvTitleNumberPhone)
        tvTitleEmail = findViewById(R.id.tvTitleEmail)
        tvTitleCMT = findViewById(R.id.tvTitleCMT)
        edtName = findViewById(R.id.edtName)
        edtBirthday = findViewById(R.id.edtBirthday)
        edtNumberPhone = findViewById(R.id.edtNumberPhone)
        edtEmail = findViewById(R.id.edtEmail)
        edtCMT = findViewById(R.id.edtCMT)
        btnUpdate = findViewById(R.id.btnUpdate)

        btnUpdate?.isEnabled = false

        val textViewList: List<TextView?> = listOf(tvTitleName, tvTitleBirthday, tvTitleNumberPhone, tvTitleEmail, tvTitleCMT)
        val redColorSpan = ForegroundColorSpan(Color.RED)
        for (tv in textViewList) {
            val text: String = tv?.text.toString();
            val spannable = SpannableString(text)
            spannable.setSpan(redColorSpan, text.length - 1, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            tv?.text = spannable
        }

    }
}