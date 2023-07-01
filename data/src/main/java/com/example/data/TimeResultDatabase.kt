package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TimeResult::class], version = 1)
abstract class TimeResultDatabase: RoomDatabase() {
    abstract fun timeResultDao(): TimeResultDao
}