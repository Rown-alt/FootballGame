package com.example.footballgame

import android.app.Application
import com.example.data.di.dataModule
import com.example.footballgame.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(listOf(appModule, dataModule))
        }
    }
}