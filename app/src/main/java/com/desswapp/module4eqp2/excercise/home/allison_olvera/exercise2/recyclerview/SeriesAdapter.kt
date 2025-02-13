package com.desswapp.module4eqp2.excercise.home.allison_olvera.exercise2.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desswapp.module4eqp2.R

class  SeriesAdapter(val list: List<SeriesEntity>) : RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>() {

    class SeriesViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvSeason = view.findViewById<TextView>(R.id.tvSeason)
        val tvYear = view.findViewById<TextView>(R.id.tvYear)
        val tvWhereToLook = view.findViewById<TextView>(R.id.tvWhereToLook)

        fun render(seriesEntity: SeriesEntity){
            tvName.text = seriesEntity.name
            tvSeason.text = seriesEntity.season
            tvYear.text = seriesEntity.year
            tvWhereToLook.text = seriesEntity.whereToLook
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_series, parent, false)
        return SeriesViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.render(list[position])
    }
}