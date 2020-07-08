package com.jacoblabs.project.cotactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class Detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val index = intent.getStringExtra("ID").toInt()

        val contacto = MainActivity.obtenerContacto(index)

        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvApellidos = findViewById<TextView>(R.id.tvApellidos)
        val tvEmpresa = findViewById<TextView>(R.id.tvEmpresa)
        val tvPeso = findViewById<TextView>(R.id.tvPeso)
        val tvEdad = findViewById<TextView>(R.id.tvEdad)
        val tvTelefono = findViewById<TextView>(R.id.tvTelefono)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvDireccion = findViewById<TextView>(R.id.tvDireccion)

        tvNombre.text=contacto.nombre + " " + contacto.apellidos
        tvEmpresa.text=contacto.empresa
        tvPeso.text=contacto.peso.toString()+ " Kg"
        tvEdad.text=contacto.edad.toString() + " Años"
        tvTelefono.text=contacto.telefono
        tvEmail.text=contacto.email
        tvDireccion.text=contacto.direccion


    }
}