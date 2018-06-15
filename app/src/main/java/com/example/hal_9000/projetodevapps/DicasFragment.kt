package com.example.hal_9000.projetodevapps


import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_dicas.*


class DicasFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_dicas, container, false)

        val dica = rootView?.findViewById<android.support.constraint.ConstraintLayout>(R.id.dica8)
            dica!!.setOnClickListener({ _ ->
                activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.content_frame, DetalheDicaFragment()).commit()
            })


        return rootView
    }

}
