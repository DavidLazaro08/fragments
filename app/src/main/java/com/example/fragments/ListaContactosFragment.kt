package com.example.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListaContactosFragment : Fragment() {

    private var listener: OnContactoSeleccionadoListener? = null

    private val nombres = arrayOf(
        "David Lázaro",
        "Patricia Fernández",
        "José Gutiérrez",
        "Mari Paz Ortiz",
        "Eva Gutiérrez"
    )

    private val apellidos = arrayOf(
        "Lázaro Gutiérrez",
        "Fernández Vilches",
        "Gutiérrez García",
        "Ortiz Palenque",
        "Gutiérrez Ortiz"
    )

    private val telefonos = arrayOf(
        "616540865",
        "654252880",
        "619974831",
        "633456456",
        "644567567"
    )

    private val direcciones = arrayOf(
        "Calle Zapillo 7, Sevilla",
        "Calle Séneca",
        "Plaza Verde 3, Málaga",
        "Calle Río 15, Granada",
        "Avenida Centro 27, Córdoba"
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnContactoSeleccionadoListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_lista_contactos, container, false)

        val listaContactos = vista.findViewById<ListView>(R.id.listaContactos)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            nombres
        )

        listaContactos.adapter = adapter

        listaContactos.setOnItemClickListener { _, _, position, _ ->
            listener?.onContactoSeleccionado(
                nombres[position],
                apellidos[position],
                telefonos[position],
                direcciones[position]
            )
        }

        return vista
    }

    interface OnContactoSeleccionadoListener {
        fun onContactoSeleccionado(nombre: String, apellidos: String, telefono: String, direccion: String)
    }
}