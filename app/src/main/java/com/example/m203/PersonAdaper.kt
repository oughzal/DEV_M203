package com.example.m203

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

interface OnPersonClickListener {
    fun onPersonClick(position: Int)
    fun onRemoveClick(position: Int)

}

class PersonAdaper(
    context : Context,
    list : MutableList<Person>,
    private val listener: OnPersonClickListener
) : ArrayAdapter<Person>(context, 0, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: View.inflate(context, R.layout.person_item, null)
        val person = list[position]
        val tvnom = view.findViewById<TextView>(R.id.tvNom)
        val tvprenom= view.findViewById<TextView>(R.id.tvPrenom)
        val tvage = view.findViewById<TextView>(R.id.tvAge)
        val btnRemove = view.findViewById<ImageView>(R.id.btnRemove)
        tvnom.text = person.nom
        tvprenom.text = person.prenom
        tvage.text = person.age.toString()

        btnRemove.setOnClickListener {
            listener.onRemoveClick(position)
        }
        // code to bind person data to view elements goes here
        return view
    }
}