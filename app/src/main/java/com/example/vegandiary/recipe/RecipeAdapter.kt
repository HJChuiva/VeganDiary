package com.example.vegandiary.recipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.vegandiary.R

class RecipeAdapter(val recipeList:ArrayList<Recipes>):
        RecyclerView.Adapter<RecipeAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.CustomViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_search,parent,false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener(){
                val curPos:Int=adapterPosition
                val Recipes:Recipes=recipeList.get(curPos)
            }
        }
    }

    override fun onBindViewHolder(holder: RecipeAdapter.CustomViewHolder, position: Int) {
        // holder.image.setImageResource(recipeList.get(position).image)
        holder.category.text=recipeList.get(position).category
        holder.name.text=recipeList.get(position).name
        // holder.detail.text=recipeList.get(position).detail


    }

    override fun getItemCount(): Int {
        return recipeList.size
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // val image=itemView.findViewById<ImageView>(R.id.recipeimage)
        val category=itemView.findViewById<TextView>(R.id.txt_recipeCategory)
        val name=itemView.findViewById<TextView>(R.id.txt_recipeName)
        // val detail=itemView.findViewById<TextView>(R.id.txt_detail)

    }
}