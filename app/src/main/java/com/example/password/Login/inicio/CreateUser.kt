package com.example.password.Login.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.password.DAO.Entitys.Profile
import com.example.password.ViewModel.MainViewModel
import com.example.password.Login.ViewLogin
import com.example.password.MainActivity
import com.example.password.databinding.ActivityCreatepasswordBinding

class CreateUser : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCreatepasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.create.setOnClickListener {

            val usercreate = binding.userCreateEmail.text.toString()
            val firstPass = binding.firstContra.text.toString()
            val verificPass = binding.firstContraverific.text.toString()

            if (firstPass.isEmpty() || verificPass.isEmpty() || usercreate.isEmpty()) {
                Toast.makeText(applicationContext, "No valido", Toast.LENGTH_LONG).show()


            } else {
                if (firstPass.length < 4 && verificPass.length < 4) {


                    Toast.makeText(applicationContext, "Contraseña Muy corta", Toast.LENGTH_LONG)
                        .show()

                } else {

                    if (firstPass == verificPass) {

                        createProfile(binding, firstPass)
                        Toast.makeText(applicationContext, "Contraseña Correcta", Toast.LENGTH_LONG)
                            .show()


                    } else {
                        Toast.makeText(applicationContext, "No valido", Toast.LENGTH_LONG).show()

                    }

                }


            }


        }

    }

    private fun createProfile(binding: ActivityCreatepasswordBinding, firtsPass: String) {

        viewModel = ViewModelProvider(
            this
        ).get(MainViewModel::class.java)//El contexto de la aplicacion en general

        val email = binding.userCreateEmail.text.toString()


        viewModel.insertProf(Profile(email, firtsPass))

        Toast.makeText(applicationContext, "No valido", Toast.LENGTH_LONG).show()

        val intent = Intent(this, ViewLogin::class.java)
        startActivity(intent)
        finish()

    }
}