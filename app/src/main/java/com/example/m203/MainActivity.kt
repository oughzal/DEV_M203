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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculer.setOnClickListener {
            val birthDate = LocalDate.of(
                binding.dpDate.year,
                binding.dpDate.month + 1,
                binding.dpDate.dayOfMonth
            )
            val today = LocalDate.now()
            var ageInDays = birthDate.until(today, ChronoUnit.DAYS)
            var ageInWeeks = birthDate.until(today, ChronoUnit.WEEKS)
            binding.tvAgeInDays.text = "Age en jours : $ageInDays"
            binding.tvAgeInWeeks.text = "Age en semaines : $ageInWeeks"
            var dateCalcul = LocalDate.of(
                binding.dpDate.year,
                binding.dpDate.month + 1,
                binding.dpDate.dayOfMonth
            )
            val y = binding.etYear.text.toString().toLong()
            val m = binding.etMonth.text.toString().toLong()
            val w = binding.etWeek.text.toString().toLong()
            val d = binding.etDay.text.toString().toLong()
            when (binding.rgOperation.checkedRadioButtonId) {
                R.id.rbPlus -> {
                    dateCalcul = dateCalcul.plusYears(y)
                    dateCalcul = dateCalcul.plusMonths(m)
                    dateCalcul = dateCalcul.plusWeeks(w)
                    dateCalcul = dateCalcul.plusDays(d)
                }

                R.id.rbMinus -> {
                    dateCalcul = dateCalcul.minusYears(y)
                    dateCalcul = dateCalcul.minusMonths(m)
                    dateCalcul = dateCalcul.minusWeeks(w)
                    dateCalcul = dateCalcul.minusDays(d)
                }
            }
            val s = dateCalcul.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            binding.tvDateAfterCalculation.text = "Date après calcul : $s"
        }

    }
}