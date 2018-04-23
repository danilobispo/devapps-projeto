package com.example.hal_9000.projetodevapps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        setupDrawer();
    }

    fun setupDrawer() {
        drawerView.addView(DrawerHeader())
                .addView(DrawerMenuItem(applicationContext, DrawerMenuItem.DRAWER_MENU_ITEM_PROFILE))
                .addView(DrawerMenuItem(applicationContext, DrawerMenuItem.DRAWER_MENU_ITEM_REQUESTS))
                .addView(DrawerMenuItem(applicationContext, DrawerMenuItem.DRAWER_MENU_ITEM_MESSAGE))
                .addView(DrawerMenuItem(applicationContext, DrawerMenuItem.DRAWER_MENU_ITEM_GROUPS))
                .addView(DrawerMenuItem(applicationContext, DrawerMenuItem.DRAWER_MENU_ITEM_NOTIFICATIONS))
                .addView(DrawerMenuItem(applicationContext, DrawerMenuItem.DRAWER_MENU_ITEM_TERMS))
                .addView(DrawerMenuItem(applicationContext, DrawerMenuItem.DRAWER_MENU_ITEM_SETTINGS))
                .addView(DrawerMenuItem(applicationContext, DrawerMenuItem.DRAWER_MENU_ITEM_LOGOUT))


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

        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}
