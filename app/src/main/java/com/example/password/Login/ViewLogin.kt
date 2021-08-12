package com.example.password.Login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.password.Login.inicio.CreateUser
import com.example.password.MainActivity
import com.example.password.R
import com.example.password.ViewModel.MainViewModel
import com.example.password.databinding.ActivityViewLoginBinding
import com.example.password.fragments.HomeFragment

class ViewLogin : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityViewLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this
        ).get(MainViewModel::class.java)//El contexto de la aplicacion en general
        openSesion()

        binding.Registro.setOnClickListener {

            val intent = Intent(this, CreateUser::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun openSesion() {

        binding.buttonDesbloq.setOnClickListener {
            val usuario = binding.Usuario.text.toString()
            val contasenia = binding.Contrasenia.text.toString()

            viewModel.CheckProfile(usuario, contasenia)

            getProfile()
        }
    }

    private fun getProfile() {
        viewModel.result.observe(this, Observer {

            if (it == 1) {
                binding.Usuario.setText("")
                binding.Contrasenia.setText("")
            } else {
                val intent = Intent(this, MainActivity::class.java)
                val id = 9
                intent.putExtra(MainActivity.idprofile, id)

                startActivity(intent)
                finish()
            }
        })

    }

}