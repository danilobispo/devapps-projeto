package com.example.hal_9000.projetodevapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_cadastro.view.*



class CadastroFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.activity_cadastro, container, false)

        rootView.button_int_fazer_cadastro.setOnClickListener {
            callCadastro()
        }

        rootView.button_int_fazer_login.setOnClickListener({
            callLogin()
        })
        return rootView
    }

    fun callCadastro() {
        activity.supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, LoginCadastro()).addToBackStack(null).commit()
    }

    fun callLogin() {
        activity.supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, LoginActivity()).addToBackStack(null).commit()
    }

}