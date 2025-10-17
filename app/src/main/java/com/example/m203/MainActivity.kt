package com.example.m203

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.example.m203.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var n1 : EditText
    lateinit var n2 : EditText
    lateinit var operation : RadioGroup
    lateinit var btnCalculer : Button
    lateinit var txtResult : TextView
    lateinit var btnActivity2 : Button
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(R.layout.activity_main)



        n1 = findViewById(R.id.txtN1)
        n2 = findViewById(R.id.txtN2)
        operation = findViewById(R.id.rgOperation)
        btnCalculer = findViewById(R.id.btnCalculer)
        txtResult = findViewById(R.id.txtResult)
        btnActivity2 = findViewById(R.id.btnActivity2)

        btnCalculer.setOnClickListener {
           val r =  when(operation.checkedRadioButtonId){
                R.id.rbPlus -> n1.text.toString().toDouble() + n2.text.toString().toDouble()
                R.id.rbMinus -> n1.text.toString().toDouble() - n2.text.toString().toDouble()
                R.id.rbMult -> n1.text.toString().toDouble() * n2.text.toString().toDouble()
                R.id.rbDiv -> n1.text.toString().toDouble() / n2.text.toString().toDouble()
               else -> 0.0
            }
            txtResult.text = r.toString()

        }
        btnActivity2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val p = Person("nom","prenom")
            intent.putExtra("userID",123)
            intent.putExtra("p",p)
            startActivity(intent)
            Log.d("DEVOAM","GO")
        }

        binding.rgOperation.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                val r =  when(operation.checkedRadioButtonId){
                    R.id.rbPlus -> n1.text.toString().toDouble() + n2.text.toString().toDouble()
                    R.id.rbMinus -> n1.text.toString().toDouble() - n2.text.toString().toDouble()
                    R.id.rbMult -> n1.text.toString().toDouble() * n2.text.toString().toDouble()
                    R.id.rbDiv -> n1.text.toString().toDouble() / n2.text.toString().toDouble()
                    else -> 0.0
                }
                txtResult.text = r.toString()
            }
        })
        val list = listOf(1,2,3,4)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.sp1?.adapter =adapter
        binding.sp1?.onItemSelectedListener =object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        binding.txtN1.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                TODO("Not yet implemented")
            }

        })




    }
}