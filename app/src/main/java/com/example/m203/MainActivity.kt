package com.example.m203

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AnimationUtils

import androidx.appcompat.app.AppCompatActivity
import com.example.m203.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnViewAnimation.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.anim1)
            binding.btnViewAnimation.startAnimation(anim)
            Snackbar.make(this,binding.root,"View Animation started",Snackbar.LENGTH_SHORT).show()
        }


        binding.btnObjectAnimation.setOnClickListener {
            val objectAnimator1 = ObjectAnimator.ofFloat(
                binding.imgOFPPT,
                "rotationY",
                0f,
                0f,
            )
            objectAnimator1.duration = 2000
               val objectAnimator2 = ObjectAnimator.ofFloat(
                binding.imgOFPPT,
                "rotation",
                0f,
                9000f,
            )
            objectAnimator2.duration = 20000
//            objectAnimator2.interpolator =  android.view.animation.BounceInterpolator()

            val animatorSet = AnimatorSet()
            animatorSet.play(objectAnimator1).after(objectAnimator2)
            animatorSet.start()

        }

    }
}