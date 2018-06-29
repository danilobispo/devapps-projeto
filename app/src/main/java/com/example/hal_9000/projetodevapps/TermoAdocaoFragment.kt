package com.example.hal_9000.projetodevapps

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_termo_enviado.view.*
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_termo_adocao.view.*

class TermoAdocaoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_termo_adocao, container, false)

        rootView.button_termo_adocao.setOnClickListener{
            callTermoEnviado1() }

        rootView.button_termo_apadrinhamento.setOnClickListener{
            callTermoEnviado2() }

        return rootView
    }

    fun callTermoEnviado1(){
        activity.supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, TermoEnviadoFragment()).addToBackStack(null).commit()
    }

    fun callTermoEnviado2(){
        activity.supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, TermoEnviadoFragment()).addToBackStack(null).commit()
    }

}
