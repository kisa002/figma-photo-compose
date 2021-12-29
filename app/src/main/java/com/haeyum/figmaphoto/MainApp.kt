package com.haeyum.figmaphoto

import android.app.Application
import android.content.Context

class MainApp : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}