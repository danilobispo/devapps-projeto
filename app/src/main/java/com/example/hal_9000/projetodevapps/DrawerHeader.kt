package com.example.hal_9000.projetodevapps

import android.widget.ImageView
import android.widget.TextView

import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.NonReusable
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View

/**
 * Created by HAL-9000 on 22/04/2018.
 */

@NonReusable
@Layout(R.layout.drawer_header)
class DrawerHeader {

    @View(R.id.profileImageView)
    private val profileImage: ImageView? = null

    @View(R.id.nameTxt)
    private val nameTxt: TextView? = null

    @Resolve
    private fun onResolved() {
        nameTxt!!.text = "Emile Catarine"
    }
}