package com.example.hal_9000.projetodevapps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hal_9000.projetodevapps.Model.Animal
import java.io.Serializable

class DetalheAnimalFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.detalhe_animal, container, false)
        val args = arguments;
        val animal:Animal = args.getSerializable("animal") as Animal

        //TODO popular as views com os valores contidos em animal.
        //ex: R.id.detalhe_animal_nome . text = animal.nome;
        return rootView
    }
}
