package com.desswapp.module4eqp2.excercise.home.oliver_atondo.excercise2.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.desswapp.module4eqp2.R

class AlumnoAdapter(private var listaAlumnos: List<AlumnoEntity>) :
    RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder>() {

    class AlumnoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvEdad: TextView = view.findViewById(R.id.tvEdad)
        val ivFoto: ImageView = view.findViewById(R.id.ivFoto)

        fun bind(alumno: AlumnoEntity) {
            tvNombre.text = alumno.nombre
            tvEdad.text = "Edad: ${alumno.edad}"
            ivFoto.setImageResource(alumno.foto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alumno, parent, false)
        return AlumnoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoViewHolder, position: Int) {
        holder.bind(listaAlumnos[position])
    }

    override fun getItemCount(): Int = listaAlumnos.size

    fun updateData(newData: List<AlumnoEntity>) {
        listaAlumnos = newData
        notifyDataSetChanged()
    }
}