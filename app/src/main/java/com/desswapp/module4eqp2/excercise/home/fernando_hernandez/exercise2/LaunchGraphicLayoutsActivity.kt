package com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R



open class LaunchGraphicLayoutsActivity : AppCompatActivity() {
    lateinit var usados : ComponentsUsing
    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_launch_graphic_layouts)
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
            image = 0,
            imageButton = 0
        )

        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente)
        progressBar = findViewById(R.id.pbAvance)
        val etAviso = findViewById<EditText>(R.id.etAviso)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnSiguiente.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java).apply {
                putExtra("aviso", etAviso.text.toString())
            }
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finish()
        }

        progressBar.progress = calculateProgress()
    }

    fun calculateProgress(): Int {
        return (((usados.getEditText() + usados.getButton() +
                usados.getTextView() + usados.getCheckBox() +
                usados.getRadioButton() + usados.getSpinner() +
                usados.getImage() + usados.getImageButton()) * 100) / 8)
    }

}