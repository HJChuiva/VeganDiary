package com.example.vegandiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.bumptech.glide.Glide
import com.example.vegandiary.Fragment.SearchFragment
import com.example.vegandiary.R
import kotlinx.android.synthetic.main.activity_ingredient1.*
import kotlinx.android.synthetic.main.fragment_dashboard.*


class SearchActivity : AppCompatActivity() {


    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton

    lateinit var brunch_btn: ImageButton
    lateinit var dessert_btn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_full)

        recipe_btn =findViewById<android.widget.ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<android.widget.ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<android.widget.ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<android.widget.ImageButton>(R.id.setting_btn)

        brunch_btn=findViewById<android.widget.ImageButton>(R.id.brunch_btn)
        dessert_btn=findViewById<android.widget.ImageButton>(R.id.dessert_btn)

        //하단 메뉴바
        recipe_btn.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
            this.startActivity(intent)
        }
        restaurant_btn.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java)
            this.startActivity(intent)
        }
        calendar_btn.setOnClickListener{
            val intent = Intent(this, ChallengeActivity::class.java)
            this.startActivity(intent)
        }
        setting_btn.setOnClickListener{
            val intent = Intent(this, SettingActivity::class.java)
            this.startActivity(intent)
        }

        brunch_btn.setOnClickListener{
            val intent = Intent(this, SearchBtnActivity::class.java)
            this.startActivity(intent)
        }
    }
}