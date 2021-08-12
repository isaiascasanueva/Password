package com.example.password.Login.inicio

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.password.Login.ViewLogin
import com.example.password.databinding.ActivitySplashScreemBinding


class SplashScreem : AppCompatActivity() {
    private val DURATION_SPLASH = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashScreemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, ViewLogin::class.java)
            startActivity(intent)
            finish()
        }, DURATION_SPLASH.toLong())
    }
}