package com.desswapp.module4eqp2.excercise.home.oliver_atondo.exercise1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.desswapp.module4eqp2.R

class SecondActivityOAG : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_oag)

        val receivedNumber = intent.getIntExtra(InitialActivityOAG.EXTRA_NUMBER, 0)
        val tvReceivedNumber = findViewById<TextView>(R.id.tvReceivedNumber)
        val btnIncrement = findViewById<Button>(R.id.btnIncrement)

        tvReceivedNumber.text = "Número recibido: $receivedNumber"

        btnIncrement.setOnClickListener {
            val newNumber = receivedNumber + 1
            val resultIntent = Intent()
            resultIntent.putExtra(InitialActivityOAG.EXTRA_RESULT, newNumber)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
