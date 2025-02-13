package com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class LinearLayoutActivity : LaunchGraphicLayoutsActivity() {

    lateinit var aviso: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_linear_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        usados = ComponentsUsing(
            editText = 1,
            button = 1,
            textView = 1,
            checkBox = 0,
            radioButton = 0,
            spinner = 0,
            image = 1,
            imageButton = 1
        )

        val tvTitulo = findViewById<TextView>(R.id.mensageTitle)
        val progressBar = findViewById<ProgressBar>(R.id.pbAvance)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnImage = findViewById<ImageView>(R.id.btnImage)
        val btnImageButton = findViewById<ImageButton>(R.id.btnImageButton)

        intent.extras.let {
            aviso = it?.getString("aviso").toString()
            tvTitulo.text = "${aviso} esto es un ${tvTitulo.text}"
        }

        progressBar.progress = calculateProgress()

        btnImage.setOnClickListener {
            Toast.makeText(this, "Toco imagen", Toast.LENGTH_SHORT).show()
        }

        btnImageButton.setOnClickListener {
            Toast.makeText(this, "Toco boton con imagen", Toast.LENGTH_SHORT).show()
        }

        btnBack.setOnClickListener {
            finish()
        }
        btnNext.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java).apply {
                putExtra("aviso", aviso)
            }
            startActivity(intent)
        }


    }

}