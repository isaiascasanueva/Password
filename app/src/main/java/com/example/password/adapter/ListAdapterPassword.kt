package com.example.password.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.password.DAO.getEntity.CredentialDeta
import com.example.password.R

class ListAdapterPassword:ListAdapter<CredentialDeta, ListAdapterPassword.ViewHolder>(DiffCallback) {



    companion object DiffCallback : DiffUtil.ItemCallback<CredentialDeta>() {

        override fun areItemsTheSame(oldItem: CredentialDeta, newItem: CredentialDeta): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CredentialDeta, newItem: CredentialDeta): Boolean {
            return oldItem == newItem
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.password_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapterPassword.ViewHolder, position: Int) {
        val password = getItem(position)//toca cada elemento para mandar a llamar a la funcion de bind
        holder.bind(password)
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nameText = view.findViewById<TextView>(R.id.email_name_text)
        private val passwordText = view.findViewById<TextView>(R.id.password)


        fun bind(credentialDeta: CredentialDeta) {
            nameText.text = credentialDeta.nombre
            passwordText.text = credentialDeta.Contrasenia
        }
    }
}