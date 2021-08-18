package com.example.password.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.password.DAO.getEntity.DetailCredential
import com.example.password.DAO.getEntity.NameCredential
import com.example.password.R
import com.example.password.adapter.SectionAdapterPassword
import com.example.password.databinding.FragmentHomeFragmentBinding
import com.google.android.material.snackbar.Snackbar


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

        val fab: View = view.fab
        fab.setOnClickListener { view ->
            openCreatePass(view, fab)

        }




       // val first: String by lazy { arguments?.getString("holaaaa") ?: "default" }

//        val bundle = arguments
//        val message = bundle!!.getString("mText")
//





        return view.getRoot();

    }



    private fun openCreatePass(view: View, fab: View) {
        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show()
        fab.visibility = View.GONE
        val fragment =  CreatePassword()
       openGetUser(fragment)
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
//Pasar de un fragment a otro --> El fab lo movi a home fragment
    private fun openGetUser(fragment: Fragment) {


//        val resultado = use.getInt(MainActivity.idprofile)
//        val r = resultado.toString()
//        val bundle = Bundle()
//        bundle.putInt("Numero", resultado)
//        fragment.arguments = bundle
//
//        supportFragmentManager.beginTransaction().apply {
//
//            replace(R.id.fragmentContainer, fragment)
//            commit()
//
//        }
//
//    val nuevoFragmento: Fragment = CreatePassword()
    var value2 = arguments?.getInt("Numero", 0)
    //Toast.makeText(context, value2.toString(), Toast.LENGTH_SHORT).show()
    val bundle = Bundle()
    bundle.putInt("Numero", value2!!.toInt())
    fragment.arguments =  bundle

    val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
    transaction.replace(R.id.fragmentContainer, fragment)
    transaction.addToBackStack(null)

    transaction.commit()



    }
}