package com.example.m203

import android.app.ActivityOptions
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.m203.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.enterTransition = TransitionInflater.from(this).inflateTransition(R.anim.slide_in_right)
        window.exitTransition = TransitionInflater.from(this).inflateTransition(R.anim.slide_out_left)

        binding.animateButton.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.anim_scale )
            binding.imgAnim.startAnimation(anim)
        }

        binding.btnToActivity.setOnClickListener {
            val intent = android.content.Intent(this, MainActivity2::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_out_left,
                R.anim.slide_in_right
            )
            val transition = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent ,transition)
        }


    }
}