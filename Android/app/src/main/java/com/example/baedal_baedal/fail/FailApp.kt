package com.example.baedal_baedal.fail

import android.app.Application

class FailApp : Application() {
    companion object{
        lateinit var instance: FailApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}