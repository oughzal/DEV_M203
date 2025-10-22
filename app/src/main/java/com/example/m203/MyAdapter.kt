package com.example.m203

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Smartwatch(
    val name: String,
    val price: Double,
    val isWaterRisistant: Boolean,
    val image: Int
)

class MyAdapter(
    context: Context,
    smatwatchList: MutableList<Smartwatch>
): ArrayAdapter<Smartwatch>(context,0, smatwatchList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_watch, parent, false)
        val smartwatch = getItem(position)
        val image = view.findViewById<ImageView>(R.id.image)
        val name = view.findViewById<TextView>(R.id.name)
        val price = view.findViewById<TextView>(R.id.price)
        val isWaterResistant = view.findViewById<Switch>(R.id.isWaterproof)
        image.setImageResource(smartwatch!!.image)
        name.text = smartwatch.name
        price.text = "$${smartwatch.price}"
        isWaterResistant.isChecked = smartwatch.isWaterRisistant

        return view

    }
}