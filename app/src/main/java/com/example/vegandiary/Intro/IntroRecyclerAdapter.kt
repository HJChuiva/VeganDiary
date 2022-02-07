package com.example.vegandiary.Activity.com.example.vegandiary.Intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vegandiary.R

class IntroRecyclerAdapter (private  var pageList: ArrayList<PageItem>)
    : RecyclerView.Adapter<MyPagerViewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagerViewholder {
        return  MyPagerViewholder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_intro_pager,parent,false))
    }

    //pageList.size 리턴
    override fun getItemCount(): Int {
        return pageList.size
    }

    //데이터와 뷰 묶기
    override fun onBindViewHolder(holder: MyPagerViewholder, position: Int) {
        holder.bindWithView(pageList[position])     //position값 받아오기
    }
}





