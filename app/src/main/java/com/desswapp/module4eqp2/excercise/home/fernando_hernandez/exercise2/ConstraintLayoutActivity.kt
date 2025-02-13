package com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class ConstraintLayoutActivity : LaunchGraphicLayoutsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constraint_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usados = ComponentsUsing(
            editText = 1,
            button = 1,
            textView = 1,
            checkBox = 1,
            radioButton = 1,
            spinner = 1,
            image = 1,
            imageButton = 1
        )

        val btnBack = findViewById<Button>(R.id.btnBack)
        val spContry = findViewById<Spinner>(R.id.spContry)
        val tvTitulo = findViewById<TextView>(R.id.tvTitle)
        val progressBar = findViewById<ProgressBar>(R.id.pbAvance)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)

        rgGender.setOnCheckedChangeListener { group, checkedId ->
            val name = getRgLabel(checkedId, false)
            Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        }

        progressBar.progress = calculateProgress()

        intent.extras.let {
            val aviso = it?.getString("aviso").toString()
            tvTitulo.text = "${aviso} esto es un ${tvTitulo.text}"
        }

        //SPINNER
        val data = arrayListOf("No selección", "México", "Argentina", "Colombia", "Ecuador", "Dinamarca", "España")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spContry.adapter = adapter

        spContry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = data[position]

                if (position == 0){
                }else{
                    Toast.makeText(this@ConstraintLayoutActivity, "Item seleccionado: $itemSelected", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun getRgLabel(checkedId: Int, isFromButton : Boolean): String {
        return when(checkedId){
            R.id.rbWoman ->{
                if (isFromButton) "M" else "Mujer"
            }

            R.id.rbMan ->{
                if (isFromButton) "H" else "Hombre"
            }
            else -> "No seleccionado"
        }
    }

}
