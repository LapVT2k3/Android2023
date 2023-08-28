package com.lapvt.myapplication.chua_btvn_b5.bai1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.lapvt.myapplication.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class UpdateUserActivity : AppCompatActivity() {
    private var edtFullName: EditText? = null
    private var tvDate: TextView? = null
    private var edtPhone: EditText? = null
    private var edtEmail1: EditText? = null
    private var edtCmt: EditText? = null
    private var btnUpdateInfo: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        edtFullName = findViewById(R.id.edtFullName)
        tvDate = findViewById(R.id.tvDate)
        edtPhone = findViewById(R.id.edtPhone)
        edtEmail1 = findViewById(R.id.edtEmail1)
        edtCmt = findViewById(R.id.edtCmt)
        btnUpdateInfo = findViewById(R.id.btnUpdateInfo)

        edtFullName?.addTextChangedListener {
            setEnableButtonUpdate()
        }
        tvDate?.setOnClickListener {
            showDatePickerDialog()
            setEnableButtonUpdate()
        }
        edtPhone?.addTextChangedListener {
            setEnableButtonUpdate()
        }
        edtEmail1?.addTextChangedListener {
            setEnableButtonUpdate()
        }
        edtCmt?.addTextChangedListener {
            setEnableButtonUpdate()
        }
        btnUpdateInfo?.setOnClickListener {
            Toast.makeText(this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(calendar)
        }
        DatePickerDialog(this, datePicker, year, month, day).show()
    }

    private fun updateLable(calendar: Calendar) {
        val myFormat = "dd/mm/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale("vi", "VN"))
        tvDate?.text = sdf.format(calendar.time)
    }

    private fun setEnableButtonUpdate() {
        btnUpdateInfo?.isEnabled = isEnableButtonUpdate()
        if (btnUpdateInfo?.isEnabled == true) {
            btnUpdateInfo?.background = ContextCompat.getDrawable(this,  R.drawable.bg_button_enable)
            btnUpdateInfo?.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else {
            btnUpdateInfo?.background = ContextCompat.getDrawable(this,  R.drawable.bg_button_disable)
            btnUpdateInfo?.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }

    private fun isEnableButtonUpdate(): Boolean {
        return edtFullName?.text.toString().trim().isNotEmpty() &&
                tvDate?.text.toString().trim().isNotEmpty() &&
                edtPhone?.text.toString().trim().isNotEmpty() &&
                edtEmail1?.text.toString().trim().isNotEmpty() &&
                edtCmt?.text.toString().trim().isNotEmpty()
    }
}