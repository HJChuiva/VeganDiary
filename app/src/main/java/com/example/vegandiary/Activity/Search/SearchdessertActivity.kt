package com.example.vegandiary.Activity.Search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.vegandiary.Activity.MainActivity
import com.example.vegandiary.Activity.Recipe.Ingredient4Activity
import com.example.vegandiary.Activity.Recipe.Ingredient5Activity
import com.example.vegandiary.Activity.Recipe.Ingredient6Activity
import com.example.vegandiary.R


class SearchdessertActivity : AppCompatActivity() {

        //버튼 선언
        lateinit var brunch_btn: ImageButton
        lateinit var dessert_btn: ImageButton
        lateinit var GoBack_Btn:ImageButton

        lateinit var dessert_btn1:ImageButton
        lateinit var dessert_btn2:ImageButton
        lateinit var dessert_btn3:ImageButton

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_search_dessert)

            brunch_btn = findViewById<ImageButton>(R.id.brunch_btn)
            dessert_btn = findViewById<ImageButton>(R.id.dessert_btn)
            GoBack_Btn = findViewById<ImageButton>(R.id.GoBack_Btn)

            //메뉴 선택 버튼
            dessert_btn1=findViewById<ImageButton>(R.id.dessert_btn1)
            dessert_btn2=findViewById<ImageButton>(R.id.dessert_btn2)
            dessert_btn3=findViewById<ImageButton>(R.id.dessert_btn3)

            brunch_btn.setOnClickListener {
                val intent = Intent(this, SearchbrunchActivity::class.java)
                this.startActivity(intent)
                overridePendingTransition(0, 0); //애니메이션 없애기
            }
            dessert_btn.setOnClickListener {
                val intent = Intent(this, SearchdessertActivity::class.java)
                this.startActivity(intent)
                overridePendingTransition(0, 0); //애니메이션 없애기
            }
            GoBack_Btn.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
                overridePendingTransition(0, 0); //애니메이션 없애기
            }

            dessert_btn1.setOnClickListener {
                val intent = Intent(this, Ingredient4Activity::class.java)
                this.startActivity(intent)
                overridePendingTransition(0, 0); //애니메이션 없애기
            }
            dessert_btn2.setOnClickListener {
                val intent = Intent(this, Ingredient6Activity::class.java)
                this.startActivity(intent)
                overridePendingTransition(0, 0); //애니메이션 없애기
            }
            dessert_btn3.setOnClickListener {
                val intent = Intent(this, Ingredient5Activity::class.java)
                this.startActivity(intent)
                overridePendingTransition(0, 0); //애니메이션 없애기
            }
        }
    }