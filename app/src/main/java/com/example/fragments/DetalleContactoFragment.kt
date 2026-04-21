package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetalleContactoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_detalle_contacto, container, false)

        val txtNombre = vista.findViewById<TextView>(R.id.txtNombre)
        val txtApellidos = vista.findViewById<TextView>(R.id.txtApellidos)
        val txtTelefono = vista.findViewById<TextView>(R.id.txtTelefono)
        val txtDireccion = vista.findViewById<TextView>(R.id.txtDireccion)

        val nombre = arguments?.getString("nombre") ?: ""
        val apellidos = arguments?.getString("apellidos") ?: ""
        val telefono = arguments?.getString("telefono") ?: ""
        val direccion = arguments?.getString("direccion") ?: ""

        txtNombre.text = "Nombre: $nombre"
        txtApellidos.text = "Apellidos: $apellidos"
        txtTelefono.text = "Teléfono: $telefono"
        txtDireccion.text = "Dirección: $direccion"

        return vista
    }

    companion object {
        fun newInstance(nombre: String, apellidos: String, telefono: String, direccion: String): DetalleContactoFragment {
            val fragment = DetalleContactoFragment()
            val args = Bundle()

            args.putString("nombre", nombre)
            args.putString("apellidos", apellidos)
            args.putString("telefono", telefono)
            args.putString("direccion", direccion)

            fragment.arguments = args
            return fragment
        }
    }
}