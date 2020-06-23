package com.jacoblabs.project.cotactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {


    var contactos:ArrayList<Contacto>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        contactos = ArrayList()
        contactos?.add(Contacto("Jacob", "Gonzalez", "Algoritmo", 24, 73.2F,"nooo", "001020121", "test@test.test",R.drawable.foto_01))

        val lista = findViewById<ListView>(R.id.lista)
        val adaptador = AdaptadorCustom(this, contactos!!)

        lista.adapter=adaptador


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}