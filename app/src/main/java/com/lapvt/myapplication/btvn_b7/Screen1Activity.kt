package com.lapvt.myapplication.btvn_b7

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R

class Screen1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        var messageList: ArrayList<MessageData>? = null
        val ivBack: ImageView = findViewById(R.id.ivBack)
        val tvAdd: TextView = findViewById(R.id.tvSave)
        messageList = createMessageList()

        ivBack.setOnClickListener {
            Toast.makeText(this, "Thoát khỏi ứng dụng", Toast.LENGTH_SHORT).show()
        }

        tvAdd.setOnClickListener {
            val intent = Intent(this, Screen2Activity::class.java)
            startActivity(intent)
        }

        val rcvData: RecyclerView = findViewById(R.id.rcvData)
        rcvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = messageList?.let { MessageAdapter(it) }
        rcvData.adapter = adapter

        adapter?.onClickItem = {

        }

        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val message = result.data?.extras?.get("key1") as? MessageData
                    val i = messageList?.size
                    if (message != null) {
                        i?.let { messageList?.add(it, message) }
                        i?.let { adapter?.notifyItemInserted(it) }
                    }
                }
            }

    }

    public fun createMessageList(): ArrayList<MessageData>? {
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