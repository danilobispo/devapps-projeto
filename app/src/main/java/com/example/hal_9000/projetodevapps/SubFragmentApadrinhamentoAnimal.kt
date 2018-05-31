package com.example.hal_9000.projetodevapps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.sub_fragment_apadrinhamento_animal.view.*

/**
 * Created by Danilo José Bispo Galvão on 24/05/2018.
 */
class SubFragmentApadrinhamentoAnimal: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.sub_fragment_apadrinhamento_animal, container, false)
        rootView.auxilioFinanceiroApadrinhamentoOption.setOnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                rootView.alimentacaoOption.isEnabled = true
                rootView.saudeOption.isEnabled = true
                rootView.ObjetosApadrinhamentoOption.isEnabled = true
            } else{
                rootView.alimentacaoOption.isEnabled = true
                rootView.saudeOption.isEnabled = true
                rootView.ObjetosApadrinhamentoOption.isEnabled = true
            }
        }
        return rootView
    }
}