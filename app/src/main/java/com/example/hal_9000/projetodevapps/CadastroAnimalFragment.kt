package com.example.hal_9000.projetodevapps

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.fragment_cadastrar_animal.view.*

/**
 * Created by Danilo José Bispo Galvão on 11/05/2018.
 */
class CadastroAnimalFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewRoot = inflater!!.inflate(R.layout.fragment_cadastrar_animal, container, false)
        val btn = arrayOfNulls<ToggleButton>(3)
        val btn_id = intArrayOf(R.id.btAdocao, R.id.btApadrinhar, R.id.btAjudar)
        var contadorChecked: Int = 0
        for (i in 0..2) {
            btn[i] = viewRoot.findViewById(btn_id[i])
        }
        Toast.makeText(context, "Por favor, selecione uma das 3 opções para continuar", Toast.LENGTH_LONG).show()

        viewRoot.btAdocao.setOnCheckedChangeListener(trocarCorEFragment(viewRoot, SubFragmentAdocaoAnimal(), getString(R.string.str_colocar_para_adocao), btn))
        viewRoot.btApadrinhar.setOnCheckedChangeListener(trocarCorEFragment(viewRoot, SubFragmentApadrinhamentoAnimal(), getString(R.string.str_procurar_padrinho), btn))
        viewRoot.btAjudar.setOnCheckedChangeListener(trocarCorEFragment(viewRoot, SubFragmentAjudarAnimal(), getString(R.string.str_procurar_ajuda), btn))


        // Parte que gerencia os fragments e quais estão selecionados

        return viewRoot
    }

    private fun trocarCorEFragment(viewRoot: View, fragmentRef: Fragment, textoBotao: String, botaoArray: Array<ToggleButton?>): (CompoundButton, Boolean) -> Unit {
        return { it, isChecked ->
            if (isChecked) {
                if (!fragmentRef.isInLayout && childFragmentManager.fragments.size == 0) {
                    Log.d("DEBUG cadastro", "Fragmento " + fragmentRef.id + " não existe na Activity")
                    childFragmentManager.beginTransaction().replace(R.id.frameAlternativo, fragmentRef)
                        .commit()
                    Log.d("DEBUG cadastro", "childFragmentManager list size: " + childFragmentManager.fragments.size)
                    it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
                    viewRoot.btCadastrar.text = textoBotao
                } else if (childFragmentManager.fragments.size == 1) { // Lógica de dois fragments
                    Log.d("DEBUG cadastro", "Fragmento do frame 1 já existe na Activity")
                    Log.d("DEBUG cadastro", "Fragmento " + fragmentRef.id + " será adicionado ao segundo frame")
                    childFragmentManager.beginTransaction().replace(R.id.segundoFrameAlternativo, fragmentRef).commit()
                    it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)

                    viewRoot.btCadastrar.text = textoBotao
                } else {
                    Toast.makeText(context, "Apenas duas opções podem ser selecionadas por vez", Toast.LENGTH_LONG).show()
                    it.toggle() // Reverte para unchecked, para evitar bugs
                }
            } else {
                it.background.clearColorFilter()
                if (fragmentRef.isVisible) {
                    Log.d("DEBUG cadastro", "Fragmento " + fragmentRef.id + " é visível")
                    Log.d("DEBUG cadastro", "Fragmento " + fragmentRef.id + " removido")
                    childFragmentManager.beginTransaction().remove(fragmentRef).commit()
                    Log.d("DEBUG cadastro", "childFragmentManager list size: " + childFragmentManager.fragments.size)
                }
            }
        }
    }

    private fun realizarCadastro() {

    }
}