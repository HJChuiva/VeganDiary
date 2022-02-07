package com.example.vegandiary.Activity.com.example.vegandiary.Intro

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_intro_pager.view.*

class MyPagerViewholder(itemView: View): RecyclerView.ViewHolder(itemView) {
    //뷰 선언
    private val itemImage=itemView.pager_item_image
    private val itemText1 = itemView.pager_item_text1
    private val itemText2 = itemView.pager_item_text2

    //뷰 정보 받기
    fun bindWithView(pageItem: PageItem){
        itemImage.setImageResource(pageItem.image)
        itemText1.text=pageItem.text1
        itemText2.text=pageItem.text2
    }
}