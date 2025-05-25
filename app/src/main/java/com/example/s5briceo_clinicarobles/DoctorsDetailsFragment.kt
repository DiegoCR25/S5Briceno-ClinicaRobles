package com.example.s5briceo_clinicarobles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class DoctorsDetailsFragment : Fragment() {

    companion object {
        private const val ARG_DOCTOR_NOMBRE = "doctor_nombre"
        private const val ARG_DOCTOR_TELEFONO = "doctor_telefono"
        private const val ARG_DOCTOR_ICONO = "doctor_icono"

        fun newInstance(nombre: String, telefono: String, iconoResId: Int): DoctorsDetailsFragment {
            val fragment = DoctorsDetailsFragment()
            val args = Bundle()
            args.putString(ARG_DOCTOR_NOMBRE, nombre)
            args.putString(ARG_DOCTOR_TELEFONO, telefono)
            args.putInt(ARG_DOCTOR_ICONO, iconoResId)
            fragment.arguments = args
            return fragment
        }
    }

    private var doctorNombre: String? = null
    private var doctorTelefono: String? = null
    private var doctorIconoResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            doctorNombre = it.getString(ARG_DOCTOR_NOMBRE)
            doctorTelefono = it.getString(ARG_DOCTOR_TELEFONO)
            doctorIconoResId = it.getInt(ARG_DOCTOR_ICONO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctors_details, container, false)

        val imageDoctor = view.findViewById<ImageView>(R.id.imageDoctorLarge)
        val textNombre = view.findViewById<TextView>(R.id.textDoctorName)
        val textTelefono = view.findViewById<TextView>(R.id.textDoctorPhone)
        val btnConfirmar = view.findViewById<Button>(R.id.btnConfirmar)
        val btnRegresar = view.findViewById<Button>(R.id.btnRegresar)

        doctorIconoResId?.let { imageDoctor.setImageResource(it) }
        textNombre.text = doctorNombre
        textTelefono.text = doctorTelefono

        btnConfirmar.setOnClickListener {
            Toast.makeText(context, "Cita Confirmada", Toast.LENGTH_SHORT).show()
        }

        btnRegresar.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return view
    }
}
