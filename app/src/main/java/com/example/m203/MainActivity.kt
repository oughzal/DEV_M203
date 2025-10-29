package com.example.m203

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m203.databinding.ActivityMainBinding
import com.example.m203.databinding.DialogPersonBinding
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var date = LocalDate.now()
        var time = LocalTime.now()
        binding.btnAlertDialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Alert Title")
            dialog.setMessage("voulez-vous supprimer cet élément ?")
            dialog.setNegativeButton("Non") { d, _ ->
                d.dismiss()
            }
            dialog.setPositiveButton("Oui") { d, _ ->
                Snackbar.make(binding.root, "Élément supprimé", Snackbar.LENGTH_SHORT).show()
            }
            dialog.setNeutralButton("Annuler") { d, _ ->
                d.dismiss()
            }
            dialog.create()
            dialog.show()
        }

        binding.tvDate.setOnClickListener {
            val datePicker = DatePickerDialog(this)
            datePicker.updateDate(date.year, date.monthValue - 1, date.dayOfMonth)
            datePicker.setOnDateSetListener { _, y, m, d ->
                date = LocalDate.of(y, m + 1, d)
                binding.tvDate.text = "%02d/%02d/%04d".format(d, m + 1, y)
            }
            datePicker.show()

        }


        binding.tvTime.setOnClickListener {
            val timePicker = TimePickerDialog(this, { _, h, m ->
                time = LocalTime.of(h, m)
                binding.tvTime.text = "%02d:%02d".format(h, m)
            }, time.hour, time.minute, true)
            timePicker.show()
        }


        binding.btnEditPerson.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.dialog_person, null)
            val nom = view.findViewById<EditText>(R.id.etNom)
            val prenom = view.findViewById<EditText>(R.id.etPrenom)
            val dialog = AlertDialog.Builder(this)
                .setTitle("Edit Person")
                .setView(view) // .setMessage() n'est pas utilisé ici
                .setPositiveButton("Save") { d, _ ->
                    Snackbar.make(binding.root, "Person saved", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { d, _ ->
                    d.dismiss()
                }
                .create()
            dialog.show()
        }

        binding.btnEditPersonBinding.setOnClickListener {
            val dialogBinding = DialogPersonBinding.inflate(layoutInflater)
            val dialog = AlertDialog.Builder(this)
                .setTitle("Edit Person")
                .setView(dialogBinding.root) // .setMessage() n'est pas utilisé ici
                .setPositiveButton("Save") { d, _ ->
                    Snackbar.make(binding.root, "Person saved", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { d, _ ->
                    d.dismiss()
                }
                .create()
            dialog.show()
        }
    }
}