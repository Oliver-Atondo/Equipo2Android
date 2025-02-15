package com.desswapp.module4eqp2.excercise.home.allison_olvera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise1.InitialActivityAMOM
import com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2.MenuExercise2ActivityAMOM
import com.desswapp.module4eqp2.homework.allison_olvera.RegisterUserActivityAMOM

//import com.desswapp.module4eqp2.homework.allison_olvera.RegisterUserActivity

class MainMenuActivityAMOM : AppCompatActivity() {

    private lateinit var btnExercise1 : Button
    private lateinit var btnExercise2 : Button
    private lateinit var btnHomework : Button
    private lateinit var btnExit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu_amom)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

        btnExercise1.setOnClickListener {   //Ejercicios 1
            val intent = Intent(this, InitialActivityAMOM::class.java)
            startActivity(intent)
        }

        btnExercise2.setOnClickListener{    //Ejercicios 2
            val intent = Intent(this, MenuExercise2ActivityAMOM::class.java)
            startActivity(intent)
        }

        btnHomework.setOnClickListener {    //Tarea
            val intent = Intent(this, RegisterUserActivityAMOM::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {    //Sale de la app/Regresa al menú inicial
            finish()
        }

    }

    private fun initViews() {
        btnExercise1 = findViewById(R.id.btnExercise1)
        btnExercise2 = findViewById(R.id.btnExercise2)
        btnHomework = findViewById(R.id.btnHomework)
        btnExit = findViewById(R.id.btnExit)
    }

}