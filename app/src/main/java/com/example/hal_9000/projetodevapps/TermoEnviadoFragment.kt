package com.example.hal_9000.projetodevapps

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_termo_enviado.view.*
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_termo_adocao.view.*

class TermoEnviadoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_termo_enviado, container, false)

        rootView.button_legis.setOnClickListener{
            callLegislacao() }

        return rootView
    }

    fun callLegislacao(){
        activity.supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, LegislacaoFragment()).commit()
    }



}
