package com.example.veganDiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.vegandiary.Activity.DashboardActivity
import com.example.vegandiary.Activity.SearchbrunchActivity
import com.example.vegandiary.Activity.SearchdessertActivity
import com.example.vegandiary.R
import kotlinx.android.synthetic.main.scroll_search_recipe.*


class SearchActivity : AppCompatActivity() {

    lateinit var brunch_btn: ImageButton
    lateinit var dessert_btn: ImageButton
    lateinit var GoBack_Btn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        /*brunch_btn = findViewById<ImageButton>(R.id.brunch_btn)
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
            this.startActivity(intent)*/
        }
    }
