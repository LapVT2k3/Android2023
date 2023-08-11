package com.lapvt.myapplication.buoi5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.lapvt.myapplication.R
import kotlin.math.sqrt

class PTB2Activity : AppCompatActivity() {
    private var edtA:  EditText? = null
    private var edtB:  EditText? = null
    private var edtC:  EditText? = null
    private var btnGPT: Button? = null

    private var numberA = ""
    private var numberB = ""
    private var numberC = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ptb2)

        edtA = findViewById(R.id.edtA)
        edtB = findViewById(R.id.edtB)
        edtC = findViewById(R.id.edtC)
        btnGPT = findViewById(R.id.btnGPT)

        btnGPT?.isEnabled = false
        edtA?.addTextChangedListener {
            numberA = it.toString()
            btnGPT?.isEnabled = numberA.isNotEmpty() &&
                    numberB.isNotEmpty() &&
                    numberC.isNotEmpty()
        }
        edtB?.addTextChangedListener {
            numberB = it.toString()
            btnGPT?.isEnabled = numberA.isNotEmpty() &&
                    numberB.isNotEmpty() &&
                    numberC.isNotEmpty()
        }
        edtC?.addTextChangedListener {
            numberC = it.toString()
            btnGPT?.isEnabled = numberA.isNotEmpty() &&
                    numberB.isNotEmpty() &&
                    numberC.isNotEmpty()
        }
        // Cách khởi tạo Interface TextWatcher
//        edtA?.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                TODO("Not yet implemented")
//            }

//        })

        btnGPT?.setOnClickListener {
            val a = edtA?.text.toString().toDoubleOrNull()
            val b = edtB?.text.toString().toDoubleOrNull()
            val c = edtC?.text.toString().toDoubleOrNull()
            // a ?: giá trị mặc định (Khi a = null thì để giá trị mặc định)
            // Tương đương với a != null ? a : 0.0
            timNghiemPTB2(a ?: 0.0, b ?: 0.0, c ?: 0.0)

        }
    }

    // Giá trị truyền vào ko được phép null
    private fun timNghiemPTB2(a: Double, b: Double, c: Double) {
        val delta = b * b - 4 * a * c
        when {
            delta < 0 -> {
                Toast.makeText(this, "Phương trình vô nghiệm", Toast.LENGTH_SHORT).show()
            }
            delta == 0.0 -> {
                Toast.makeText(this, "Phương trình có nghiệm kép x = " + (-b/ (2 * a)), Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Phương trình có 2 nghiệm phân biệt\nx1 = " + (-b + sqrt(delta)) / (2 * a)
                        + "và x2 = " + (-b - sqrt(delta)) / (2 * a), Toast.LENGTH_SHORT).show()
            }
        }
    }
}