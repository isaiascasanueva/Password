package com.example.password.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.RequiresFeature
import com.example.password.R


class CreatePassword : Fragment(R.layout.fragment_create_password) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_create_password, container, false)

        val g = view.findViewById<View>(R.id.service)
        val lista = view.findViewById<View>(R.id.lvdatos)
        g.setOnClickListener {

            if (lista.visibility == View.VISIBLE) {
                lista.visibility = View.GONE
            } else {
                lista.visibility = View.VISIBLE
            }


        }


        createlisexpandible(view, lista)


        return view

    }

    private fun createlisexpandible(view: View, lista: View) {
        val arrayAdapter: ArrayAdapter<*>

        val instrucciones = mutableListOf("Email", "app", "Redes sociales")

        val lvldatos = view.findViewById<ListView>(R.id.lvdatos)
        val tipo_servicio = view.findViewById<TextView>(R.id.tipo_servicio)


        arrayAdapter =
            ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, instrucciones)

        lvldatos.adapter = arrayAdapter

        lvldatos.setOnItemClickListener() { parent, view, position, id ->

            Toast.makeText(
                requireActivity(),
                parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_LONG
            ).show()

            tipo_servicio.text = getString(
                R.string.tipo_de_servicio_mod,
                parent.getItemAtPosition(position).toString()
            )

            lista.visibility = View.GONE
        }

    }


}