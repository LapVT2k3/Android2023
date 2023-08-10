package com.lapvt.myapplication.buoi5

class StudentKotlin constructor(var height: Double, gender: String = "Nam") {

    var name: String = ""
    var age: Int = 0
    init {
        // Đây là hàm được tạo khi bắt đầu khởi tạo đối tượng
        this.age = 100
    }


}