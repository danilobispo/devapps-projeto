package com.example.hal_9000.projetodevapps

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.legislacao_fragment.*

/**
 * Created by Danilo José Bispo Galvão on 03/05/2018.
 */
class LegislacaoFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.activity_legislacao, container, false)
        return rootView
    }
}