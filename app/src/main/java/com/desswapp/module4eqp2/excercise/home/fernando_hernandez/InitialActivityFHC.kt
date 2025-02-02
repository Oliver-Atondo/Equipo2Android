package com.desswapp.module4eqp2.excercise.home.fernando_hernandez

import android.content.Intent
import android.net.Uri
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

class InitialActivityFHC : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        val tvResult = findViewById<TextView>(R.id.tvResult)
        if (result.resultCode == RESULT_OK){
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT", false)
            tvResult.visibility = TextView.VISIBLE
            if (isCorrect == true){
                tvResult.text = String.format("Se recibio resultado: %s", isCorrect)
            }else{
                tvResult.text = String.format("Se recibio resultado: %s", isCorrect)
            }
        }else{
            Toast.makeText(this, "Result Cancel", Toast.LENGTH_SHORT).show()
            tvResult.visibility = TextView.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_initialfhc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSendSecondActivity = findViewById<Button>(R.id.btnSendSecondActivity)
        val btnSendPage = findViewById<Button>(R.id.btnSendPage)
        val btnExit = findViewById<Button>(R.id.button3)

        btnSendSecondActivity.setOnClickListener {
            // Abre la segunda actividad
            val intent = Intent(this, SecondActivityFHC::class.java).apply {
                putExtra("EX_NAME", "Fernando")
                putExtra("EX_AGE", 28)
                putExtra("EX_GENDER", "H")
            }
            register.launch(intent) //Lanza el activity y espera un resultado
        }

        btnSendPage.setOnClickListener {
            // Abre la página web de YouTube
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            // Cierra la actividad actual
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Arranca OnStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Arranca OnResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        val tvResult = findViewById<TextView>(R.id.tvResult)
        if (tvResult.visibility == TextView.VISIBLE){
            tvResult.visibility = TextView.GONE
        }
        Toast.makeText(this, "Arranca OnPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Arranca OnStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Arranca OnRestart", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Arranca OnDestroy", Toast.LENGTH_SHORT).show()
    }
}