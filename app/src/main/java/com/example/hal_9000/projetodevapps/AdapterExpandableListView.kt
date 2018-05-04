package com.example.hal_9000.projetodevapps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hal_9000.projetodevapps.Model.Categoria

/**
 * Created by HAL-9000 on 03/05/2018.
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

        // Instância dos objetos da view
        val iconeGrupo = view.findViewById<ImageView>(R.id.drawerMenuHeader_itemIcon)
        val textoGrupo = view.findViewById<TextView>(R.id.drawerMenuHeader_itemNameTxt)

        iconeGrupo.setImageDrawable(categoriaList[groupPosition].icone)
        textoGrupo.text = grupo.nome

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
        val subcategoriaText = categoriaList[groupPosition].subcategoriaArrayList[childPosition]
        val view: View = LayoutInflater.from(context).inflate(R.layout.drawer_item, parent, false)

        val subcatTextView: TextView = view.findViewById(R.id.drawerItemText)
        subcatTextView.text = subcategoriaText.nome
        return view
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return categoriaList.size
    }

}