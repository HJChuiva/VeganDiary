package com.example.vegandiary.Activity.com.example.vegandiary.Intro

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_intro_pager.view.*

class MyPagerViewholder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val itemImage=itemView.pager_item_image
    private val itemText1 = itemView.pager_item_text1
    private val itemText2 = itemView.pager_item_text2
    private val itemText3 = itemView.pager_item_text3

    fun bindWithView(pageItem: PageItem){
        itemImage.setImageResource(pageItem.image)
        itemText1.text=pageItem.text1
        itemText2.text=pageItem.text2
        itemText3.text=pageItem.text3


    }
}