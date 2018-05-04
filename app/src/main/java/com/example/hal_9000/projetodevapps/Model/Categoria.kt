package com.example.hal_9000.projetodevapps.Model

import android.app.Fragment
import android.graphics.drawable.Drawable

/**
* Created by Danilo José Bispo Galvão on 27/04/2018.
*/

class Categoria(
        var nome: String?,
        var icone: Drawable?,
        var subcategoriaArrayList: ArrayList<Subcategoria>,
        var backgroundColor: Int?) {

}
