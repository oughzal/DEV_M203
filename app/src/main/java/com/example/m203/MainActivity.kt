package com.example.m203

import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m203.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val prixTypes : Map<String, Double> = mapOf(
        "Basic" to 100.0,
        "Extra" to 250.0,
        "Luxe" to 400.0,
        "Sport" to 500.0
    )
    val carTypeList = listOf("Basic", "Extra", "Luxe","Sport")
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter<String>(this, R.layout.spinner_item, carTypeList)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spTypeCar.adapter = adapter

        binding.btnCalculer.setOnClickListener {
            val type = binding.spTypeCar.selectedItem.toString()
//            val prixParJour =when(type){
//                "Basic" -> 100.0
//                "Extra" -> 250.0
//                else -> 400.0
//            }
            val prixParJour = prixTypes[type] ?: 0.0
            val nbJours = binding.etNbJours.text.toString().toDoubleOrNull() ?: 0.0
            val prix = prixParJour * nbJours
            binding.tvPrix.text = "Prix total: $prix DH"
        }

    }
}