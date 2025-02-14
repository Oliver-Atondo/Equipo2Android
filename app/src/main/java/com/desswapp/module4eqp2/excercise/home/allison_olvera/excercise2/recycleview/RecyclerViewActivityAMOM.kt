package com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desswapp.module4eqp2.R

class RecyclerViewActivityAMOM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_amom)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvAnimal = findViewById<RecyclerView>(R.id.rvSeries)

        val data = listOf(SeriesEntityAMOM("Flash", "9", "2014", "Netflix", ""),
            SeriesEntityAMOM("Supergirl", "6", "2015", "Netflix", ""),
            SeriesEntityAMOM("Lucifer", "6", "2016", "Netflix", ""),
            SeriesEntityAMOM("Almas perdidas", "5", "2005", "Amazon Prime Video", ""),
            SeriesEntityAMOM("The Rookie", "7", "2018", "Amazon Prime Video", ""),
            SeriesEntityAMOM("Lecciones de química", "1", "2023", "Apple TV+", ""),
            SeriesEntityAMOM("Arcane", "1", "2024", "Netflix", ""),
            SeriesEntityAMOM("The last of us", "1", "2024", "Max", ""),
        )

        val adapter = SeriesAdapterAMOM(data)
        rvAnimal.adapter = adapter
        rvAnimal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}