package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class ImplicitIntentActivityEMPV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wikipedia.com"))
        val btnWeb = findViewById<Button>(R.id.btnToWebEMPV)
        val btnBackMain = findViewById<Button>(R.id.btnBackFromWebEMPV)

        btnWeb.setOnClickListener {
            startActivity(Intent.createChooser(urlIntent, "Elige una aplicación: "))
        }

        btnBackMain.setOnClickListener {
            finish()
        }
    }
}