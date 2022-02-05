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


class SearchdessertActivity : AppCompatActivity() {

        lateinit var brunch_btn: ImageButton
        lateinit var dessert_btn: ImageButton
        lateinit var GoBack_Btn:ImageButton

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_search_dessert)

            brunch_btn = findViewById<ImageButton>(R.id.brunch_btn)
            dessert_btn = findViewById<ImageButton>(R.id.dessert_btn)
            GoBack_Btn = findViewById<ImageButton>(R.id.GoBack_Btn)

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
        }
    }