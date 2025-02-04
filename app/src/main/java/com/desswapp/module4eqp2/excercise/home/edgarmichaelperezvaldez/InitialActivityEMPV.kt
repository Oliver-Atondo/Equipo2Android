package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class InitialActivityEMPV : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val tvRegistrySuccess = findViewById<TextView>(R.id.tvRegistryEMPV)
            val name = result.data?.getStringExtra("EXTRA_EMPV_NAME")
            val year = result.data?.getStringExtra("EXTRA_EMPV_YEAR")
            Toast.makeText(this, "isCorrect: $name", Toast.LENGTH_LONG).show()
            Toast.makeText(this, "isCorrect: $year", Toast.LENGTH_LONG).show()
                tvRegistrySuccess.text = "Gracias por registrarte, tu nombre es: $name"
        } else {
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_empv)
        Toast.makeText(this, "OnCreate", Toast.LENGTH_LONG).show()

        val btnExit = findViewById<Button>(R.id.btnReturnEMPV)
        val btnGoActivityWebPage = findViewById<Button>(R.id.btnGoActivityWebIntentEMPV)
        val btnRegister = findViewById<Button>(R.id.btnRegisterEMPV)

        btnExit.setOnClickListener {
            finish()
        }

        btnGoActivityWebPage.setOnClickListener {
            val intentWeb = Intent(this, ImplicitIntentActivityEMPV::class.java)
            startActivity(intentWeb)
        }

        btnRegister.setOnClickListener {
            val intentRegister = Intent( this, SecondActivityEMPV::class.java)
            register.launch(intentRegister)
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
    }
}