package com.example.veganDiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vegandiary.Activity.CustomAdapter
import com.example.vegandiary.R
import com.example.vegandiary.Activity.com.example.vegandiary.sql.RecipeData
import kotlinx.android.synthetic.main.scroll_search_recipe.*


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val list = ArrayList<RecipeData>()
        list.add(RecipeData(null,"Signature brunch menu"))
        list.add(RecipeData(null,"A picnic menu"))

        val adapter=CustomAdapter(list)
        scroll_search_recipe.adapter=adapter
    }
}