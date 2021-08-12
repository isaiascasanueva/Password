package com.example.password.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.password.MainActivity
import com.example.password.R
import com.example.password.ViewModel.FragtmentsViewModel
import com.example.password.databinding.BottomSheetDialogBinding
import com.example.password.databinding.FragmentCreatePasswordBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class CreatePassword : Fragment(R.layout.fragment_create_password) {

    private var tipService: String = ""

    private lateinit var model: FragtmentsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCreatePasswordBinding.inflate(inflater, container, false)

        val prueba = BottomSheetDialogBinding.inflate(inflater, container, false)

        model = ViewModelProvider(
            this
        ).get(FragtmentsViewModel::class.java)


        var value2 = arguments?.getInt("Numero", 0)
        Toast.makeText(context, value2.toString(), Toast.LENGTH_SHORT).show()



        val lista = binding.serviceLayout.lvdatos
        binding.serviceLayout.service.setOnClickListener {

            if (lista.visibility == View.VISIBLE) {
                lista.visibility = View.GONE
            } else {
                lista.visibility = View.VISIBLE
            }


        }

        val generatepass = binding.credentialLayout.generatePass

        generatepass.setOnClickListener {
            createSheetDialog(prueba)
        }

        createlisexpandible(binding, lista)

        val save = binding.credentialLayout.Save


        save.setOnClickListener {


            insertData(binding, lista, value2!!.toInt())

        }

        return binding.root

    }


    private fun insertData(binding: FragmentCreatePasswordBinding, lista: View, value2:Int) {
        val g: String = binding.credentialLayout.UserCredential.text.toString()

        createlisexpandible(binding, lista)
        //Table of credential
        val nameCredential = binding.serviceLayout.nameCredential.text.toString()
        tipService//tipo de servicio
        val password = binding.credentialLayout.passwordEnd.text.toString()
        val commentary = binding.credentialLayout.cometaryPassCreate.text.toString()


        Toast.makeText(requireContext(), g, Toast.LENGTH_SHORT).show()
        model.insercredential(nameCredential, value2, password, commentary)


    }


    private fun createSheetDialog(prueba: BottomSheetDialogBinding) {
        val bottomSheetDialog = BottomSheetDialog(
            requireContext(),
            R.style.BottomSheetDialogTheme
        )

        val bottomSheetView = LayoutInflater.from(requireContext()).inflate(
            R.layout.bottom_sheet_dialog, prueba.bottomSheet
        ) as LinearLayout?


        bottomSheetDialog.setContentView(bottomSheetView!!.rootView)
        bottomSheetDialog.show()
    }

    private fun createlisexpandible(binding: FragmentCreatePasswordBinding, lista: View) {


        val arrayAdapter: ArrayAdapter<*>

        val instrucciones = mutableListOf("Email", "app", "Redes sociales")
        val lvldatos = binding.serviceLayout.lvdatos
        val tipo_servicio = binding.serviceLayout.tipoServicio

        arrayAdapter =
            ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, instrucciones)

        lvldatos.adapter = arrayAdapter

        lvldatos.setOnItemClickListener { parent, view, position, id ->


//            Toast.makeText(
//                requireActivity(),
//                parent.getItemAtPosition(position).toString(),
//                Toast.LENGTH_LONG
//            ).show()


            tipo_servicio.text = getString(
                R.string.tipo_de_servicio_mod,
                parent.getItemAtPosition(position).toString()
            )

            tipService = instrucciones[position]

            lista.visibility = View.GONE

        }


    }


}