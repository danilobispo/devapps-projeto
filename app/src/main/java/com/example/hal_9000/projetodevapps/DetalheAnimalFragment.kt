package com.example.hal_9000.projetodevapps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hal_9000.projetodevapps.Model.Animal
import java.io.Serializable
import java.nio.file.Files.find

class DetalheAnimalFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.detalhe_animal, container, false)
        val args = arguments;
        val animal:Animal = args.getSerializable("animal") as Animal

        rootView?.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.detalhe_animal_nome)!!.text = animal.name
        rootView?.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.detalhe_animal_sexo)!!.text = animal.sexo
        rootView?.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.detalhe_animal_nome2)!!.text = animal.name
        rootView?.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.detalhe_animal_local)!!.text = animal.localizacao
        rootView?.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.detalhe_animal_porte)!!.text = animal.porte
        rootView?.findViewById<android.support.v7.widget.AppCompatTextView>(R.id.detalhe_animal_idade)!!.text = animal.idade.toString()

        return rootView
    }
}
