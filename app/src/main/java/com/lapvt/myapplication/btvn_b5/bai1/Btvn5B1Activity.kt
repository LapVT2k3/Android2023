package com.lapvt.myapplication.btvn_b5.bai1

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.lapvt.myapplication.R
import java.util.Calendar

class Btvn5B1Activity : AppCompatActivity() {
    private var tvTitleName: TextView? = null
    private var tvTitleBirthday: TextView? = null
    private var tvTitleNumberPhone: TextView? = null
    private var tvTitleEmail: TextView? = null
    private var tvTitleCMT: TextView? = null
    private var edtName: EditText? = null
    private var edtBirthday: EditText? = null
    private var edtNumberPhone: EditText? = null
    private var edtEmail: EditText? = null
    private var edtCMT: EditText? = null
    private var btnUpdate: Button? = null
    private var imvCalendar: ImageButton? = null
    private var name: String = ""
    private var birthday: String = ""
    private var numberphone: String = ""
    private var email: String = ""
    private var numbercmt: String = ""

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
        imvCalendar = findViewById(R.id.imvCalendar)

        btnUpdate?.isEnabled = false

        val textViewList: List<TextView?> = listOf(tvTitleName, tvTitleBirthday, tvTitleNumberPhone, tvTitleEmail, tvTitleCMT)
        val redColorSpan = ForegroundColorSpan(Color.RED)
        for (tv in textViewList) {
            val text: String = tv?.text.toString()
            val spannable = SpannableString(text)
            spannable.setSpan(redColorSpan, text.length - 1, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            tv?.text = spannable
        }

        imvCalendar?.setOnClickListener {
            showDatePickerDialog()
        }

        edtName?.addTextChangedListener {
            name = it.toString()
            btnUpdate?.isEnabled = name.isNotEmpty() && birthday.isNotEmpty() &&
                    numberphone.isNotEmpty() && email.isNotEmpty() &&
                    numbercmt.isNotEmpty() && edtNumberPhone?.error == null &&
                    edtEmail?.error == null && edtCMT?.error == null
        }

        edtBirthday?.addTextChangedListener {
            birthday = it.toString()
            btnUpdate?.isEnabled = name.isNotEmpty() && birthday.isNotEmpty() &&
                    numberphone.isNotEmpty() && email.isNotEmpty() &&
                    numbercmt.isNotEmpty() && edtNumberPhone?.error == null &&
                    edtEmail?.error == null && edtCMT?.error == null
        }

        edtNumberPhone?.addTextChangedListener {
            numberphone = it.toString().trim()
            if (numberphone.length > 10) {
                edtNumberPhone?.error = "Tối đa 10 ký tự"
            } else if (!Patterns.PHONE.matcher(numberphone).matches()){
                edtNumberPhone?.error = "Số điện thoại không hợp lệ"
            } else {
                edtNumberPhone?.error = null
            }
            btnUpdate?.isEnabled = name.isNotEmpty() && birthday.isNotEmpty() &&
                    numberphone.isNotEmpty() && email.isNotEmpty() &&
                    numbercmt.isNotEmpty() && edtNumberPhone?.error == null &&
                    edtEmail?.error == null && edtCMT?.error == null
        }

        edtEmail?.addTextChangedListener {
            email = it.toString().trim()
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtEmail?.error = "Email không hợp lệ"
            } else {
                edtEmail?.error = null
            }
            btnUpdate?.isEnabled = name.isNotEmpty() && birthday.isNotEmpty() &&
                    numberphone.isNotEmpty() && email.isNotEmpty() &&
                    numbercmt.isNotEmpty() && edtNumberPhone?.error == null &&
                    edtEmail?.error == null && edtCMT?.error == null
        }

        edtCMT?.addTextChangedListener {
            numbercmt = it.toString().trim()
            if (numbercmt.length > 12){
                edtCMT?.error = "Tối đa 12 ký tự"
            } else {
                edtCMT?.error = null
            }
            btnUpdate?.isEnabled = name.isNotEmpty() && birthday.isNotEmpty() &&
                    numberphone.isNotEmpty() && email.isNotEmpty() &&
                    numbercmt.isNotEmpty() && edtNumberPhone?.error == null &&
                    edtEmail?.error == null && edtCMT?.error == null
        }

        btnUpdate?.setOnClickListener {
            Toast.makeText(this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            edtBirthday?.setText(selectedDate)
        }, year, month, day)
        datePickerDialog.show()
    }
}