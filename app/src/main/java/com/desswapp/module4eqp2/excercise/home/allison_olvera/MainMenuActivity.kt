package com.desswapp.module4eqp2.excercise.home.allison_olvera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.HomeActivity
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2.MenuExercise2Activity
import com.desswapp.module4eqp2.homework.allison_olvera.RegisterUserActivity

class MainMenuActivity : AppCompatActivity() {

    private lateinit var btnExercise2 : Button
    private lateinit var btnHomework : Button
    private lateinit var btnExit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

        btnExercise2.setOnClickListener{    //Ejercicio 2
            val intent = Intent(this, MenuExercise2Activity::class.java)
            startActivity(intent)
        }

        btnHomework.setOnClickListener {    //Tarea
            val intent = Intent(this, RegisterUserActivity::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {    //Sale de la app/Regresa al menú inicial
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initViews() {
        btnExercise2 = findViewById(R.id.btnExercise2)
        btnHomework = findViewById(R.id.btnHomework)
        btnExit = findViewById(R.id.btnExit)
    }

}