package com.lapvt.myapplication.buoi5

// Thường sử dụng khi các bạn tạo model từ api trả về
data class StudentData(
    var name: String,
    var age: Int
) {
    var height: Int = 0

    fun inRaChieuCao() {
        println("$name: $height")
    }
}
