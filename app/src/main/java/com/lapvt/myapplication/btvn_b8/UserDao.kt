package com.lapvt.myapplication.btvn_b8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("SELECT * FROM user_information ORDER BY id ASC")
    fun getAllUsers(): ArrayList<UserData>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserData)
    @Update
    fun update(user: UserData)
    @Query("DELETE FROM user_information")
    fun deleteAll()

}