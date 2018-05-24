package com.example.hal_9000.projetodevapps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_cadastrar_animal.*
import kotlinx.android.synthetic.main.fragment_cadastrar_animal.view.*

/**
 * Created by Danilo José Bispo Galvão on 11/05/2018.
 */
class CadastroAnimalFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewRoot = inflater!!.inflate(R.layout.fragment_cadastrar_animal, container, false)
        // Seta o fragment default para o frame layout
        fragmentManager.beginTransaction().add(R.id.frameAlternativo, SubFragmentAdocaoAnimal())
            .commit()
        viewRoot.btCadastrar.text = context.getString(R.string.str_colocar_para_adocao)
        viewRoot.btAjudar.isSelected = true;

        viewRoot.btAdocao.setOnClickListener({
            fragmentManager.beginTransaction().replace(R.id.frameAlternativo, SubFragmentAdocaoAnimal())
                .commit()
            viewRoot.btCadastrar.text = context.getString(R.string.str_colocar_para_adocao)
        })
        viewRoot.btApadrinhar.setOnClickListener({
            fragmentManager.beginTransaction().replace(R.id.frameAlternativo, SubFragmentApadrinhamentoAnimal())
                .commit()
            viewRoot.btCadastrar.text = context.getString(R.string.str_procurar_padrinho)
        })
        viewRoot.btAjudar.setOnClickListener({
            fragmentManager.beginTransaction().replace(R.id.frameAlternativo, SubFragmentAjudarAnimal())
                .commit()
            viewRoot.btCadastrar.text = context.getString(R.string.str_procurar_ajuda)
        })

        return viewRoot
    }


    private fun realizarCadastro() {

    }
}