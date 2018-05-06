package com.example.hal_9000.projetodevapps

import android.app.Activity
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.hal_9000.projetodevapps.Model.Categoria

/**
 * Created by Danilo José Bispo Galvão on 03/05/2018.
 */

class AdapterExpandableListView(
    val context: Context,
    val categoriaList: ArrayList<Categoria>) : BaseExpandableListAdapter() {


    override fun getGroup(groupPosition: Int): Any {
        return categoriaList[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val grupo = categoriaList[groupPosition]
        val view: View = LayoutInflater.from(context).inflate(R.layout.drawer_menu_header, parent, false)
        val iconeGrupo = view.findViewById<ImageView>(R.id.drawerMenuHeader_itemIcon)
        val textoGrupo = view.findViewById<TextView>(R.id.drawerMenuHeader_itemNameTxt)
        val corBackgroundGrupo = view.findViewById<ConstraintLayout>(R.id.drawerMenuHeader)
        val dropdownBotaoGrupo = view.findViewById<ImageView>(R.id.drawerMenuHeader_dropdown)

        // Instância dos objetos da view
        corBackgroundGrupo.setBackgroundColor(ContextCompat.getColor(context, grupo.backgroundColor!!))
        iconeGrupo.setImageDrawable(grupo?.icone)
        textoGrupo.text = grupo.nome
        if (groupPosition == 0) {
            var params = dropdownBotaoGrupo.layoutParams as ConstraintLayout.LayoutParams
            params.leftMargin = 150

        } else {
            iconeGrupo.visibility = View.VISIBLE
        }


        if (isExpanded) {
            dropdownBotaoGrupo.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_arrow_drop_up_black_24dp))
        } else {
            dropdownBotaoGrupo.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_arrow_drop_down_black_24dp))
        }
        return view
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return categoriaList[groupPosition].subcategoriaArrayList.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return categoriaList[groupPosition].subcategoriaArrayList[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val subcategoria = categoriaList[groupPosition].subcategoriaArrayList[childPosition]
        val view: View = LayoutInflater.from(context).inflate(R.layout.drawer_item, parent, false)

        val subcatTextView: TextView = view.findViewById(R.id.drawerItemText)
        subcatTextView.text = subcategoria.nome
        view.setOnClickListener({
            Toast.makeText(context, subcategoria.nome, Toast.LENGTH_LONG).show()
            if (subcategoria.fragmentReference != null) {
                val activityContext = context as Activity
                val fragManager = activityContext.fragmentManager.beginTransaction()
                fragManager.replace(R.id.content_frame, subcategoria.fragmentReference)
                fragManager.addToBackStack(null).commit()
            }
        })


        return view
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return categoriaList.size
    }

}