package com.example.password.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.password.DAO.NamePassword
import com.example.password.DAO.Usuario
import com.example.password.R
import com.example.password.adapter.SectionAdapterPassword


class   HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home_fragment, container, false)
        val recicler = view.findViewById<RecyclerView>(R.id.section_recycler)

        recicler.layoutManager = LinearLayoutManager(requireActivity())

        val adapter = SectionAdapterPassword(requireActivity())


        recicler.adapter = adapter

        adapter.submitList(downloadFakePassword())

        return  view

    }

    private fun downloadFakePassword():List<NamePassword>{


        val fantasy1 = Usuario(1,"raul_mau@gmail.com","fs322fdsdfsdf")
        val password = listOf(fantasy1)


        val fantasy = Usuario(2,"13isaias@live.com","sd336fsdffd32sdf")
        val pass = listOf(fantasy)

        val fantasy2 = Usuario(2,"13isaias@live.com","sd336fsdffd32sdf")
        val pass3 = listOf(fantasy2)


        val passwordEnd = NamePassword("Netflix",password)
        val passwordEnd1 = NamePassword("Youtube",pass)
        val passwordEnd2 = NamePassword("Youtube",pass3)
        return listOf(passwordEnd,passwordEnd1,passwordEnd2)
    }

}