package com.example.hal_9000.projetodevapps


import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton

import kotlinx.android.synthetic.main.fragment_filtros.view.*


/**
 * A simple [Fragment] subclass.
 */
class FiltrosFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_filtros, container, false)

        // Botões da sessão Seu Interesse
        rootView.btFiltroAdotar.setOnCheckedChangeListener(mudaCorDoBotao())
        rootView.btFiltroAjudar.setOnCheckedChangeListener(mudaCorDoBotao())
        rootView.btFiltroApadrinhar.setOnCheckedChangeListener(mudaCorDoBotao())

        // Botões da sessão Animal
        rootView.btFiltroCachorro.setOnCheckedChangeListener(mudaCorDoBotao())
        rootView.btFiltroGato.setOnCheckedChangeListener(mudaCorDoBotao())

        // Botões da sessão Sexo
        rootView.btFiltroMacho.setOnCheckedChangeListener(mudaCorDoBotao())
        rootView.btFiltroFemea.setOnCheckedChangeListener(mudaCorDoBotao())

        // Botões da sessão Idade
        rootView.btFiltroFilhote.setOnCheckedChangeListener(mudaCorDoBotao())
        rootView.btFiltroMedio.setOnCheckedChangeListener(mudaCorDoBotao())
        rootView.btFiltroGrande.setOnCheckedChangeListener(mudaCorDoBotao())


        rootView.btSalvarAlteracoes.setOnClickListener({
            fragmentManager.beginTransaction().replace(R.id.content_frame, FalhaFiltrosFragment())
                .addToBackStack(null)
                .commit()
        })

        return rootView
    }

    private fun mudaCorDoBotao(): (CompoundButton, Boolean) -> Unit {
        return { buttonView, isChecked ->
            if(isChecked) {
                buttonView.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow), PorterDuff.Mode.SRC_ATOP)
            } else
                buttonView.background.colorFilter = null
        }
    }


} // Required empty public constructor
