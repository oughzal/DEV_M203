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
import com.example.m203.databinding.CountryItemBinding

interface CountryEventListener {
    fun onFlagClicked(position: Int)
}

class CountryAdapter(private val itemList : List<Country>,val listener : CountryEventListener) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
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

        holder.bind(position)
    }

    override fun getItemCount(): Int = itemList.size


    inner class CountryViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        val binding = CountryItemBinding.bind(itemView)

        fun bind(position: Int) {
            val country = itemList[position]
            binding.imgFlag.setImageResource(country.imageId)
            binding.countryName.text = country.name
            binding.countryCapital.text = country.capital
            binding.imgFlag.setOnClickListener {
                listener.onFlagClicked(position)
            }

        }

    }
}