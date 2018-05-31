package com.example.hal_9000.projetodevapps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.example.hal_9000.projetodevapps.Model.FragmentEnums
import kotlinx.android.synthetic.main.sub_fragment_adocao_animal.view.*

/**
 * Created by Danilo José Bispo Galvão on 24/05/2018.
 */
class SubFragmentAdocaoAnimal: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.sub_fragment_adocao_animal, container, false)
        rootView.tag = FragmentEnums.ADOTAR
        rootView.acompanhamentoPosAdocaoOption.setOnCheckedChangeListener{ buttonView, isChecked ->
            if(buttonView.isChecked){
                rootView.umMesOption.isEnabled = true
                rootView.tresMesesOption.isEnabled = true
                rootView.seisMesesOption.isEnabled = true
            } else {
                rootView.umMesOption.isEnabled = false
                rootView.tresMesesOption.isEnabled = false
                rootView.seisMesesOption.isEnabled = false
            }
        }

        return rootView
    }
}