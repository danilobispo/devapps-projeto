package com.example.hal_9000.projetodevapps

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hal_9000.projetodevapps.Model.Animal
import com.example.hal_9000.projetodevapps.adapters.FavoritesAdapter
import com.example.hal_9000.projetodevapps.services.ConsultaService
import kotlinx.android.synthetic.main.fragment_favoritos.view.*


class FavoritosFragment : Fragment() {

    var service = ConsultaService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView: View = inflater!!.inflate(R.layout.fragment_favoritos, container, false)
        rootView.rvFavoritos.adapter = FavoritesAdapter(getAnimalsFromService())
        rootView.rvFavoritos.layoutManager = LinearLayoutManager(this.context)

        return rootView
    }

    private fun getAnimalsFromService(): List<Animal> {
        return this.service.favoritos
    }



}
