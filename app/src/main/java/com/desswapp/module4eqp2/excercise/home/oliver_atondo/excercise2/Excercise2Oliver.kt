package com.desswapp.module4eqp2.excercise.home.oliver_atondo.excercise2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.oliver_atondo.excercise2.recycle.AlumnoAdapter
import com.desswapp.module4eqp2.excercise.home.oliver_atondo.excercise2.recycle.AlumnoEntity

class Excercise2Oliver : AppCompatActivity() {

    lateinit var spinnerAlumnos: Spinner
    lateinit var rvAlumno: RecyclerView
    lateinit var adapter: AlumnoAdapter
    lateinit var listaAlumnos: List<AlumnoEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        spinnerAlumnos = findViewById(R.id.spinnerAlumnos)
        rvAlumno = findViewById(R.id.rvAlumno)

        listaAlumnos = listOf(
            AlumnoEntity("Carlos", 21, android.R.drawable.ic_menu_camera, "Masculino"),
            AlumnoEntity("Ana", 20, android.R.drawable.ic_menu_gallery,  "Femenino"),
            AlumnoEntity("Luis", 22, android.R.drawable.ic_menu_manage,  "Masculino")
        )

        val nombresAlumnos = listaAlumnos.map { it.nombre }
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nombresAlumnos)
        spinnerAlumnos.adapter = spinnerAdapter

        adapter = AlumnoAdapter(listOf(listaAlumnos.first()))
        rvAlumno.adapter = adapter
        rvAlumno.layoutManager = LinearLayoutManager(this)

        spinnerAlumnos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                adapter.updateData(listOf(listaAlumnos[position]))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}