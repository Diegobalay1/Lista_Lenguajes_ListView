package com.diego.kotlin.listalenguajeslistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * En primer lugar, realizaremos un ejemplo básico de listado a partir de un array.
 * Después personalizaremos diferentes elementos de la lista,
 * gestionaremos los eventos y
 * crearemos adaptadores propios.
 */

class ListaLenguajesActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private var swipe: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_lenguajes)

        val lista = findViewById<ListView>(R.id.lista)
        lista.emptyView = findViewById(R.id.emptyView)

        //...swipe
        swipe = findViewById(R.id.swiperefresh)
        swipe?.setOnRefreshListener(this)

        val valores = arrayOf(
                              "C", "Java", "C++", "Python", "Perl", "PHP", "Haskell",
                              "Eiffel", "Lisp", "Pascal", "Cobol", "Swift", "Kotlin"
        )
        /*val adaptador = ArrayAdapter(
            this,
                   android.R.layout.simple_list_item_1,
                   valores
        )*/
        val adaptador = ArrayAdapter(
            this,
            R.layout.item_lenguaje,
            R.id.nombre,
            valores
        )
        lista.adapter = adaptador

        // cada vez que se pulse sobre un elemento de la lista
        // se mostrará un Toast que indica el item seleccionado.
        lista.setOnItemClickListener { parent: AdapterView<*>, view: View,
                                       position: Int, id: Long ->
            val elemento = adaptador.getItem(position) as String
            Toast.makeText(
                this@ListaLenguajesActivity,
                "$elemento seleccionado", Toast.LENGTH_LONG
            ).show()
        }

        // cada vez que se haga una pulsación prolongada sobre un
        // elemento de la lista se mostrará un Toast que indica el item seleccionado.
        lista.setOnItemLongClickListener { parent, view, position, id ->
            Toast.makeText(parent.context, "Posición $position pulsada", Toast.LENGTH_LONG).show()
            // Devolvemos el valor true para evitar que se dispare
            // también el evento onItemClick
            true
        }


    }

    override fun onRefresh() {
        // Realizar la acción para actualizar datos
        // ...
        // Hacemos desaparecer el indicador de progreso
        //swipe?.setRefreshing(false)
        swipe?.isRefreshing = false
    }
}














