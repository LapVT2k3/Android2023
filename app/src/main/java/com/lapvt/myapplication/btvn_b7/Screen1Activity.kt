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

@Suppress("DEPRECATION")
class Screen1Activity : AppCompatActivity() {
    companion object {
        const val KEY = "KEY"
        const val TYPE_EDIT = "TYPE_EDIT"
        const val TYPE_ADD = "TYPE_ADD"
    }
    private var ivBack: ImageView? = null
    private var tvAdd: TextView? = null
    private var messageList: ArrayList<MessageData> = ArrayList()
    private var rcvData: RecyclerView? = null
    private var adapter: MessageAdapter? = null
    private var startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val type = result.data?.extras?.get(KEY)
                if (type == TYPE_ADD) {
                    val message = result.data?.extras?.get("message") as? MessageData
                    message?.let { messageList.add(0, it) }
                    adapter?.notifyItemInserted(0)
                } else if (type == TYPE_EDIT) {
                    val message = result.data?.extras?.get("message") as? MessageData
                    message?.let { messageList.set(it.id, message) }
                    message?.let { adapter?.notifyItemChanged(it.id) }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        ivBack = findViewById(R.id.ivBack)
        tvAdd = findViewById(R.id.tvSave)
        messageList = createMessageList()
        rcvData = findViewById(R.id.rcvData)
        rcvData?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = MessageAdapter(messageList)
        rcvData?.adapter = adapter

        ivBack?.setOnClickListener {
            Toast.makeText(this, "Thoát khỏi màn hình", Toast.LENGTH_SHORT).show()
        }

        adapter?.onClickItem = {
            val intent = Intent(this, Screen3Activity::class.java)
            intent.putExtra("message", it)
            startForResult.launch(intent)
        }

        tvAdd?.setOnClickListener {
            val intent = Intent(this, Screen2Activity::class.java)
            startForResult.launch(intent)
        }

    }

    private fun createMessageList(): ArrayList<MessageData> {
        val messageList: ArrayList<MessageData> = ArrayList()
        messageList.add(
            MessageData(
                0,
                R.drawable.ic_message,
                "Tổng hợp tin tức thời sự",
                "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"
            )
        )
        messageList.add(
            MessageData(
                1,
                R.drawable.ic_message,
                "Do It Your Self",
                "Sơn tùng MTP quá đẹp trai hát hay"
            )
        )
        messageList.add(
            MessageData(
                2,
                R.drawable.ic_message,
                "Cảm hứng sáng tạo",
                "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"
            )
        )
        messageList.add(
            MessageData(
                3,
                R.drawable.ic_message,
                "Tổng hợp tin tức thời sự",
                "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"
            )
        )
        messageList.add(
            MessageData(
                4,
                R.drawable.ic_message,
                "Do It Your Self",
                "Sơn tùng MTP quá đẹp trai hát hay"
            )
        )
        messageList.add(
            MessageData(
                5,
                R.drawable.ic_message,
                "Cảm hứng sáng tạo",
                "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"
            )
        )
        messageList.add(
            MessageData(
                6,
                R.drawable.ic_message,
                "Tổng hợp tin tức thời sự",
                "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"
            )
        )
        messageList.add(
            MessageData(
                7,
                R.drawable.ic_message,
                "Do It Your Self",
                "Sơn tùng MTP quá đẹp trai hát hay"
            )
        )
        return messageList
    }
}