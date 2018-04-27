package com.example.hal_9000.projetodevapps

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.mindorks.placeholderview.ExpandablePlaceHolderView
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.expand.*

/**
 * Created by HAL-9000 on 25/04/2018.
 */
@Layout(R.layout.drawer_menu_header)
class DrawerMenuHeader (private val mContext: Context, private val mMenuPosition:Int) {
    private var mCallBack:DrawerCallBack?=null

    @View(R.id.drawerMenuHeader_itemNameTxt)
    private val itemNameTxt: TextView?=null

    @View(R.id.drawerMenuHeader_itemIcon)
    private val itemIcon: ImageView?=null

    @Resolve
    private fun onResolved(){
        when(mMenuPosition){
            DRAWER_MENU_HEADER_ITEM_ATALHOS->{
                itemNameTxt!!.text= mContext.getString(R.string.str_menu_header_atalhos)
                itemIcon!!.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.ic_account_circle_black_18dp))
            }
            DRAWER_MENU_HEADER_ITEM_CONFIGURACOES->{
                itemNameTxt!!.text= mContext.getString(R.string.str_menu_header_informacoes)
                itemIcon!!.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.ic_compare_arrows_black_18dp))
            }
            DRAWER_MENU_HEADER_ITEM_INFORMACOES->{
                itemNameTxt!!.text= mContext.getString(R.string.str_menu_header_configuracoes)
                itemIcon!!.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.ic_settings_black_18dp))
            }
        }
    }

    @Click(R.id.drawerMenuHeader_dropdown)
    private fun onMenuHeaderClick(){
        when(mMenuPosition){
            DRAWER_MENU_HEADER_ITEM_ATALHOS->{
                Toast.makeText(mContext,R.string.str_menu_header_atalhos,Toast.LENGTH_SHORT).show()
                if(mCallBack!=null)mCallBack!!.onAtalhosMenuSelected()
            }
            DRAWER_MENU_HEADER_ITEM_INFORMACOES->{
                Toast.makeText(mContext,R.string.str_menu_header_informacoes,Toast.LENGTH_SHORT).show()
                if(mCallBack!=null)mCallBack!!.onInformacoesMenuSelected()
            }
            DRAWER_MENU_HEADER_ITEM_CONFIGURACOES->{
                Toast.makeText(mContext,R.string.str_menu_header_configuracoes,Toast.LENGTH_SHORT).show()
                if(mCallBack!=null)mCallBack!!.onConfiguracoesMenuSelected()
            }
        }
    }

    interface DrawerCallBack {
        fun onAtalhosMenuSelected()
        fun onInformacoesMenuSelected()
        fun onConfiguracoesMenuSelected()
    }

    companion object {
        val DRAWER_MENU_HEADER_ITEM_ATALHOS=1
        val DRAWER_MENU_HEADER_ITEM_INFORMACOES=2
        val DRAWER_MENU_HEADER_ITEM_CONFIGURACOES=3
    }
}