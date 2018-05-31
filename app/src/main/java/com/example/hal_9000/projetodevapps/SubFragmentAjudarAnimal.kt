package com.example.hal_9000.projetodevapps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hal_9000.projetodevapps.Model.FragmentEnums

/**
 * Created by Danilo José Bispo Galvão on 24/05/2018.
 */
class SubFragmentAjudarAnimal: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.sub_fragment_ajudar_animal, container, false)
        rootView.tag = FragmentEnums.AJUDAR
        return rootView
    }
}