package com.lapvt.myapplication.buoi6

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.lapvt.myapplication.R
import com.lapvt.myapplication.recyclerview.Student

// Trong extension, ta được sử dụng tất cả các hàm, thuộc tính của đối tượng mà extension hướng đến
fun TextView.showName() {
    text = "Vũ Trung Lập"
    setTextColor(ContextCompat.getColor(context, R.color.black))
}

fun Student.getData(): String {
    return "$name $age"
}