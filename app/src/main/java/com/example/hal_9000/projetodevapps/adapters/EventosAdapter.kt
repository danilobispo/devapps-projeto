package com.example.hal_9000.projetodevapps.adapters

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hal_9000.projetodevapps.Model.Evento
import com.example.hal_9000.projetodevapps.R
import kotlinx.android.synthetic.main.fragment_card_eventos.view.*

/**
 * Created by Danilo José Bispo Galvão on 10/05/2018.
 */

public class EventosAdapter(private val eventosList: ArrayList<Evento>?): RecyclerView.Adapter<EventosAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        eventosList?.let {eventos ->
            holder.tituloEvento.text = eventos[position].titulo
            holder.dataEvento.text = eventos[position].data
            holder.horaEvento.text = eventos[position].hora
            holder.localEvento.text = eventos[position].local
            holder.informacoesEvento.text = eventos[position].informacoes
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.fragment_card_eventos, parent, false)

        // Return a new holder instance
        return ViewHolder(contactView)

    }

    override fun getItemCount(): Int {
        return eventosList?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tituloEvento = itemView.tituloEvento
            val dataEvento = itemView.dataEvento
            val horaEvento = itemView.horaEvento
            val localEvento = itemView.localEvento
            val informacoesEvento = itemView.informacoesEvento

    }
}