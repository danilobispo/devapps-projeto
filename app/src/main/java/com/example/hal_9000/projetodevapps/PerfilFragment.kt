package com.example.hal_9000.projetodevapps

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hal_9000.projetodevapps.Model.Pessoa
import com.example.hal_9000.projetodevapps.services.ConsultaService


/**
 * A simple [Fragment] subclass.
 */
class PerfilFragment : Fragment() {

    var service = ConsultaService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_perfil, container, false)
        val args = arguments
        val pessoa:Pessoa = service.getProfile()

        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_full_name)!!.text = pessoa.nome
        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_label_name)!!.text = pessoa.nome
        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_idade)!!.text = pessoa.idade
        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_email)!!.text = pessoa.email
        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_local)!!.text = pessoa.cidade
        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_endereco)!!.text = pessoa.endereco
        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_username)!!.text = pessoa.username
        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_history)!!.text = pessoa.history
        rootView.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.profile_telefone)!!.text = pessoa.nome

        return rootView
    }

}
