package com.example.password.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.password.R
import com.example.password.ViewModel.FragmentsViewModel
import com.example.password.adapter.SectionAdapterPassword
import com.example.password.databinding.FragmentHomeFragmentBinding
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {

    private lateinit var anAModel: FragmentsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  FragmentHomeFragmentBinding.inflate(inflater, container, false)
       // val view = inflater.inflate(R.layout.fragment_home_fragment, container, false)


        anAModel = ViewModelProvider(
            this
        ).get(FragmentsViewModel::class.java)



        downloadFakePassword(view)

        val fab: View = view.fab
        fab.setOnClickListener { view ->
            openCreatePass(view, fab)

        }

        return view.getRoot();

    }



    private fun openCreatePass(view: View, fab: View) {
        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show()


        fab.visibility = View.GONE

       openGetUser()

    }

    private fun downloadFakePassword(view: FragmentHomeFragmentBinding) {

        anAModel.getProfileCredential.observe(requireActivity(),{

        var recicler = view.sectionRecycler

        recicler.layoutManager = LinearLayoutManager(requireActivity())


        var adapter = SectionAdapterPassword(requireActivity())



        recicler.adapter = adapter

        anAModel.getDetailCredentialWithCredential()


            adapter.submitList(it)
        })

    }
//Pasar de un fragment a otro --> El fab lo movi a home fragment
    private fun openGetUser() {

    val fragment =  CreatePassword()
    var value2 = arguments?.getInt("Numero", 0)

    val bundle = Bundle()
    bundle.putInt("Numero", value2!!.toInt())
    fragment.arguments =  bundle

    val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
    transaction.replace(R.id.fragmentContainer, fragment)
    //transaction.addToBackStack(null)

    }
}