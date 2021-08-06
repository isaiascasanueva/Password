package com.example.password.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.password.DAO.getEntity.NameCredential
import com.example.password.DAO.getEntity.DetailCredential
import com.example.password.R
import com.example.password.adapter.SectionAdapterPassword
import com.example.password.databinding.FragmentHomeFragmentBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  FragmentHomeFragmentBinding.inflate(inflater, container, false)
       // val view = inflater.inflate(R.layout.fragment_home_fragment, container, false)
        val recicler = view.sectionRecycler

        recicler.layoutManager = LinearLayoutManager(requireActivity())

        val adapter = SectionAdapterPassword(requireActivity())


        recicler.adapter = adapter

        adapter.submitList(downloadFakePassword())



        return view.getRoot();

    }

    private fun downloadFakePassword(): List<NameCredential> {


        val pass1 = DetailCredential(1, "raul_mau@gmail.com", "fs322fdsdfsdf")
        val password = listOf(pass1)


        val pass2 = DetailCredential(2, "13isaias@live.com", "sd336fsdffd32sdf")
        val password1 = listOf(pass2)

        val pass3 = DetailCredential(2, "13isaias@live.com", "sd336fsdffd32sdf")
        val password2 = listOf(pass3)


        val passwordEnd = NameCredential("Netflix", password)
        val passwordEnd1 = NameCredential("Youtube", password1)
        val passwordEnd2 = NameCredential("Youtube", password2)
        return listOf(passwordEnd, passwordEnd1, passwordEnd2)
    }

}