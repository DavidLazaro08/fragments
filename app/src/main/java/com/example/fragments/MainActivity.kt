package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ListaContactosFragment.OnContactoSeleccionadoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorLista, ListaContactosFragment())
                .replace(R.id.contenedorDetalle, DetalleContactoFragment.newInstance("Selecciona un contacto", "", "", ""))
                .commit()
        }
    }

    override fun onContactoSeleccionado(nombre: String, apellidos: String, telefono: String, direccion: String) {
        val fragmentDetalle = DetalleContactoFragment.newInstance(
            nombre,
            apellidos,
            telefono,
            direccion
        )

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedorDetalle, fragmentDetalle)
            .commit()
    }
}