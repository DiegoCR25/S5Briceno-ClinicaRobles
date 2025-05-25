package com.example.s5briceo_clinicarobles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DoctorsListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DoctorAdapter

    /*Lista de Doctores */
    private val doctorsList = listOf(
        Doctor("Dr. Alberto Garcia Cerna", "Traumatología", "987 654 321", R.drawable.doctor1, true),
        Doctor("Dr. Roberto Chavesta Bernal", "Cardiología", "987 654 322", R.drawable.doctor2, true),
        Doctor("Dr. Romel Zamudio Silva", "Cirugía Cardiovascular", "987 654 323", R.drawable.doctor3, true),
        Doctor("Dr. Beto Miranda Sevillano", "Cirugía General", "987 654 324", R.drawable.doctor4, true),
        Doctor("Dr. Jaime Vega Chavez", "Dermatología", "987 654 325", R.drawable.doctor5, true),
        Doctor("Dr. Juan Pinto Sanchez", "Endocrinología", "987 654 326", R.drawable.doctor1, true),
        Doctor("Dra. Kelly Casanova Lau", "Gastroenterología", "987 654 327", R.drawable.doctora1, true),
        Doctor("Dr. Jose Luis Espinoza Decena", "Ginecología", "987 654 328", R.drawable.doctor2, true),
        Doctor("Dr. Luis Vasquez", "Medicina Física", "987 654 329", R.drawable.doctor3, true),
        Doctor("Dr. Elwis Laveriano Hoyos", "Medicina General", "987 654 330", R.drawable.doctor4, true),
        Doctor("Dr. Luis Cabrera Ciprian", "Medicina Interna", "987 654 331", R.drawable.doctor5, true),
        Doctor("Dra. Yessica Montoya Caldas", "Neumología", "987 654 332", R.drawable.doctora2, true),
        Doctor("Dr. Willy Caballero Grados", "Neurocirugía", "987 654 333", R.drawable.doctor1, true),
        Doctor("Dr. Rosnel Valdivieso Velarde", "Neurología", "987 654 334", R.drawable.doctor2, true),
        Doctor("Lic. Carmela Carbajal", "Nutrición", "987 654 335", R.drawable.doctora3, true),
        Doctor("Dr. Pedro Cipriano Alegre", "Odontología", "987 654 336", R.drawable.doctor3, true),
        Doctor("Dr. Julio Robles Zanelli", "Cirugía Maxilofacial", "987 654 337", R.drawable.doctor4, true),
        Doctor("Dr. Jorge Bonilla Vargas", "Otorrino", "987 654 338", R.drawable.doctor5, true),
        Doctor("Dra. Anita Vigo Arroyo", "Oftalmología", "987 654 339", R.drawable.doctora4, true),
        Doctor("Dr. Marcos Vasquez Tantas", "Pediatría", "987 654 340", R.drawable.doctor1, true),
        Doctor("Lic. Astrid Manrique Marron", "Psicología", "987 654 341", R.drawable.doctora5, true),
        Doctor("Dra. Celmira Lazaro Loyola", "Psiquiatría", "987 654 342", R.drawable.doctora1, true),
        Doctor("Dr. Frank Ocaña Vasquez", "Reumatología", "987 654 343", R.drawable.doctor2, true),
        Doctor("Dr. Carlos Morales Flores", "Urología", "987 654 344", R.drawable.doctor3, true)
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctors_list, container, false)

        val btnRegresar = view.findViewById<Button>(R.id.btnRegresarLogin)
        btnRegresar.setOnClickListener {
            /* Aqui se hace que el fragmento se reemplace por el de Login */
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, LoginFragment())
                ?.commit()
        }

        recyclerView = view.findViewById(R.id.recyclerViewDoctors)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = DoctorAdapter(doctorsList) { selectedDoctor ->
            /* Mensaje del doctor seleccionado */
            Toast.makeText(context, "Seleccionaste al Doctor: ${selectedDoctor.name}", Toast.LENGTH_SHORT).show()

            /* Hacer que lo redirija a la siguiente pantalla */
            val fragment = DoctorsDetailsFragment.newInstance(
                selectedDoctor.name,
                selectedDoctor.phone,
                selectedDoctor.iconResId
            )
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }
        recyclerView.adapter = adapter

        return view
    }
}
