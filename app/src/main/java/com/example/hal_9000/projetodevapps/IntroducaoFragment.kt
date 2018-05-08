package com.example.hal_9000.projetodevapps

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.introducao_fragment.*
import android.R.attr.fragment



/**
 * Created by Danilo José Bispo Galvão on 04/05/2018.
 */

class IntroducaoFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.introducao_fragment, container, false)

        val adotarBtn: Button? = view?.findViewById(R.id.button_int_adotar);
        adotarBtn?.setOnClickListener {
            callAdotar()
        }
        return rootView
    }

    fun callAdotar() {
//TODO chamar novo adotar aqui
    }
}