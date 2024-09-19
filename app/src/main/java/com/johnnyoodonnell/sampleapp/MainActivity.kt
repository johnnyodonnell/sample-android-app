package com.johnnyoodonnell.sampleapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // https://stackoverflow.com/a/3264647/5832619
        val tv = findViewById<TextView>(R.id.mainText)
        tv.text = "Welcome to the main page!"

        val updateMessageButton = findViewById<Button>(R.id.updateMessageButton)
        updateMessageButton.setOnClickListener {
            tv.text = "You clicked the button!!"

            // https://stackoverflow.com/a/3039718/5832619
            val h = Handler(Looper.getMainLooper())
            h.postDelayed({
                tv.text = "Welcome to main page!"
            }, 2000)
        }

        val openNewViewButton = findViewById<Button>(R.id.openNewViewButton)
        openNewViewButton.setOnClickListener {
            startActivity(Intent(this, HealthActivity::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }
}

