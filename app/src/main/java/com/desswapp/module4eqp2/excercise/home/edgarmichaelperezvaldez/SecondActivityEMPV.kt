package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class SecondActivityEMPV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_empv)

        //Obtener elementos del template
        val etName = findViewById<EditText>(R.id.etNameEMPV)
        val etYear = findViewById<EditText>(R.id.etYear)
        val btnCompleteRegister = findViewById<Button>(R.id.btnCompleteRegister)
        val btnBackToMain = findViewById<Button>(R.id.btnBackToMainEMPV)


        etName.setText("Toca para editar")
        etYear.setText("Toca para editar")

        btnCompleteRegister.setOnClickListener {
            val userName = etName.text.toString()
            val userYear = etYear.text.toString()
            val resultIntent = Intent().apply {
                putExtra("EXTRA_EMPV_NAME", userName)
                putExtra("EXTRA_EMPV_YEAR", userYear)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
        btnBackToMain.setOnClickListener {
            finish()
        }
    }
}