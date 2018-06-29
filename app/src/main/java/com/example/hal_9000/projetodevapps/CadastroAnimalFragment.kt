package com.example.hal_9000.projetodevapps

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.constraint.Constraints.TAG
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Toast
import com.example.hal_9000.projetodevapps.Model.Animal
import com.example.hal_9000.projetodevapps.Model.Pessoa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_cadastrar_animal.*
import kotlinx.android.synthetic.main.fragment_cadastrar_animal.view.*


/**
 * Created by Danilo José Bispo Galvão on 11/05/2018.
 */
class CadastroAnimalFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewRoot = inflater!!.inflate(R.layout.fragment_cadastrar_animal, container, false)
        Toast.makeText(context,
            "Por favor, selecione pelo menos uma das 3 opções para continuar",
            Toast.LENGTH_LONG).show()

        viewRoot.btCadastrar.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
        viewRoot.btCadastrar.setOnClickListener({
            //TODO: Implementar
            realizarCadastro()
            // Abre o novo fragment se for bem sucedido
            activity.supportFragmentManager.beginTransaction().replace(R.id.content_frame, ConfirmacaoDeCadastroAnimalFragment()).addToBackStack(null).commit()
        })

        viewRoot.btAdocao.setOnCheckedChangeListener(trocarCorEFragment(viewRoot, SubFragmentAdocaoAnimal(), getString(R.string.str_colocar_para_adocao)))
        viewRoot.btApadrinhar.setOnCheckedChangeListener(trocarCorEFragment(viewRoot, SubFragmentApadrinhamentoAnimal(), getString(R.string.str_procurar_padrinho)))
        viewRoot.btAjudar.setOnCheckedChangeListener(trocarCorEFragment(viewRoot, SubFragmentAjudarAnimal(), getString(R.string.str_procurar_ajuda)))

        return viewRoot
    }

    private fun trocarCorEFragment(viewRoot: View, fragmentRef: Fragment, textoBotao: String): (CompoundButton, Boolean) -> Unit {
        return { it, isChecked ->
            if (isChecked) {
                if (!fragmentRef.isInLayout && childFragmentManager.fragments.size == 0) {
                    childFragmentManager.beginTransaction().replace(R.id.frameAlternativo, fragmentRef)
                        .commitNow()
                    it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
                    viewRoot.btCadastrar.text = textoBotao
                } else if (childFragmentManager.fragments.size == 1) { // Lógica de dois fragments
                    val id1Fragment = childFragmentManager.findFragmentById(childFragmentManager.fragments[0].id).javaClass
                    val id2Fragment = fragmentRef.javaClass

                    when (id2Fragment) {
                        SubFragmentAdocaoAnimal().javaClass -> {
                            if (id1Fragment == SubFragmentApadrinhamentoAnimal().javaClass) {
                                Toast.makeText(context,
                                    "Erro! Você não pode apadrinhar e adotar o animal ao mesmo tempo!",
                                    Toast.LENGTH_LONG).show()
                                it.toggle() // Reverte para unchecked, para evitar bugs
                            } else {
                                if (segundoFrameAlternativo.measuredHeight != 0) {
                                    childFragmentManager.beginTransaction().replace(R.id.frameAlternativo, fragmentRef).commitNow()
                                    it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
                                    viewRoot.btCadastrar.text = textoBotao
                                } else {
                                    childFragmentManager.beginTransaction().replace(R.id.segundoFrameAlternativo, fragmentRef).commitNow()
                                    it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
                                    viewRoot.btCadastrar.text = textoBotao
                                }
                            }
                        }
                        SubFragmentApadrinhamentoAnimal().javaClass -> {
                            if (id1Fragment == SubFragmentAdocaoAnimal().javaClass) {
                                Toast.makeText(context,
                                    "Erro! Você não pode apadrinhar e adotar o animal ao mesmo tempo!",
                                    Toast.LENGTH_LONG).show()
                                it.toggle() // Reverte para unchecked, para evitar bugs
                            } else {
                                if (segundoFrameAlternativo.measuredHeight != 0) {
                                    childFragmentManager.beginTransaction().replace(R.id.frameAlternativo, fragmentRef).commitNow()
                                    it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
                                    viewRoot.btCadastrar.text = textoBotao
                                } else {
                                    childFragmentManager.beginTransaction().replace(R.id.segundoFrameAlternativo, fragmentRef).commitNow()
                                    it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
                                    viewRoot.btCadastrar.text = textoBotao
                                }
                            }
                        }
                        else -> {
                            if (segundoFrameAlternativo.measuredHeight != 0) {
                                childFragmentManager.beginTransaction().replace(R.id.frameAlternativo, fragmentRef).commitNow()
                                it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
                                viewRoot.btCadastrar.text = textoBotao
                            } else {
                                childFragmentManager.beginTransaction().replace(R.id.segundoFrameAlternativo, fragmentRef).commitNow()
                                it.background.setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow_text), PorterDuff.Mode.MULTIPLY)
                                viewRoot.btCadastrar.text = textoBotao
                            }
                        }
                    }
                } else {
                    Toast.makeText(context, "Apenas duas opções podem ser selecionadas por vez", Toast.LENGTH_LONG).show()
                    it.toggle() // Reverte para unchecked, para evitar bugs
                }
            } else {

                it.background.clearColorFilter()
                if (fragmentRef.isVisible) {
                    childFragmentManager.beginTransaction().remove(fragmentRef).commitNow()
                    if (childFragmentManager.fragments.size == 0) {
                        Toast.makeText(context,
                            "Por favor, selecione pelo menos uma das 3 opções para continuar",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun realizarCadastro() {
        // TODO: Parsear os campos preencridos e colocar no objeto aqui
        val animal = Animal()
        animal.name = nomeDoAnimal.text.toString()
        animal.isAdotar = btAdocao.isChecked
        animal.isApadrinhar = btApadrinhar.isChecked
        animal.isAjudar = btAjudar.isChecked

        var id: Int = radioGroupEspecie.checkedRadioButtonId
        if (id == cachorroOption.id) {
            animal.especie = "cachorro"
        } else if (id == gatoOption.id) {
            animal.especie = "gato"
        }

        id = radioGroupSexo.checkedRadioButtonId
        if (id == machoOption.id) {
            animal.sexo = "Macho"
        } else if (id == femeaOption.id) {
            animal.sexo = "Femea"
        }

        id = radioGroupPorte.checkedRadioButtonId
        if (id == pequenoOption.id) {
            animal.porte = "Pequeno"
        } else if (id == medioOption.id) {
            animal.porte = "Medio"
        } else if (id == grandeOption.id) {
            animal.porte = "Grande"
        }

        id = radioGroupIdade.checkedRadioButtonId
        if (id == filhoteOption.id) {
            animal.idade = "Filhote"
        } else if (id == adultoOption.id) {
            animal.idade = "Adulto"
        } else if (id == idosoOption.id) {
            animal.idade = "Idoso"
        }

        animal.temperamento = ArrayList()
        if (brincalhaoOption.isChecked) animal.temperamento.add("brincalhao")
        if (timidoOption.isChecked) animal.temperamento.add("timido")
        if (calmoOption.isChecked) animal.temperamento.add("calmo")
        if (guardaOption.isChecked) animal.temperamento.add("guarda")
        if (amorosoOption.isChecked) animal.temperamento.add("amoroso")
        if (preguicosoOption.isChecked) animal.temperamento.add("preguicoso")

        animal.saude = ArrayList()
        if (vacinadoOption.isChecked) animal.saude.add("vacinado")
        if (vermifugadoOption.isChecked) animal.saude.add("vermifugado")
        if (castradoOption.isChecked) animal.saude.add("castrado")
        if (doenteOption.isChecked) animal.saude.add("doente")

        animal.sobre = etSobreOAnimal.text.toString()

        // Add a new document with a generated ID
        val db = FirebaseFirestore.getInstance()
        db.collection("animais")
                .add(animal)
                .addOnSuccessListener { documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.id) }
                .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }

    }
}