package com.example.m203

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

interface CountryEventListener {
    fun onFlagClicked(position: Int)
}

class CountryAdapter(private val itemList : List<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CountryViewHolder,
        position: Int
    ) {
        val country = itemList[position]
        holder.imageFlag.setImageResource(country.imageId)
        holder.name.text = country.name
        holder.capital.text = country.capital
    }

    override fun getItemCount(): Int = itemList.size


    class CountryViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        val imageFlag = itemView.findViewById<ImageView>(R.id.imgFlag)
        val name = itemView.findViewById<TextView>(R.id.countryName)
        val capital = itemView.findViewById<TextView>(R.id.countryCapital)
    }
}