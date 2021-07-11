package com.example.password.Login.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.password.R
import com.example.password.databinding.ActivityCreatepasswordBinding

class CreatePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCreatepasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.create.setOnClickListener {
            val firstPass = binding.firstContra.text.toString()
            val verificPass = binding.firstContraverific.text.toString()

            if(firstPass.isEmpty()||verificPass.isEmpty()){
                Toast.makeText(applicationContext, "No valido", Toast.LENGTH_LONG).show()


            }else{
                if(firstPass.length<4 && verificPass.length<4){
                    Toast.makeText(applicationContext, "Contraseña Muy corta", Toast.LENGTH_LONG).show()

                }else{

                    if(firstPass== verificPass){
                        Toast.makeText(applicationContext, "Contraseña Correcta", Toast.LENGTH_LONG).show()

                    }else{
                        Toast.makeText(applicationContext, "No valido", Toast.LENGTH_LONG).show()

                    }

                }


            }



        }

    }
}