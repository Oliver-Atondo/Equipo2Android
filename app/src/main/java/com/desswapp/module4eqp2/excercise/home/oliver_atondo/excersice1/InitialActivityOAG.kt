package com.desswapp.module4eqp2.excercise.home.oliver_atondo.excersice1

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

class InitialActivityOAG : AppCompatActivity() {

    companion object {
        const val EXTRA_NUMBER = "extra_number"
        const val EXTRA_RESULT = "extra_result"
    }

    private var currentNumber = 0

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val resultTextView = findViewById<TextView>(R.id.tvResult)
        if (result.resultCode == RESULT_OK) {
            val newNumber = result.data?.getIntExtra(EXTRA_RESULT, 0) ?: 0
            currentNumber = newNumber
            resultTextView.visibility = TextView.VISIBLE
            resultTextView.text = "Contador actualizado: $currentNumber"
        } else {
            Toast.makeText(this, "Operación cancelada", Toast.LENGTH_SHORT).show()
            resultTextView.visibility = TextView.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_initial_oag)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSendSecondActivity = findViewById<Button>(R.id.btnSendSecondActivity)
        val btnSendPage = findViewById<Button>(R.id.btnSendPage)
        val btnExit = findViewById<Button>(R.id.button3)

        btnSendSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivityOAG::class.java)
            intent.putExtra(EXTRA_NUMBER, currentNumber)
            register.launch(intent)
        }

        btnSendPage.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chess.com/"))
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show()
    }
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show()
    }
}