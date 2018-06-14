package com.example.hal_9000.projetodevapps

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.hal_9000.projetodevapps.Model.Categoria
import com.example.hal_9000.projetodevapps.Model.Subcategoria
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_header.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupMenu()
        setupFragment(savedInstanceState)
    }

    fun setupMenu() {
        //Inflate no header e footer do menu
        val drawerHeader = layoutInflater.inflate(R.layout.drawer_header, null, false)
        // TODO: Alterar o nome de usuário e senha aqui quando o serviço de login for implementado
        setupDrawerHeader(drawerHeader, null)
        val drawerFooter = layoutInflater.inflate(R.layout.drawer_button_footer, null, false)
        expandableListView.addHeaderView(drawerHeader)
        expandableListView.addFooterView(drawerFooter)

        val listaDeCategorias: ArrayList<Categoria> = montarListaDeMenus(this)
        expandableListView.setAdapter(AdapterExpandableListView(this, listaDeCategorias))

        // toolbar cast como View
        val drawerToggle: ActionBarDrawerToggle = object :
            ActionBarDrawerToggle(this, drawer, toolbar as Toolbar, R.string.open_drawer, R.string.close_drawer) {
            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }
        }

        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    fun setupFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            this.supportFragmentManager.beginTransaction().replace(R.id.content_frame, IntroducaoFragment())
                .addToBackStack(null).commit()
        }

    }

    fun setupDrawerHeader(drawerHeader: View, fotoDeUsuario: Drawable?){

        if (fotoDeUsuario != null){
            drawerHeader.profileImageView.setImageDrawable(fotoDeUsuario)
        }
    }

    private fun montarListaDeMenus(context: Context): ArrayList<Categoria> {
        val listCategorias = ArrayList<Categoria>()

        if(isUsuarioLogado()) {
            // Login
            val subcategoriaLogin = montarListaDeOpcoesDeUsuario()
            val categoriaLogin = Categoria(
                "Emile Catarine",
                null,
                subcategoriaLogin,
                R.color.drawer_primary_color)
                listCategorias.add(categoriaLogin)
        }

        // Atalhos
        val subcategoriaAtalhos = ArrayList<Subcategoria>()
        //TODO: Inserir referências para fragments
        subcategoriaAtalhos.add(Subcategoria("Cadastrar um pet", CadastroAnimalFragment()))
        subcategoriaAtalhos.add(Subcategoria("Adotar um pet", AdotarFragment()))
        subcategoriaAtalhos.add(Subcategoria("Ajudar um pet", AjudarFragment()))
        subcategoriaAtalhos.add(Subcategoria("Apadrinhar um pet", ApadrinharFragment()))
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
        subcategoriaInformacoes.add(Subcategoria("Eventos", EventosFragment()))
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
        subcategoriaConfiguracoes.add(Subcategoria("Privacidade", PrivacidadeFragment()))
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

    private fun montarListaDeOpcoesDeUsuario(): ArrayList<Subcategoria> {
        val listaDeSubcategoria = ArrayList<Subcategoria>()
        listaDeSubcategoria.add(Subcategoria("Meu perfil", PerfilFragment()))
        listaDeSubcategoria.add(Subcategoria("Meus pets", MeusPetsFragment()))
        listaDeSubcategoria.add(Subcategoria("Favoritos", FavoritosFragment()))
        listaDeSubcategoria.add(Subcategoria("Chat", null))

        return listaDeSubcategoria
    }

    fun isUsuarioLogado(): Boolean{
        // TODO: Verificar se usuário está logado
        return true
    }

}
