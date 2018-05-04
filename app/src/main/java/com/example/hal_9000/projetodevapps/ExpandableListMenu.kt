package com.example.hal_9000.projetodevapps

import android.content.Context
import android.support.v4.content.ContextCompat
import android.widget.ExpandableListView
import com.example.hal_9000.projetodevapps.Model.Categoria
import com.example.hal_9000.projetodevapps.Model.Subcategoria
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View

/**
* Created by Danilo José Bispo Galvão on 03/05/2018.
*/

@Layout(R.layout.expanding_list_view)
class ExpandableListMenu(context: Context) {

    @View(R.id.elv_menu_header)
    private val expandableListView: ExpandableListView? = null

    val listaDeCategorias = montarListaDeMenus(context)
    private val expandableListAdapter = AdapterExpandableListView(context, listaDeCategorias)

    @Resolve
    fun onResolved() {
        expandableListView?.setAdapter(expandableListAdapter)
    }

    private fun montarListaDeMenus(context: Context): ArrayList<Categoria> {
        val listCategorias = ArrayList<Categoria>()

        // Atalhos
        val subcategoriaAtalhos = ArrayList<Subcategoria>()
        subcategoriaAtalhos.add(Subcategoria("Cadastrar um pet"))
        subcategoriaAtalhos.add(Subcategoria("Adotar um pet"))
        subcategoriaAtalhos.add(Subcategoria("Ajudar um pet"))
        subcategoriaAtalhos.add(Subcategoria("Apadrinhar um pet"))
        val categoriaAtalhos = Categoria(
            "Atalhos",
            ContextCompat.getDrawable(context, R.drawable.ic_book_black_18dp),
            subcategoriaAtalhos
        )

        // Informações
        val subcategoriaInformacoes = ArrayList<Subcategoria>()
        subcategoriaInformacoes.add(Subcategoria("Dicas"))
        subcategoriaInformacoes.add(Subcategoria("Eventos"))
        subcategoriaInformacoes.add(Subcategoria("Legislação"))
        subcategoriaInformacoes.add(Subcategoria("Termo de adoção"))
        subcategoriaInformacoes.add(Subcategoria("Histórias de adoção"))
        val categoriaInformacoes = Categoria(
            "Informações",
                ContextCompat.getDrawable(context, R.drawable.ic_email_black_18dp),
                subcategoriaInformacoes
        )

        // Configurações
        val subcategoriaConfiguracoes = ArrayList<Subcategoria>()
        subcategoriaConfiguracoes.add(Subcategoria("Privacidade"))
        val categoriaConfiguracoes = Categoria(
            "Configurações",
                ContextCompat.getDrawable(context,R.drawable.ic_settings_black_18dp),
                subcategoriaConfiguracoes
        )

        listCategorias.add(categoriaAtalhos)
        listCategorias.add(categoriaInformacoes)
        listCategorias.add(categoriaConfiguracoes)

        return listCategorias
    }
}