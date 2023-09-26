package com.lapvt.myapplication.buoi8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lapvt.myapplication.btvn_b8.UserDao
import com.lapvt.myapplication.btvn_b8.UserData

@Database(entities = [UserProfile::class, UserData::class], version = 2, exportSchema = false)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao
    abstract fun userDao(): UserDao
    companion object {
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null
        fun getDatabase(context: Context): AppRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE
        }
        private fun buildDatabase(context: Context): AppRoomDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "user_database"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }
}