
package com.example.vegandiary.Activity.Search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.vegandiary.Activity.Recipe.Ingredient1Activity
import com.example.vegandiary.R

class ScrollBrunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //버튼 선언
        lateinit var brunch_btn1 : ImageButton

        super.onCreate(savedInstanceState)
        setContentView(R.layout.scroll_search_brunch)       //슬라이딩 패널

        brunch_btn1 = findViewById<ImageButton>(R.id.brunch_btn1)

        //Ingredient1Activity 호출
        brunch_btn1.setOnClickListener {
            val intent = Intent(this, Ingredient1Activity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
    }
}