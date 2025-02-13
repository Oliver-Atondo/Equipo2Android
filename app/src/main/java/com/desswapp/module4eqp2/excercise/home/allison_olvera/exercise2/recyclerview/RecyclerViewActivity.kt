package com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desswapp.module4eqp2.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recicler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvAnimal = findViewById<RecyclerView>(R.id.rvSeries)

        val data = listOf(SeriesEntity("Flash", "9", "2014", "Netflix", ""),
            SeriesEntity("Supergirl", "6", "2015", "Netflix", ""),
            SeriesEntity("Lucifer", "6", "2016", "Netflix", ""),
            SeriesEntity("Almas perdidas", "5", "2005", "Amazon Prime Video", ""),
            SeriesEntity("The Rookie", "7", "2018", "Amazon Prime Video", ""),
            SeriesEntity("Lecciones de química", "1", "2023", "Apple TV+", ""),
            SeriesEntity("Arcane", "1", "2024", "Netflix", ""),
            SeriesEntity("The last of us", "1", "2024", "Max", ""),
        )

        val adapter = SeriesAdapter(data)
        rvAnimal.adapter = adapter
        rvAnimal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}