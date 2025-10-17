package com.example.m203

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)
        val p = intent.getSerializableExtra("p", Person::class.java)
        val userId = intent.getIntExtra("userId", 0)
        //utiliser les valeurs dans l'activity

    }
}