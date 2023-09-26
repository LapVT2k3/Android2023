package com.lapvt.myapplication.buoi8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserProfile::class], version = 1, exportSchema = false)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao
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
                "userprofile_database"
            ).allowMainThreadQueries().build()
        }
    }
}