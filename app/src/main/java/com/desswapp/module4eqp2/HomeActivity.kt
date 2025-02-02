package com.desswapp.module4eqp2

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMember1 = findViewById<Button>(R.id.btnMember1)
        val btnMember2 = findViewById<Button>(R.id.btnMember2)
        val btnMember3 = findViewById<Button>(R.id.btnMember3)
        val btnMember4 = findViewById<Button>(R.id.btnMember4)

        btnMember1.setOnClickListener {
            // Acción para el botón 1
        }

        btnMember2.setOnClickListener {
            // Acción para el botón 2
        }

        btnMember3.setOnClickListener {
            // Acción para el botón 3
        }

        btnMember4.setOnClickListener {
            // Acción para el botón 4
        }


    }
}