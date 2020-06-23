package com.jacoblabs.project.cotactos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorCustom(var contexto: Context, items: ArrayList<Contacto>):BaseAdapter() {
    var items:ArrayList<Contacto>? = null

    init {
        this.items = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder:ViewHolder?=null
        var vista:View?=convertView

        if(vista==null){
            vista = LayoutInflater.from(contexto).inflate(R.layout.template_contacto,null)
            viewHolder = ViewHolder(vista)
            vista.tag = viewHolder
        }else {
            viewHolder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Contacto

        viewHolder?.nombre?.text = item.nombre + " " + item.apellidos
        viewHolder?.empresa?.text = item.empresa
        viewHolder?.foto?.setImageResource(item.foto)

        return vista!!

    }

    override fun getItem(position: Int): Any {
        return this.items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return this.items?.count()!!
    }


    private class ViewHolder(vista:View){
        var nombre:TextView?=null
        var foto:ImageView?=null
        var empresa:TextView?=null

        init {
            this.nombre = vista.findViewById(R.id.tvNombre)
            this.empresa = vista.findViewById(R.id.tvEmpresa)
            this.foto = vista.findViewById(R.id.ivFoto)
        }
    }

}