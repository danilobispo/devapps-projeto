package com.example.hal_9000.projetodevapps

import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hal_9000.projetodevapps.Model.Evento
import com.example.hal_9000.projetodevapps.adapters.EventosAdapter
import com.example.hal_9000.projetodevapps.services.ConsultaService
import kotlinx.android.synthetic.main.fragment_eventos.view.*

/**
 * Created by Danilo José Bispo Galvão on 10/05/2018.
 */
class EventosFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater!!.inflate(R.layout.fragment_eventos, container, false)
        rootView.rvEventos.adapter = EventosAdapter(popularListaDeEventos())
        rootView.rvEventos.layoutManager = LinearLayoutManager(this.context)
        return rootView
    }

    fun popularListaDeEventos(): ArrayList<Evento>{
        val service: ConsultaService = ConsultaService()
        val eventosList = service.eventos
        return eventosList
    }
}