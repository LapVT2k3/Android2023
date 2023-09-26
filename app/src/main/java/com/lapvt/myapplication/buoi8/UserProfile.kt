package com.lapvt.myapplication.buoi8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "height")
    val height: String,
    @ColumnInfo(name = "weight")
    val weight: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}
