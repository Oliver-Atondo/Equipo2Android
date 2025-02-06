package com.desswapp.module4eqp2.excercise.home.allison_olvera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class SecondActivityAMOM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_amom)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvGender = findViewById<TextView>(R.id.tvGender)
        val tvDeceased = findViewById<TextView>(R.id.tvDeceased)
        val btnReturnInfo = findViewById<Button>(R.id.btnReturnInfo)

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME")){
                val name = it.getString("EXTRA_NAME")
                tvName.text = "Nombre: $name"
            }
            if (it.containsKey("EXTRA_AGE")){
                val age = it.getInt("EXTRA_AGE")
                tvAge.text = "Edad: " + age.toString()
            }
            if (it.containsKey("EXTRA_GENDER")) {
                val gender = it.getChar("EXTRA_GENDER")
                tvGender.text = "Género: " + gender.toString()
            }
            if (it.containsKey("EXTRA_DECEASED")) {
                val deceased = it.getBoolean("EXTRA_DECEASED")
                val deceasedStr = if (deceased) "Vivo" else "Finado"
                tvDeceased.text = "Estado actual de la persona: " + deceasedStr
            }
        }

        btnReturnInfo.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT", true)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}