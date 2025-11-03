package com.example.m203

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.m203.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val appname = this.getString(R.string.app_name)
        val primaryColor = this.getColor(R.color.primaryColor)


    }
}