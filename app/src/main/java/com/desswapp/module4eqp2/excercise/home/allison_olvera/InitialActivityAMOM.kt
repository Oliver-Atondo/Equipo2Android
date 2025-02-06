package com.desswapp.module4eqp2.excercise.home.allison_olvera

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class InitialActivityAMOM : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT", false)
            if (isCorrect == true)
                Toast.makeText(this, "Información regresada", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Error de información regresada", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "CANCELED", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_initial_amom)
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSpotify = findViewById<Button>(R.id.btnSpotify)
        val btnOpenSecondScreen = findViewById<Button>(R.id.btnOpenSecondScreen)

        btnSpotify.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/intl-es"))
            startActivity(Intent.createChooser(urlIntent, "Abrir usando:"))
        }

        btnOpenSecondScreen.setOnClickListener {
            val secondIntent = Intent(this, SecondActivityAMOM::class.java).apply {
                putExtra("EXTRA_NAME", "Allison Olvera")
                putExtra("EXTRA_AGE", 23)
                putExtra("EXTRA_GENDER", 'F')
                putExtra("EXTRA_DECEASED", true)
            }
            register.launch(secondIntent)
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

}