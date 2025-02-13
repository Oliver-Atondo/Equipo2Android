package com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class SecondActivityFHC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secondfhc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<Button>(R.id.btnBack)
        val tvParameter1 = findViewById<TextView>(R.id.tvParameter1)
        val tvParameter2 = findViewById<TextView>(R.id.tvParameter2)
        val tvParameter3 = findViewById<TextView>(R.id.tvParameter3)

        intent.extras?.let { content ->

            if (content.containsKey("EX_NAME")) {
                tvParameter1.text = String.format("Nombre: %s", content.getString("EX_NAME"))
            }
            if (content.containsKey("EX_AGE")) {
                tvParameter2.text = String.format("Edad: %d", content.getInt("EX_AGE"))

            }
            if (content.containsKey("EX_GENDER")) {
                tvParameter3.text = String.format("Genero: %s", content.getString("EX_GENDER"))
            }
        }


        btnBack.setOnClickListener {
            // Regresa a la actividad anterior y envia un intent con el resultado
            val returnIntent = Intent().apply{
                putExtra("EXTRA_IS_CORRECT", true)
            }
            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }
}