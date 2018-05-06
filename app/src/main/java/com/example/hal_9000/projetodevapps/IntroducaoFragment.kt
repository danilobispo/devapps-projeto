package com.example.hal_9000.projetodevapps

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

/**
 * Created by Danilo José Bispo Galvão on 04/05/2018.
 */

class IntroducaoFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.introducao_fragment, container, false)

        return rootView
    }
}