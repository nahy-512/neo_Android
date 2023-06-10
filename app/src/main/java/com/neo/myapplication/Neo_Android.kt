package com.neo.myapplication

import android.app.Application
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Neo_Android : Application() {

    companion object {
        lateinit var mSharedPreferences: SharedPreferences
    }
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        mSharedPreferences = applicationContext.getSharedPreferences("Neo_Android", MODE_PRIVATE)
    }

}