package com.desswapp.module4eqp2.excercise.home.oliver_atondo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.oliver_atondo.exercise2.Excercise2Oliver
import com.desswapp.module4eqp2.excercise.home.oliver_atondo.exercise1.InitialActivityOAG
import com.desswapp.module4eqp2.homework.oliver_atondo.RegisterActivityOliver

class MenuDeOliver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_de_oliver)

        // Botones
        val btnEjercicio1 = findViewById<Button>(R.id.btnEjercicio1)
        val btnEjercicio2 = findViewById<Button>(R.id.btnEjercicio2)
        val btnTarea1 = findViewById<Button>(R.id.btnTarea1)
        val btnEjerciciosFinales = findViewById<Button>(R.id.btnEjerciciosFinales)
        val btnExit = findViewById<Button>(R.id.btnParaSalir)

        // Eventos de clic para abrir actividades
        btnEjercicio1.setOnClickListener {
            startActivity(Intent(this, InitialActivityOAG::class.java))
        }

        btnEjercicio2.setOnClickListener {
            startActivity(Intent(this, Excercise2Oliver::class.java))
        }

        btnTarea1.setOnClickListener {
            startActivity(Intent(this, RegisterActivityOliver::class.java))
        }

        btnEjerciciosFinales.setOnClickListener {
            //startActivity(Intent(this, EjerciciosFinales::class.java))
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}