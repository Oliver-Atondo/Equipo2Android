package com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.allison_olvera.MainMenuActivity

class ConstrainLayoutActivity : AppCompatActivity() {

    private lateinit var btnExit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constrain_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

        btnExit.setOnClickListener {    //Sale de la app/Regresa al menú inicial
            val intent = Intent(this, MenuExercise2Activity::class.java)
            startActivity(intent)
        }

    }

    private fun initViews() {
        btnExit = findViewById(R.id.btnExit)
    }

}