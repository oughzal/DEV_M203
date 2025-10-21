package com.example.m203

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m203.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter : PersonAdaper = PersonAdaper(this, list)
        binding.lvPersonnes.adapter = adapter

        binding.btnAjouter.setOnClickListener {
            val nom = binding.etNom.text.toString()
            val prenom = binding.etPrenom.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0
            val person = Person(nom, prenom, age)
            list.add(person)
            adapter.notifyDataSetChanged()
        }

    }
}