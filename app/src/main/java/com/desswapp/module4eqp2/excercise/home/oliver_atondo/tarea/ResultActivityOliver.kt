package com.desswapp.module4eqp2.excercise.home.oliver_atondo.tarea

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.desswapp.module4eqp2.R

class ResultActivityOliver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_oliver)

        val nombreTextView = findViewById<TextView>(R.id.textNombre)
        val apellidoTextView = findViewById<TextView>(R.id.textApellido)
        val correoTextView = findViewById<TextView>(R.id.textCorreo)
        val sexoTextView = findViewById<TextView>(R.id.textSexo)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val correo = intent.getStringExtra("correo")
        val sexo = intent.getStringExtra("sexo")

        nombreTextView.text = nombre
        apellidoTextView.text = apellido
        correoTextView.text = correo
        sexoTextView.text = sexo

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}