package com.lapvt.myapplication.btvn_b8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R
import com.lapvt.myapplication.buoi8.AppRoomDatabase

class B8Screen1Activity : AppCompatActivity() {
    companion object {
        const val KEY = "KEY"
        const val TYPE_EDIT = "TYPE_EDIT"
        const val TYPE_ADD = "TYPE_ADD"
    }
    private var tvAddIcon: TextView? = null
    private var tvAdd: TextView? = null
    private var userList: ArrayList<UserData> = ArrayList()
    private var rcvData: RecyclerView? = null
    private var adapter: UserAdapter? = null
    private var userDao: UserDao? = null
    private var startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val type = result.data?.extras?.get(KEY)
                if (type == TYPE_ADD) {
                    val user = result.data?.extras?.get("user_added") as? UserData
                    val id = user?.let { userDao?.insert(it) }
                    if (id != null) {
                        user.id = id
                    }
                    user?.let { userList.add(0, it) }
                    adapter?.notifyItemInserted(0)
                    rcvData?.scrollToPosition(0)
                } else if (type == TYPE_EDIT) {
                    val user = result.data?.extras?.get("user_edited") as? UserData
                    user?.id = result.data?.extras?.get("id") as Long
                    if (user != null) {
                        for (i in 0 until userList.size) {
                            if (userList[i].id == user.id) {
                                userList[i] = user
                                adapter?.notifyItemChanged(i)
                                break
                            }
                        }
                    }
                }
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b8_screen1)

        userDao = AppRoomDatabase.getDatabase(this)?.userDao()
        tvAddIcon = findViewById(R.id.tvAddIcon)
        tvAdd = findViewById(R.id.tvAdd)
        userList = (userDao?.getAllUsers() as ArrayList<UserData>) ?: ArrayList()
        rcvData = findViewById(R.id.rcvData)
        rcvData?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = UserAdapter(userList)
        rcvData?.adapter = adapter

        adapter?.onItemClick = {
            val intent = Intent(this, B8Screen2Activity::class.java)
            intent.putExtra("user_edit", it)
            intent.putExtra("id", it.id)
            startForResult.launch(intent)
        }

        adapter?.onBinClick = {
            for (i in 0 until userList.size) {
                val user1 = userList[i]
                if (it.id == userList[i].id) {
                    userList.removeAt(i)
                    adapter?.notifyItemRemoved(i)
                    userDao?.deleteById(it.id)
                    break
                }
            }
        }

        tvAdd?.setOnClickListener {
            val intent = Intent(this, B8Screen3Activity::class.java)
            startForResult.launch(intent)
        }

        tvAddIcon?.setOnClickListener {
            val intent = Intent(this, B8Screen3Activity::class.java)
            startForResult.launch(intent)
        }
    }

}