package com.example.password.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.password.MainActivity
import com.example.password.R
import com.example.password.databinding.ActivityViewLoginBinding

class view_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonDesbloq.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}