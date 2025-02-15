package com.desswapp.module4eqp2.homework.allison_olvera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.excercise.home.allison_olvera.MainMenuActivityAMOM
import com.desswapp.module4eqp2.R

class UserDetailsActivityAMOM : AppCompatActivity() {

    private lateinit var tvNameUser : TextView
    private lateinit var tvLastNameUser : TextView
    private lateinit var tvEmailUser : TextView
    private lateinit var tvGenderUser : TextView
    private lateinit var tvPasswordUser : TextView
    private lateinit var btnReturn : Button
    private lateinit var btnExit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_details_amom)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastname = intent.getStringExtra("EXTRA_LASTNAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val gender = intent.getStringExtra("EXTRA_GENDER")
        val password = intent.getStringExtra("EXTRA_PASSWORD")

        tvNameUser.text = name
        tvLastNameUser.text = lastname
        tvEmailUser.text = email
        tvGenderUser.text = gender
        tvPasswordUser.text = password

        btnReturn.setOnClickListener {    //Sale de la app/Regresa al menú inicial
            finish()
        }

        btnExit.setOnClickListener {
            val intent = Intent(this, MainMenuActivityAMOM::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun initViews() {
        tvNameUser = findViewById(R.id.tvNameUser)
        tvLastNameUser = findViewById(R.id.tvLastNameUser)
        tvEmailUser = findViewById(R.id.tvEmailUser)
        tvGenderUser = findViewById(R.id.tvGenderUser)
        tvPasswordUser = findViewById(R.id.tvPasswordUser)
        btnReturn = findViewById(R.id.btnReturn)
        btnExit = findViewById(R.id.btnExit)
    }

}