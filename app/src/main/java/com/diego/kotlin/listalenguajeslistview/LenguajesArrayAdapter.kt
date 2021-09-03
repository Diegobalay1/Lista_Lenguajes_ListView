package com.diego.kotlin.listalenguajeslistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class LenguajesArrayAdapter(context: Context?, resource: Int, objects: List<Lenguaje>?)
    : ArrayAdapter<Lenguaje>(context!!, resource, objects!!) {
        // ...

    /**
     * Devolverá la vista con la interfaz del item de la lista.
     * Cuando hagamos scroll en la lista, se llamará automáticamente a este método
     * para solicitar las vistas de los items que entran, y
     * se reutilizarán los que salen de pantalla.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View = convertView?://si nos llega una vista existente, la utilizamos, de lo contrario creamos una nueva con LayoutInflater
            LayoutInflater.from(this.context)
                .inflate(R.layout.item_lenguaje, parent, false)
        val tvNombre = view.findViewById<TextView>(R.id.nombre)
        val tvDescripcion = view.findViewById<TextView>(R.id.descripcion)
        val ivIcono = view.findViewById<ImageView>(R.id.icono)
        // dado que getItem puede devolver null, para garantizar que solo
        // utilizamos el item si nos ha devuelto un valor válido,
        // se llamará al método let solamente si tieve valor, con ?.
        getItem(position)?.let {
            tvNombre.text = it.nombre
            tvDescripcion.text = it.descripcion
            ivIcono.setImageResource(it.icono)
        }

        return view
    }//end getView()


}