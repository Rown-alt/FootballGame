package com.example.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TimeResultDao{
    @Query("SELECT * FROM results")
    fun getAll(): List<TimeResult>

    @Insert
    fun insert(vararg result: TimeResult)

    @Delete
    fun delete(result: TimeResult)
}