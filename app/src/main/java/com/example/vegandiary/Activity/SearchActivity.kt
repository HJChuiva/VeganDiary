package com.example.vegandiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.vegandiary.R
import kotlinx.android.synthetic.main.scroll_search_brunch.*


class SearchActivity : AppCompatActivity() {


    lateinit var recipe_btn: ImageButton
    lateinit var restaurant_btn: ImageButton
    lateinit var calendar_btn:ImageButton
    lateinit var setting_btn:ImageButton

    lateinit var brunch_btn: ImageButton
    lateinit var dessert_btn: ImageButton

    lateinit var brunch_btn1:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recipe_btn =findViewById<ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<ImageButton>(R.id.setting_btn)

        brunch_btn=findViewById<ImageButton>(R.id.brunch_btn)
        dessert_btn=findViewById<ImageButton>(R.id.dessert_btn)

        brunch_btn1 = findViewById<ImageButton>(R.id.brunch_btn1)

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
            val intent = Intent(this, SearchbrunchActivity::class.java)
            this.startActivity(intent)
        }
    }
}