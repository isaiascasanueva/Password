package com.example.password.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.password.DAO.MainViewModel
import com.example.password.MainActivity
import com.example.password.databinding.ActivityViewLoginBinding

class ViewLogin : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel = ViewModelProvider(
            this
        ).get(MainViewModel::class.java)//El contexto de la aplicacion en general


        viewModel = ViewModelProvider(
            this
        ).get(MainViewModel::class.java)//El contexto de la aplicacion en general

        binding.buttonDesbloq.setOnClickListener {
            val usuario = binding.Usuario.text.toString()
            val contasenia = binding.Contrasenia.text.toString()

            viewModel.CheckProfile(usuario, contasenia)

            viewModel.insertprofile.observe(this, Observer {

                if (viewModel.result.value == 1) {
                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
                    binding.Usuario.setText("")
                    binding.Contrasenia.setText("")

                } else {
                    if (viewModel.result.value == 0) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    }


                }

            })

        }


    }


}