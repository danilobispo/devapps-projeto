package com.example.hal_9000.projetodevapps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.app.ProgressDialog



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDrawer()
        setupFragment()


    }

    fun setupDrawer() {
        drawerView.addView(DrawerHeader())
            .addView(ExpandableListMenu(this))


        // toolbar cast como View
        val drawerToggle: ActionBarDrawerToggle = object :
            ActionBarDrawerToggle(this, drawer, toolbar as Toolbar, R.string.open_drawer, R.string.close_drawer) {
            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }
        }

        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    fun setupFragment() {
        this.fragmentManager.beginTransaction().replace(R.id.content_frame, IntroducaoFragment())
            .addToBackStack(null).commit()
    }

}
