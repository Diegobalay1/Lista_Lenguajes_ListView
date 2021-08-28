package com.diego.kotlin.listalenguajeslistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

/**
 * En primer lugar, realizaremos un ejemplo básico de listado a partir de un array.
 * Después personalizaremos diferentes elementos de la lista,
 * gestionaremos los eventos y
 * crearemos adaptadores propios.
 */

class ListaLenguajesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_lenguajes)

        val lista = findViewById<ListView>(R.id.lista)
    }
}