package com.johnnyoodonnell.sampleapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class LoggerReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        println("New entry from Logger Broadcast Receiver")
        println("Action: " + intent.action)
        println("Entry: " + intent.getStringExtra("logEntry"))
    }
}

