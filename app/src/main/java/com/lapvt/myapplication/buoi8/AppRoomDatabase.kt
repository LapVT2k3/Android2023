package com.lapvt.myapplication.buoi8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserProfile::class], version = 1, exportSchema = false)
public abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao

    companion object {
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(context: Context): AppRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "user_database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}