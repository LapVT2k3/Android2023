package com.lapvt.myapplication.btvn_b8

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.PostProcessor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.lapvt.myapplication.R

class B8Screen2Activity : AppCompatActivity() {
    private var edtName2: EditText? = null
    private var edtAddress2: EditText? = null
    private var edtPhone2: EditText? = null
    private var btnSave2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b8_screen2)

        edtName2 = findViewById(R.id.edtName2)
        edtAddress2 = findViewById(R.id.edtAddress2)
        edtPhone2 = findViewById(R.id.edtPhone2)
        btnSave2 = findViewById(R.id.btnSave2)
        val user = intent.extras?.get("user_edit") as? UserData
        var textName = user?.name ?: ""
        var textAddress = user?.address ?: ""
        var textPhone = user?.phone ?: ""
        edtName2?.setText(textName)
        edtAddress2?.setText(textAddress)
        edtPhone2?.setText(textPhone)

        btnSave2?.setBackgroundColor(Color.parseColor("#8E97AA"))
        btnSave2?.isEnabled = false

        edtName2?.addTextChangedListener {
            textName = it.toString().trim()
            btnSave2?.isEnabled = textName.isNotEmpty()
                    && textAddress.isNotEmpty() && textPhone.isNotEmpty()
            if (btnSave2?.isEnabled == true) {
                btnSave2?.setBackgroundColor(Color.parseColor("#1F9FFC"))
            } else {
                btnSave2?.setBackgroundColor(Color.parseColor("#8E97AA"))
            }
        }

        edtAddress2?.addTextChangedListener {
            textAddress = it.toString().trim()
            btnSave2?.isEnabled = textName.isNotEmpty()
                    && textAddress.isNotEmpty() && textPhone.isNotEmpty()
            if (btnSave2?.isEnabled == true) {
                btnSave2?.setBackgroundColor(Color.parseColor("#1F9FFC"))
            } else {
                btnSave2?.setBackgroundColor(Color.parseColor("#8E97AA"))
            }
        }

        edtPhone2?.addTextChangedListener {
            textPhone = it.toString().trim()
            btnSave2?.isEnabled = textName.isNotEmpty()
                    && textAddress.isNotEmpty() && textPhone.isNotEmpty()
            if (btnSave2?.isEnabled == true) {
                btnSave2?.setBackgroundColor(Color.parseColor("#1F9FFC"))
            } else {
                btnSave2?.setBackgroundColor(Color.parseColor("#8E97AA"))
            }
        }

        btnSave2?.setOnClickListener {
            user?.name = textName
            user?.address = textAddress
            user?.phone = textPhone
            val intent = Intent()
            intent.putExtra("user_edited", user)
            intent.putExtra(B8Screen1Activity.KEY, B8Screen1Activity.TYPE_EDIT)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}