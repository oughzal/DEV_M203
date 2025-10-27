package com.example.m203

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.m203.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), CountryEventListener {

    lateinit var binding: ActivityMainBinding
    lateinit var countryAdapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CountryAdapter(countries,this)
        binding.rvCountries.layoutManager = GridLayoutManager(this, 3)
        binding.rvCountries.adapter = adapter

    }

    override fun onFlagClicked(position: Int) {
        val country = countries[position]
        Snackbar.make(this,binding.root,"You clicked on ${country.name} flag",Snackbar.LENGTH_LONG).show()
    }


}
