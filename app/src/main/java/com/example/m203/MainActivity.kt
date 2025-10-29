package com.example.m203

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.m203.databinding.ActivityMainBinding
import java.time.LocalDate
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var selectedDate= Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShowAlertDialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
                .setTitle("Alert Dialog")
                .setMessage("Supprimer cet élément ?")
                .setNegativeButton("NON") { dialogInterface, _ ->
                    dialogInterface.dismiss()
                }
                .setPositiveButton("OUI") { dialogInterface, _ ->
                    dialogInterface.dismiss()
                }
                .setNeutralButton("Annuler",null)
                .create()
            dialog.show()
        }

        binding.btnShowDatePickerDialog.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = android.app.DatePickerDialog(this,
                { _, y, m, d ->
                    selectedDate.set(y, m, d)
                    binding.tvDate.text = "$d/${m + 1}/$y"
                }, year, month, day)
            datePickerDialog.show()
        }

        binding.btnShowTimePickerDialog.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = android.app.TimePickerDialog(this,
                { _, h, m ->
                    binding.tvTime.text = String.format("%02d:%02d", h, m)
                }, hour, minute, true)
            timePickerDialog.show()
        }

    }
}