package com.example.s5briceo_clinicarobles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(
    private val doctors: List<Doctor>,
    private val onItemClick: (Doctor) -> Unit
) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    inner class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.textDoctorName)
        val especialidad: TextView = itemView.findViewById(R.id.textDoctorSpeciality)
        val disponibilidad: TextView = itemView.findViewById(R.id.textDoctorAvailability)
        val icono: ImageView = itemView.findViewById(R.id.imageDoctor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctors[position]
        holder.nombre.text = doctor.name
        holder.especialidad.text = doctor.especialidad
        holder.disponibilidad.text = if (doctor.disponibilidad) "Disponible" else "No Disponible"
        holder.icono.setImageResource(doctor.iconResId)
        holder.itemView.setOnClickListener {
            onItemClick(doctor)
        }
    }

    override fun getItemCount() = doctors.size
}
