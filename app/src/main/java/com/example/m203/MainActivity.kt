package com.example.m203

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.m203.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var userScore = 0
    var computerScore = 0
    val list = mutableListOf<ImageView>()
    val drawables = listOf(
        R.drawable.rock,
        R.drawable.paper,
        R.drawable.scissors
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list.addAll(listOf(binding.rock, binding.paper, binding.scissors))
        list.forEachIndexed {i,it->
            it.setOnClickListener {
                binding.userHand.setImageResource(drawables[i])
                val computerChoice = (0..2).random()
                binding.computerHand.setImageResource(drawables[computerChoice])
                val user = drawables[i]
                val computer = drawables[computerChoice]
                if(user == computer) return@setOnClickListener
                if(
                    (user==R.drawable.rock) && (computer==R.drawable.scissors) ||
                    (user==R.drawable.paper) && (computer==R.drawable.rock) ||
                    (user==R.drawable.scissors) && (computer==R.drawable.paper)
                ){
                    userScore +=1
                    binding.tvUserScore.text = "User : $userScore"
                }else{
                    computerScore +=1
                    binding.tvComputerScore.text = "Computer : $computerScore"
                }
                GlobalScope.launch (Dispatchers.Main) {
                    repeat(100){
                        binding.computerHand.setImageResource(drawables[(0..2).random()])
                        delay(20)
                    }
                }
            }
        }

    }
}