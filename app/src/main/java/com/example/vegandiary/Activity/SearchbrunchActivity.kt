package com.example.vegandiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.bumptech.glide.Glide
import com.example.vegandiary.Fragment.SearchFragment
import com.example.vegandiary.R
import kotlinx.android.synthetic.main.scroll_search_brunch.*
import kotlinx.android.synthetic.main.fragment_dashboard.*


class SearchbrunchActivity : AppCompatActivity() {
    lateinit var brunch_btn: ImageButton
    lateinit var dessert_btn: ImageButton
    lateinit var GoBack_Btn:ImageButton

    lateinit var brunch_btn1 : ImageButton
    lateinit var brunch_btn2 : ImageButton
    lateinit var brunch_btn3 : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_brunch)

        brunch_btn = findViewById<ImageButton>(R.id.brunch_btn)
        dessert_btn = findViewById<ImageButton>(R.id.dessert_btn)
        GoBack_Btn = findViewById<ImageButton>(R.id.GoBack_Btn)

        brunch_btn1=findViewById<ImageButton>(R.id.brunch_btn1)
        brunch_btn2=findViewById<ImageButton>(R.id.brunch_btn2)
        brunch_btn3=findViewById<ImageButton>(R.id.brunch_btn3)

        brunch_btn.setOnClickListener {
            val intent = Intent(this, SearchbrunchActivity::class.java)
            this.startActivity(intent)
        }
        dessert_btn.setOnClickListener {
            val intent = Intent(this, SearchdessertActivity::class.java)
            this.startActivity(intent)
        }
        GoBack_Btn.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            this.startActivity(intent)
        }

        brunch_btn1.setOnClickListener {
            val intent = Intent(this, Ingredient1Activity::class.java)
            this.startActivity(intent)
        }
        brunch_btn2.setOnClickListener {
            val intent = Intent(this, Ingredient2Activity::class.java)
            this.startActivity(intent)
        }
        brunch_btn3.setOnClickListener {
            val intent = Intent(this, Ingredient3Activity::class.java)
            this.startActivity(intent)
        }
    }
    }