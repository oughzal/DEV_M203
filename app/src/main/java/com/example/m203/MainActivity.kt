package com.example.m203

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.m203.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private val choises = listOf<Int>(R.id.btnChoice1, R.id.btnChoice2, R.id.btnChoice3, R.id.btnChoice4)
    private var correctChoice : Country? = null
    val selectedCountries = mutableListOf<Country>()
    var correctButton : Int? = null
    var score = 0

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupQuestion()

    }
    fun setupQuestion(){
        // choisir 4 counties aléatoirement depuis la liste countries
        selectedCountries.clear()
        selectedCountries.addAll(countries.shuffled().take(4))
        correctChoice = selectedCountries.random()
        binding.flag.setImageResource(correctChoice!!.imageId)
    var i = 0
        for (btnId in choises){
            val btn : Button = findViewById(btnId)
            btn.text = selectedCountries[i].name
            if (selectedCountries[i] == correctChoice){
                correctButton = btn.id
            }
            btn.setOnClickListener {
                if (correctButton == it.id){
                    score += 1
                } else {
                    score -= 1
                }
                binding.score.text = "$score"
                setupQuestion()
            }
            i++
        }


    }
}