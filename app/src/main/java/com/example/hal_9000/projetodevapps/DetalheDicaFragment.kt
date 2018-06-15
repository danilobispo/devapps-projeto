package com.example.hal_9000.projetodevapps


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.text.Html
import android.widget.TextView



class DetalheDicaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_detalhe_dica, container, false)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            rootView?.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.dica_detalhe_texto)!!.text = Html.fromHtml(getString(R.string.texto_dica_unhas), Html.FROM_HTML_MODE_LEGACY)
        } else {
            rootView?.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.dica_detalhe_texto)!!.text = Html.fromHtml(getString(R.string.texto_dica_unhas))
        }

        return rootView
    }


}
