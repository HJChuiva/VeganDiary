
package com.example.vegandiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.vegandiary.R

class ScrollBrunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var brunch_btn1 : ImageButton

        super.onCreate(savedInstanceState)
        setContentView(R.layout.scroll_search_brunch)

        brunch_btn1 = findViewById<ImageButton>(R.id.brunch_btn1)

        brunch_btn1.setOnClickListener {
            val intent = Intent(this, Ingredient1Activity::class.java)
            this.startActivity(intent)
        }
    }
}