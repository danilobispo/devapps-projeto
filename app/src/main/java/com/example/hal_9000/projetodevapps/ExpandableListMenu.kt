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
        //TODO: Inserir referências para fragments
        subcategoriaAtalhos.add(Subcategoria("Cadastrar um pet", null))
        subcategoriaAtalhos.add(Subcategoria("Adotar um pet", null))
        subcategoriaAtalhos.add(Subcategoria("Ajudar um pet", null))
        subcategoriaAtalhos.add(Subcategoria("Apadrinhar um pet", null))
        val categoriaAtalhos = Categoria(
            "Atalhos",
            ContextCompat.getDrawable(context, R.drawable.ic_book_black_18dp),
            subcategoriaAtalhos,
                R.color.submenu_atalho_background
        )

        // Informações
        val subcategoriaInformacoes = ArrayList<Subcategoria>()
        //TODO: Inserir referências para fragments
        subcategoriaInformacoes.add(Subcategoria("Dicas", null))
        subcategoriaInformacoes.add(Subcategoria("Eventos", null))
        subcategoriaInformacoes.add(Subcategoria("Legislação", LegislacaoFragment()))
        subcategoriaInformacoes.add(Subcategoria("Termo de adoção", null))
        subcategoriaInformacoes.add(Subcategoria("Histórias de adoção", null))
        val categoriaInformacoes = Categoria(
            "Informações",
                ContextCompat.getDrawable(context, R.drawable.ic_info_black_18dp),
                subcategoriaInformacoes,
                R.color.submenu_informacoes_background
        )

        // Configurações
        val subcategoriaConfiguracoes = ArrayList<Subcategoria>()
        //TODO: Inserir referências para fragments
        subcategoriaConfiguracoes.add(Subcategoria("Privacidade", null))
        val categoriaConfiguracoes = Categoria(
            "Configurações",
                ContextCompat.getDrawable(context,R.drawable.ic_settings_black_18dp),
                subcategoriaConfiguracoes,
                R.color.submenu_configuracoes_background
        )

        listCategorias.add(categoriaAtalhos)
        listCategorias.add(categoriaInformacoes)
        listCategorias.add(categoriaConfiguracoes)

        return listCategorias
    }
}