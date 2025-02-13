package com.desswapp.module4eqp2.excercise.home.fernando_hernandez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise1.PrimaryActivityFHC
import com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise2.LaunchGraphicLayoutsActivity

class InitialActivityFHC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_initialfhc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       val btnExercise1 = findViewById<Button>(R.id.btnExercise1)
       val btnExercise2 = findViewById<Button>(R.id.btnExercise2)
       val btnHomeWork = findViewById<Button>(R.id.btnHomeWork)
       val btnFinalExercise = findViewById<Button>(R.id.btnFinalExercise)
       val btnExit = findViewById<Button>(R.id.btnExit)

       btnExercise1.setOnClickListener {
           val intent = Intent(this, PrimaryActivityFHC::class.java)
           startActivity(intent)
       }

        btnHomeWork.setOnClickListener {
            Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show()
        }

        btnExercise2.setOnClickListener {
            val intent = Intent(this, LaunchGraphicLayoutsActivity::class.java)
            startActivity(intent)
        }

        btnFinalExercise.setOnClickListener {
            Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show()
        }

        btnExit.setOnClickListener {
            finish()
        }


    }
}