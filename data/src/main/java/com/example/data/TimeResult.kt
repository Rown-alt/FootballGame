package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results")
data class TimeResult (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "result_name") val recordName: String,
    @ColumnInfo(name = "result_time") val recordTime: String
)
