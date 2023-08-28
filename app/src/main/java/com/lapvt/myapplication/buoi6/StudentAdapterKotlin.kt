package com.lapvt.myapplication.buoi6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lapvt.myapplication.R
import com.lapvt.myapplication.recyclerview.Student

class StudentAdapterKotlin(val studentList: List<Student>): RecyclerView.Adapter<StudentAdapterKotlin.StudentViewHolder>() {
    class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tvName)
        private val tvAge = itemView.findViewById<TextView>(R.id.tvAge)
        fun setData(student: Student) {
            tvName.text = student.name
            tvAge.text = "${student.age} tuổi"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (studentList.isNotEmpty()) studentList.size else 0
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.setData(studentList[position])
    }
}