package com.example.s5briceo_clinicarobles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            Toast.makeText(context, "Sesion Iniciada", Toast.LENGTH_SHORT).show()
            /* Aqui se hace que se cambie a la vista de doctores */
            (activity as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DoctorsListFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
