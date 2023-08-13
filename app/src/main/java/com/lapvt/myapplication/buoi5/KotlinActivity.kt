package com.lapvt.myapplication.buoi5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lapvt.myapplication.R

class KotlinActivity : AppCompatActivity(), OnClick, View.OnClickListener {

    val count: Int = 0
    // Biến var có giá trị mặc định
    var count1: Int = 0
    // Biến var không gán giá trị mặc định
    var count2: Int? = null
    // Không khai báo kiểu dữ liệu
    var count3 = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        println(tinhTich(3, 5))
        println(tinhThuong(5))

        val student = StudentKotlin(1.5)
        // Set dữ liệu
        student.name = "Vũ Trung Lập"
        student.age = 20
        student.height = 1.6
        // Set dữ liệu kiểu 2
        val student2 = StudentKotlin(1.5).apply {
            this.name = "Vũ Trung Lập"
            this.age = 20
        }
        // Get dữ liệu
        Toast.makeText(this, student.name + student.age, Toast.LENGTH_LONG).show();

        if (student.age > 10) {
            //todo
        } else if (student.age > 3) {
            //todo
        } else {

        }
        // Duyệt vòng for từ 1 đến 10
        for (i in 1..10) {

        }

        val students = ArrayList<StudentData>()
        students.add(StudentData("Vũ Trung Lập", 20))

        val studentList = mutableListOf<StudentData>();
        studentList.add(StudentData("Vũ Trung Lập", 20))
        studentList.add(StudentData("Vũ Trung Lập", 20))
        studentList.add(StudentData("Vũ Trung Lập", 20))
        studentList.add(StudentData("Vũ Trung Lập", 20))
        studentList.add(StudentData("Vũ Trung Lập", 20))
        studentList.add(StudentData("Vũ Trung Lập", 20))

        // Duyệt list
        // C1:
        for (i in 0..studentList.size) {

        }
        // C2:
        for (stu in studentList) {

        }
        // C3 (Hay dùng): Hàm mở rộng của List (extension)
        studentList.forEach {
            println(it.name)
        }
        // Duyệt vòng for có trả kèm index của từng phần tử
        val numbers = listOf(10, 20, 30, 40, 50)
        numbers.forEachIndexed { index, value ->
            println("Index: $index, Value: $value")
        }
        // Output:
//        Index: 0, Value: 10
//        Index: 1, Value: 20
//        Index: 2, Value: 30
//        Index: 3, Value: 40
//        Index: 4, Value: 50

        // Một số hàm khác
        // Hàm lọc với bộ lọc là các phần tử > 25 thì trả về 1 list các dữ liệu
        val numbers1 = listOf(10, 20, 30, 40, 50)
        val filteredNumbers = numbers1.filter { it > 25 }
        println(filteredNumbers)
        // Output: [30, 40, 50]

        // Trả về phần tử đầu tiên > 25 nếu không thì trả về null
        val numbers2 = listOf(10, 20, 30, 40, 50)

        val firstNumberGreaterThan25 = numbers.firstOrNull { it > 25 }

        println(firstNumberGreaterThan25)
        // Output: 30

    }

    private fun logExample(result: String, result2: String) {

    }

    private fun tinhTich(a: Int, b: Int): Int {
        return a.times(b)
    }

    // Trong trường hợp không truyền giá trị của b thì giá trị của b mặc định là 1
    // Trong trường hợp có dấu ? nghĩa là giá trị của biến đó có thể là null
    private fun tinhThuong(a: Int?,  b: Int = 1): Int? {
        return a?.div(b);
    }

    private fun tinhTong(a: Int, b: Int) = a + b
    override fun clicked() {
    }

    override fun onClick(p0: View?) {
    }

    private fun cacCachVietWhen() {
        // Đối tượng không đổi mà chỉ có giá trị bên trong đối tượng thay đổi nên để là val
        val student = StudentKotlin(1.0)
        // C1 (hay dùng):
        when {
            student.age == 1 && student.name == "a" -> {
                //todo
            }
            student.age == 2 -> {
                //todo
            }
            else -> {
                //todo
            }
        }
        // Tương đương với cách dùng if else như sau:
        if (student.age == 1 && student.name == "a") {
            //todo
        } else if (student.age == 2) {
            //todo
        } else {
            //todo
        }
        // C2:
        when (student.age) {
            1 -> {
                //todo
            }
            2 -> {
                //todo
            }
            else -> {
                //todo
            }
        }
    }

    private fun xuLyChuoi() {
        val a = "abc"
        val b = "def"
        val c = "$a$b" // => "abcdef"
        val d = 100 * 10
        val e = a + d // => "abc1000"
        val f = "$a${100 * 10}${12-3} Tôi tên là: ${getTen()}" // => "abc10009 Tôi tên là: Lập"
        var g = "xyz"

    }

    private fun getTen(): String {
        return "Lập"
    }
}