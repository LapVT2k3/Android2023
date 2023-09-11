package com.lapvt.myapplication.btvn_b7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class Screen1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        val tvAdd: TextView = findViewById(R.id.tvAdd)
        tvAdd.setOnClickListener {

        }


        val rcvData: RecyclerView = findViewById(R.id.rcvData)
        rcvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = MessageAdapter(createMessageList())
        rcvData.adapter = adapter

        adapter.onClickItem = {

        }

    }

    public fun createMessageList(): ArrayList<MessageData> {
        val messageList: ArrayList<MessageData> = ArrayList()
        messageList.add(MessageData(R.drawable.ic_message, "Tổng hợp tin tức thời sự", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        messageList.add(MessageData(R.drawable.ic_message, "Do It Your Self", "Sơn tùng MTP quá đẹp trai hát hay"))
        messageList.add(MessageData(R.drawable.ic_message, "Cảm hứng sáng tạo", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        messageList.add(MessageData(R.drawable.ic_message, "Tổng hợp tin tức thời sự", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        messageList.add(MessageData(R.drawable.ic_message, "Do It Your Self", "Sơn tùng MTP quá đẹp trai hát hay"))
        messageList.add(MessageData(R.drawable.ic_message, "Cảm hứng sáng tạo", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        messageList.add(MessageData(R.drawable.ic_message, "Tổng hợp tin tức thời sự", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        messageList.add(MessageData(R.drawable.ic_message, "Do It Your Self", "Sơn tùng MTP quá đẹp trai hát hay"))
        messageList.add(MessageData(R.drawable.ic_message, "Cảm hứng sáng tạo", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        messageList.add(MessageData(R.drawable.ic_message, "Tổng hợp tin tức thời sự", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        messageList.add(MessageData(R.drawable.ic_message, "Do It Your Self", "Sơn tùng MTP quá đẹp trai hát hay"))
        messageList.add(MessageData(R.drawable.ic_message, "Cảm hứng sáng tạo", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        return messageList
    }
}