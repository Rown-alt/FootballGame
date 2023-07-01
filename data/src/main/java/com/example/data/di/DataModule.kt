package com.example.data.di

import androidx.room.Room
import com.example.data.TimeResultDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single{
        Room.databaseBuilder(
            androidContext(),
            TimeResultDatabase::class.java, "results"
        ).build()
    }
    single {
        get<TimeResultDatabase>().timeResultDao()
    }
}