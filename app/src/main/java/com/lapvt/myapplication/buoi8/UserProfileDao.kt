package com.lapvt.myapplication.buoi8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

// Mục đích là query và cập nhật dữ liệu
@Dao
interface UserProfileDao {
    // Lấy tất cả dữ liệu user đã lưu ở trong database và sắp xếp lại
    @Query("SELECT * FROM user_profile ORDER BY id ASC")
    fun getAllUsers(): List<UserProfile>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserProfile)

    @Update
    fun update(user: UserProfile)

    @Query("DELETE FROM user_profile")
    fun deleteAll()
}