package com.example.upstoxassignment.base.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.upstoxassignment.dashboard.data.datatsource.local.HoldingsDao
import com.example.upstoxassignment.dashboard.data.entities.local.HoldingsEntity

@Database(entities = [HoldingsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun holdingsDao(): HoldingsDao

    companion object {
        val DB_NAME = "holdings"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: run {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, DB_NAME
                ).build()
                return INSTANCE!!
            }
        }
    }
}
