package com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.allison_olvera.MainMenuActivityAMOM
import com.desswapp.module4eqp2.excercise.home.allison_olvera.excercise2.ComponentsActivityAMOM
import com.desswapp.module4eqp2.excercise.home.allison_olvera.excercise2.LinearLayoutActivityAMOM
import com.desswapp.module4eqp2.excercise.home.allison_olvera.excercise2.RelativeLayoutActivityAMOM
import com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2.recyclerview.RecyclerViewActivityAMOM
import com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise2.RelativeLayoutActivity

class MenuExercise2ActivityAMOM : AppCompatActivity() {
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
        setContentView(R.layout.activity_menu_exercise_amom)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

        btnExit.setOnClickListener {    //Sale de la app/Regresa al menú inicial
            finish()
        }

        btnFrameLayout.setOnClickListener {
            val  intent = Intent(this, FrameLayoutActivityAMOM::class.java)
            startActivity(intent)
        }

        btnLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivityAMOM::class.java)
            startActivity(intent)
        }

        btnRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivityAMOM::class.java)
            startActivity(intent)
        }

        btnConstrainLayout.setOnClickListener {
            val intent = Intent(this, ConstrainLayoutActivityAMOM::class.java)
            startActivity(intent)
        }

        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivityAMOM::class.java)
            startActivity(intent)
        }

        btnComponents.setOnClickListener {
            val intent = Intent(this, ComponentsActivityAMOM::class.java)
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