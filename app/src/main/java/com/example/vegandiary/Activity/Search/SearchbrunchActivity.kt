package com.example.vegandiary.Activity.Search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.vegandiary.Activity.MainActivity
import com.example.vegandiary.Activity.Recipe.Ingredient1Activity
import com.example.vegandiary.Activity.Recipe.Ingredient2Activity
import com.example.vegandiary.Activity.Recipe.Ingredient3Activity
import com.example.vegandiary.R


class SearchbrunchActivity : AppCompatActivity() {
    //슬라이딩 패널

    //버튼 선언
    lateinit var brunch_btn: ImageButton
    lateinit var dessert_btn: ImageButton
    lateinit var GoBack_Btn:ImageButton

    lateinit var brunch_btn1 : ImageButton
    lateinit var brunch_btn2 : ImageButton
    lateinit var brunch_btn3 : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_brunch)

        //카테고리 선택 버튼
        brunch_btn = findViewById<ImageButton>(R.id.brunch_btn)
        dessert_btn = findViewById<ImageButton>(R.id.dessert_btn)
        GoBack_Btn = findViewById<ImageButton>(R.id.GoBack_Btn)

        //메뉴 선택 버튼
        brunch_btn1=findViewById<ImageButton>(R.id.brunch_btn1)
        brunch_btn2=findViewById<ImageButton>(R.id.brunch_btn2)
        brunch_btn3=findViewById<ImageButton>(R.id.brunch_btn3)

        //카테고리 선택 버튼 이벤트
        brunch_btn.setOnClickListener {
            val intent = Intent(this, SearchbrunchActivity::class.java)     //SearchbrunchActivity로 액티비티 이동 ,
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        dessert_btn.setOnClickListener {
            val intent = Intent(this, SearchdessertActivity::class.java)    //SearchdessertActivity로 액티비티 이동
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        GoBack_Btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)     //뒤로가기
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }

        //메뉴 선택 버튼 이벤트
        brunch_btn1.setOnClickListener {
            val intent = Intent(this, Ingredient1Activity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        brunch_btn2.setOnClickListener {
            val intent = Intent(this, Ingredient2Activity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        brunch_btn3.setOnClickListener {
            val intent = Intent(this, Ingredient3Activity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
    }
    }