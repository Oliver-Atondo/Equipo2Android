package com.desswapp.module4eqp2.homework.fernando_hernandez

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class AccountInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvFullName = findViewById<TextView>(R.id.tvFullName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvGender = findViewById<TextView>(R.id.tvGender)
        val tvPassword = findViewById<TextView>(R.id.tvPassword)
        val btnExit = findViewById<Button>(R.id.btnExit)

        intent.extras?.let { content ->
            tvFullName.text = String.format("%s %s", content.getString("name"), content.getString("lastName"))
            tvEmail.text = content.getString("email")
            tvGender.text = content.getString("gender")
            tvPassword.text = content.getString("password")
        }

        btnExit.setOnClickListener{
            finish()
        }

    }
}