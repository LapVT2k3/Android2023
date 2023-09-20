package com.lapvt.myapplication.buoi8

import android.view.View
import com.lapvt.myapplication.SingleClickListener

fun View.setOnSingleClick(onClick: ((View?) -> Unit)) {
    setOnClickListener(object : SingleClickListener() {
        override fun onClick(view: View?) {
            super.onClick(view)
            onClick.invoke(view)
        }
    })
}