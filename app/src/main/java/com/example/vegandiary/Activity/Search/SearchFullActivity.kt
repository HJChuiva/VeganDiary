package com.example.vegandiary.Activity.Search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.vegandiary.R


class SearchFullActivity : AppCompatActivity() {

    //선택하지 않은 초반 레시피 검색 초반 화면

    //버튼 선언
    lateinit var brunch_btn: ImageButton
    lateinit var dessert_btn: ImageButton
    lateinit var GoBack_Btn:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_full)

        brunch_btn = findViewById<ImageButton>(R.id.brunch_btn)
        dessert_btn = findViewById<ImageButton>(R.id.dessert_btn)
        GoBack_Btn = findViewById<ImageButton>(R.id.GoBack_Btn)

        //카테고리 선택 버튼 이벤트
        brunch_btn.setOnClickListener {
            val intent = Intent(this, SearchbrunchActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
            brunch_btn.setBackgroundResource(R.drawable.green_round_stroke)
        }
        dessert_btn.setOnClickListener {
            val intent = Intent(this, SearchdessertActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        GoBack_Btn.setOnClickListener {
            super.onBackPressed()
        }
    }
    }