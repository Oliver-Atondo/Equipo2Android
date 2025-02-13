package com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class RelativeLayoutActivity : LaunchGraphicLayoutsActivity() {
    lateinit var aviso: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relative_layout)
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
            radioButton = 0,
            spinner = 0,
            image = 1,
            imageButton = 1
        )

        val progressBar = findViewById<ProgressBar>(R.id.pbAvance)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        val cbAgree = findViewById<CheckBox>(R.id.cbAgree)
        val cbPrivacy = findViewById<CheckBox>(R.id.cbPrivacy)

        cbAgree.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Acepto terminos y condiciones", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Rechazo terminos y condiciones", Toast.LENGTH_SHORT).show()
            }
        }

        cbPrivacy.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Acepto aviso de privacidad", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Rechazo aviso de privacidad", Toast.LENGTH_SHORT).show()
            }
        }

        intent.extras.let {
            aviso = it?.getString("aviso").toString()
            tvTitulo.text = "${aviso} esto es un ${tvTitulo.text}"
        }

        progressBar.progress = calculateProgress()

        btnBack.setOnClickListener {
            finish()
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java).apply {
                putExtra("aviso", aviso)
            }
            startActivity(intent)
        }

    }
}