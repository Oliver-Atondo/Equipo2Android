package com.desswapp.module4eqp2.homework.oliver_atondo

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.desswapp.module4eqp2.R

class RegisterActivityOliver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_oliver)

        val nombre = findViewById<EditText>(R.id.editNombre)
        val apellido = findViewById<EditText>(R.id.editApellido)
        val correo = findViewById<EditText>(R.id.editCorreo)
        val contraseña = findViewById<EditText>(R.id.editContraseña)
        val sexoSpinner = findViewById<Spinner>(R.id.spinnerSexo)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnSalir = findViewById<Button>(R.id.btnSalir)
        val editPass = findViewById<EditText>(R.id.editContraseña)
        val cbMostrarPass = findViewById<CheckBox>(R.id.cbMostrarContraseña)

        val opcionesSexo = arrayOf("Masculino", "Femenino", "Otro")
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, opcionesSexo)
        sexoSpinner.adapter = adapter

        btnSalir.setOnClickListener {
            finish()
        }

        cbMostrarPass.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                editPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            editPass.setSelection(editPass.text.length)
        }

        btnRegistrar.setOnClickListener {
            val nombreText = nombre.text.toString()
            val apellidoText = apellido.text.toString()
            val correoText = correo.text.toString()
            val passText = contraseña.text.toString()
            val sexoText = sexoSpinner.selectedItem.toString()

            if (nombreText.isEmpty() || apellidoText.isEmpty() || correoText.isEmpty() || passText.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ResultActivityOliver::class.java)
                intent.putExtra("nombre", nombreText)
                intent.putExtra("apellido", apellidoText)
                intent.putExtra("correo", correoText)
                intent.putExtra("sexo", sexoText)
                startActivity(intent)
            }
        }
    }
}