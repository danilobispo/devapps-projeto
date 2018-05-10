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

    //TODO: Trccar isso depois
    fun popularListaDeEventos(): ArrayList<Evento>{
        val eventosList = ArrayList<Evento>()
        eventosList.add(Evento(
            "Evento 1",
            "16/09/2112",
            "11h às 16h",
            "ICC Sul",
            "AAA"))
        eventosList.add(Evento(
            "Evento 2",
            "14/10/2112",
            "12h às 15h",
            "ICC Norte",
            "BBBB"))
        eventosList.add(Evento(
            "Evento 3",
            "24/09/2112",
            "14h às 18h",
            "ICC Centro",
            "CCCC"))
        return eventosList
    }
}