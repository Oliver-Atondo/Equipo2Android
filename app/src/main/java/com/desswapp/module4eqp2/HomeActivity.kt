package com.desswapp.module4eqp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.InitialActivityEMPV
import com.desswapp.module4eqp2.excercise.home.fernando_hernandez.InitialActivityFHC
import com.desswapp.module4eqp2.excercise.home.oliver_atondo.InitialActivityOAG

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
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnMember1.setOnClickListener { // Olvera Meza Allison Montserrat
            // Acción para el botón 1
        }

        btnMember2.setOnClickListener { // Atondo Gastelum Oliver Daniel
            val intent = Intent(this, InitialActivityOAG::class.java)
            startActivity(intent)
        }

        btnMember3.setOnClickListener { // Perez Valdez Edgar Michael
            val intent = Intent( this, InitialActivityEMPV::class.java)
            startActivity(intent)
        }

        btnMember4.setOnClickListener { // Hernández Calderón Fernando
            val intent = Intent(this, InitialActivityFHC::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finish()
        }

    }
}