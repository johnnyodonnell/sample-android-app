package com.johnnyoodonnell.sampleapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class DataService : Service() {

    inner class DataBinder : Binder() {
        fun getData() : String {
            return "secret data"
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return DataBinder()
    }
}

