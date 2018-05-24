package com.example.hal_9000.projetodevapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.support.v4.app.Fragment
import android.widget.Toast
import kotlinx.android.synthetic.main.introducao_fragment.view.*


/**
 * Created by Danilo José Bispo Galvão on 04/05/2018.
 */

class IntroducaoFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.introducao_fragment, container, false)

        rootView.button_int_adotar.setOnClickListener {
            callAdotar()
        }
        rootView.button_int_ajudar.setOnClickListener({
            callAjudar()
        })
        rootView.button_int_cadastrar.setOnClickListener({
            callCadastrarAnimal()
        })
        return rootView
    }

    fun callAdotar() {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, AdotarFragment()).commit()
    }

    fun callAjudar() {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, AjudarFragment()).commit()
    }

    fun callCadastrarAnimal() {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, CadastroAnimalFragment()).commit()
    }
}