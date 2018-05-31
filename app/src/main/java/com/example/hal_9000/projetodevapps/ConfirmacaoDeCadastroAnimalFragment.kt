package com.example.hal_9000.projetodevapps

import android.content.Context
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_confirmacao_de_cadastro_animal.view.*

class ConfirmacaoDeCadastroAnimalFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_confirmacao_de_cadastro_animal, container, false)
        rootView.btMeusPets.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
        return rootView
    }
}
