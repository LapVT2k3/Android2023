package com.lapvt.myapplication.buoi6

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R
import com.lapvt.myapplication.recyclerview.Student
import java.util.Calendar

class Buoi6Activity : AppCompatActivity() {

    // Lambda function
    // (Kiểu dữ liệu) -> Unit
    // Kiểu dữ liệu có thể có hoặc không
    private var print: (() -> Unit) = {
        Toast.makeText(this, "hihi", Toast.LENGTH_SHORT).show()
    }
    private var print2: ((String) -> Unit) = {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
    private var student: Student? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi6)
//        print2.invoke("lập")
//        tinhTong(1, 2)

        val rcvData = findViewById<RecyclerView>(R.id.rcvData)
        val tvName = findViewById<TextView>(R.id.tvName)
        val adapter = StudentAdapterKotlin(creatStudentList())
        adapter.onClickItem = { student ->
            goiApiTinhABC {
//                Toast.makeText(this, "${student.name}_${student.age}_$it", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, student.getData(), Toast.LENGTH_SHORT).show()
                tvName.showName()
            }
        }
        rcvData.adapter = adapter

//        Calendar.getInstance() -> VD có sẵn về Singleton class
        Database.suaDuLieu()

//        if (student != null) {
//            // Xử lý
//        }
        // Tương đương
        student?.let {
            // Xử lý
        }
    }

    private fun creatStudentList(): List<Student> {
        val studentList: ArrayList<Student> = ArrayList()
        val studentItem = Student().apply {
            this.name = "Vũ Trung Lập"
            this.age = 21
        }
        studentList.add(studentItem)
        studentList.add(Student("Lập", 21, "B21DCCN479", "Thái Bình"))
        studentList.add(Student("Sơn", 21, "B21DCCN110", "Thái Bình"))
        studentList.add(Student("An", 20, "B21DCCN002", "Thái Bình"))
        studentList.add(Student("Đạt", 22, "B21DCCN228", "Thái Bình"))
        studentList.add(Student("Tùng", 19, "B21DCCN146", "Thái Bình"))
        studentList.add(Student("Long", 18, "B21DCCN787", "Thái Bình"))
        studentList.add(Student("Khánh", 22, "B21DCCN987", "Thái Bình"))
        studentList.add(Student("Lập", 21, "B21DCCN479", "Thái Bình"))
        studentList.add(Student("Sơn", 21, "B21DCCN110", "Thái Bình"))
        studentList.add(Student("An", 20, "B21DCCN002", "Thái Bình"))
        studentList.add(Student("Đạt", 22, "B21DCCN228", "Thái Bình"))
        studentList.add(Student("Tùng", 19, "B21DCCN146", "Thái Bình"))
        studentList.add(Student("Long", 18, "B21DCCN787", "Thái Bình"))
        studentList.add(Student("Khánh", 22, "B21DCCN987", "Thái Bình"))
        return studentList
    }
    private fun goiApiTinhABC(callback: ((String)) -> Unit) {
        // Gọi API
        // Tính toán linh tinh gì đó
        tinhTong(1, 2)
        // Sau khi làm xong mọi việc thì báo là đã xong việc
        callback.invoke("Thành công")
    }
    object Database {
        fun xoaDuLieu() {

        }
        fun suaDuLieu() {

        }
     }
}