package com.example.m203

import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m203.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CountryEventListener {

    lateinit var binding: ActivityMainBinding
    lateinit var countryAdapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countryAdapter = CountryAdapter(this, countries,this)
        binding.lvCountries.adapter = countryAdapter
//        binding.lvCountries.setOnItemClickListener { _, _, position, _ ->
//            val country = countries[position]
//            binding.flag.setImageResource(country.imageId)
//            binding.countryName.text = "${country.name} (${country.capital})"
//
//        }
    }

    override fun onFlagClicked(position: Int) {
        val country = countries[position]
        binding.flag.setImageResource(country.imageId)
        binding.countryName.text = "${country.name} (${country.capital})"
    }


}
