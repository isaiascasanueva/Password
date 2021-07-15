package com.example.password.adapter


import android.content.Context
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.password.DAO.NamePassword
import com.example.password.R

class SectionAdapterPassword(val context: Context) :
    ListAdapter<NamePassword, SectionAdapterPassword.ViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<NamePassword>() {
        override fun areItemsTheSame(oldItem: NamePassword, newItem: NamePassword): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NamePassword, newItem: NamePassword): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.list_section_password,
            parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionAdapterPassword.ViewHolder, position: Int) {
        val section = getItem(position)
        holder.bind(section)
    }


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val sectionNameText = view.findViewById<TextView>(R.id.section_name_text)


        //Tomar el recycler
        private val passRecycler = view.findViewById<RecyclerView>(R.id.pass_recycler)


        fun bind(section: NamePassword) {
            sectionNameText.text = section.nombre

            sectionNameText.setOnClickListener {
                if (section.expanded) {
                    sectionNameText.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_baseline_keyboard_arrow_up_24, 0, 0, 0
                    )
                    passRecycler.visibility = View.VISIBLE
                } else {
                    sectionNameText.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_baseline_expand_more, 0, 0, 0
                    )
                    passRecycler.visibility = View.GONE
                }

                section.expanded = !section.expanded

            }
            passRecycler.layoutManager = LinearLayoutManager(context)

            val movieAdapter = ListAdapterPassword()

            passRecycler.adapter = movieAdapter

            movieAdapter.submitList(section.UsuarioList)
        }
    }

}