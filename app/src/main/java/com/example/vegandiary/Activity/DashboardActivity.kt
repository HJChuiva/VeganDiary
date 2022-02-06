package com.example.vegandiary.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vegandiary.Fragment.RestaurantFragment
import com.example.vegandiary.R
import com.example.vegandiary.memoView.MemoActivity


class DashboardActivity : AppCompatActivity()  {

    lateinit var SearchTextButton: Button

    //하단 메뉴바
    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton

    lateinit var ScrapButton:android.widget.ImageButton

    private val restaurantFragment = RestaurantFragment() // 비건 식당 화면

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        SearchTextButton = findViewById<Button>(R.id.SearchTextButton)
        recipe_btn =findViewById<android.widget.ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<android.widget.ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<android.widget.ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<android.widget.ImageButton>(R.id.setting_btn)
        //ScrapButton = findViewById<Button>(R.id.ScrapButton)

        ScrapButton=findViewById<android.widget.ImageButton>(R.id.ScrapButton)

        SearchTextButton.setOnClickListener {
            val intent = Intent(this, SearchFullActivity::class.java)
            this.startActivity(intent)
        }

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
            val intent = Intent(this, MemoActivity::class.java)
            this.startActivity(intent)
        }
        setting_btn.setOnClickListener{
            val intent = Intent(this, SettingActivity::class.java)
            this.startActivity(intent)
        }
        ScrapButton.setOnClickListener{
            val intent = Intent(this, ScrapActivity::class.java)
            this.startActivity(intent)
        }

    }
}