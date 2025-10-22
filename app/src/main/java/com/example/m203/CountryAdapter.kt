package com.example.m203

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

interface CountryEventListener {
    fun onFlagClicked(position: Int)
}

class CountryAdapter(
    context : Context,
    coutries : MutableList<Country>,
    val listener: CountryEventListener
) : ArrayAdapter<Country>(context, 0, coutries) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.country_item,
            parent,
            false
        )
        val country = countries[position]
        val flag = view.findViewById<ImageView>(R.id.imgFlag)
        val name = view.findViewById<TextView>(R.id.countryName)
        val capital = view.findViewById<TextView>(R.id.countryCapital)
        flag.setImageResource(country.imageId)

        name.text = country.name
        capital.text = country.capital
        flag.setOnClickListener {
            listener.onFlagClicked(position)
        }
        return view
    }
}