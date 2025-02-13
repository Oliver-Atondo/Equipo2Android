package com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2

import ComponentsActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.allison_olvera.MainMenuActivity
import com.desswapp.module4eqp2.excercise.home.allison_olvera.excercise2.LinearLayoutActivity
import com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2.recyclerview.RecyclerViewActivity
import com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise2.RelativeLayoutActivity

class MenuExercise2Activity : AppCompatActivity() {
    private lateinit var btnExit : Button
    private lateinit var btnFrameLayout : Button
    private lateinit var btnLinearLayout : Button
    private lateinit var btnRelativeLayout : Button
    private lateinit var btnConstrainLayout : Button
    private lateinit var btnRecyclerView : Button
    private lateinit var btnComponents : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_exercise2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

        btnExit.setOnClickListener {    //Sale de la app/Regresa al menú inicial
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

        btnFrameLayout.setOnClickListener {
            val  intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }

        btnLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        btnRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }

        btnConstrainLayout.setOnClickListener {
            val intent = Intent(this, ConstrainLayoutActivity::class.java)
            startActivity(intent)
        }

        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btnComponents.setOnClickListener {
            val intent = Intent(this, ComponentsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        btnExit = findViewById(R.id.btnExit)
        btnFrameLayout = findViewById(R.id.btnFrameLayout)
        btnLinearLayout = findViewById(R.id.btnLinearLayout)
        btnRelativeLayout = findViewById(R.id.btnRelativeLayout)
        btnConstrainLayout = findViewById(R.id.btnConstrainLayout)
        btnRecyclerView = findViewById(R.id.btnRecyclerView)
        btnComponents = findViewById(R.id.btnComponents)
    }
}