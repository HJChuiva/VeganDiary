package com.example.vegandiary.recipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vegandiary.R
import kotlinx.android.synthetic.main.scroll_search_recipe.*

class RecipescrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scroll_search_recipe)

        val recipeList= arrayListOf(
                Recipes(R.drawable.pancake,"brunch","Pankake", "10min / 5steps / for 1 person"),
                Recipes(R.drawable.pancake,"Baguette sandwich","Pankake", "15min / 5steps / for 1 person")
        )

        //val layout=LinearLayoutManager(this)

     /*   rv_recipe.layoutManager=layout


        rv_recipe.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_recipe.setHasFixedSize(true)

        rv_recipe.adapter =RecipeAdapter(recipeList)
*/

    }


}