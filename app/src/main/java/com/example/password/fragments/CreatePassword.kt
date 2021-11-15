package com.example.password.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.Entitys.DetailCredential
import com.example.password.DAO.getEntity.CredentialDeta
import com.example.password.DAO.getEntity.NameCredential
import com.example.password.R
import com.example.password.ViewModel.FragmentsViewModel
import com.example.password.databinding.*
import com.google.android.material.bottomsheet.BottomSheetDialog


class CreatePassword : Fragment(R.layout.fragment_create_password) {

    private var tipService: String = ""

    private lateinit var anAModel:FragmentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCreatePasswordBinding.inflate(inflater, container, false)

        val prueba = BottomSheetDialogBinding.inflate(inflater, container, false)

        val appbar = AppBarBinding.inflate(inflater, container, false)

        val createCredential = CcCredencialBinding.inflate(inflater, container, false)

        val view =  FragmentHomeFragmentBinding.inflate(inflater, container, false)


        anAModel = ViewModelProvider(
            this
        ).get(FragmentsViewModel::class.java)


        var value2 = arguments?.getInt("Numero", 0)


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
            openGetUser(appbar, value2)
        }

        return binding.root

    }

    private fun openGetUser(appBarBinding: AppBarBinding, value2: Int) {

        //mandar las credenciales

        val nuevoFragmento: Fragment = HomeFragment()

        val bundle = Bundle()
        bundle.putInt("Numero", value2!!.toInt())
        nuevoFragmento.arguments = bundle
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, nuevoFragmento)

        // Commit a la transacción

        // Commit a la transacción
        transaction.remove(this).commit()

    }

    private fun insertData(binding: FragmentCreatePasswordBinding, lista: View, value2: Int) {
        //Poner restricciones para que no se se mande el formulario si los principales campos no van
        //Obtener los
        val usuario: String = binding.credentialLayout.UserCredential.text.toString()

        createlisexpandible(binding, lista)
        //Table of credential
        val nameCredential = binding.serviceLayout.nameCredential.text.toString()

        tipService//tipo de servicio
        /**/
        val password = binding.credentialLayout.passwordEnd.text.toString()
        val commentary = binding.credentialLayout.cometaryPassCreate.text.toString()

        Toast.makeText(requireContext(), usuario, Toast.LENGTH_LONG).show()

        anAModel.insertDetailCredential(DetailCredential(tipService, usuario, password, commentary))


        anAModel.insertprofile.observe(requireActivity(), {

            anAModel.insertCedential(Credential(nameCredential, value2, it.get(0).id_detail_profile))
        })

        anAModel.getLastProfileCredential.observe(requireActivity(), {

            for (credencial in it) {

                val pass: List<CredentialDeta> = listOf(
                    CredentialDeta(
                        credencial.credential.id_credential,
                        credencial.credential.name_credential,
                        credencial.detailCredential.password
                    )
                )

                NameCredential(credencial.credential.name_credential, pass)
                //    Toast.makeText(requireContext(),   credencial.credential.id_credential.toString(), Toast.LENGTH_LONG).show()
            }


        })


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

