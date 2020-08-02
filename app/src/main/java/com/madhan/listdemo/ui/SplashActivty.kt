package com.madhan.listdemo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.madhan.listdemo.R

class SplashActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activty)
        Handler(Looper.getMainLooper()).postDelayed({
            //Activity Intent after 3000ms
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, 3000)
    }
}