package com.example.hal_9000.projetodevapps

import android.widget.Button
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View

/**
 * Created by Danilo José Bispo Galvão on 04/05/2018.
 */

@Layout(R.layout.drawer_button_footer)
class BotaoSair {
    @View(R.id.drawerButtonSair)
    private val drawerButton: Button? = null

    @Resolve
    private fun onResolved(){

    }
}