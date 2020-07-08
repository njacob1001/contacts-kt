package com.jacoblabs.project.cotactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    var lista: ListView?=null
    var adaptador: AdaptadorCustom?=null
    companion object {
        var contactos:ArrayList<Contacto>? = null

        fun agregarContacto(newElement:Contacto){
            contactos?.add(newElement)
        }

        fun obtenerContacto(index:Int):Contacto{
            return contactos?.get(index)!!
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        contactos = ArrayList()
        contactos?.add(Contacto("Jacob", "Gonzalez", "Algoritmo", 24, 73.2F,"nooo", "001020121", "test@test.test",R.drawable.foto_01))

        lista = findViewById<ListView>(R.id.lista)
        adaptador = AdaptadorCustom(this, contactos!!)

        lista?.adapter=adaptador

        lista?.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, Detalle::class.java)
            intent.putExtra("ID", position.toString())
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId) {
            R.id.iNuevo -> {
                val intent = Intent(this, Nuevo::class.java)
                startActivity(intent)
                true
            }

            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onResume(){
        super.onResume()
        adaptador?.notifyDataSetChanged()

    }
}