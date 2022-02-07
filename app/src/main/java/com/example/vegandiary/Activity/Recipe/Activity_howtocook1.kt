package com.example.vegandiary.Activity.Recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.Activity.MainActivity
import com.example.vegandiary.Activity.MapsActivity
import com.example.vegandiary.Activity.SettingActivity
import com.example.vegandiary.R
import com.example.vegandiary.memoView.MemoActivity

class Activity_howtocook1 : AppCompatActivity() {

    //버튼선언
    lateinit var tip: Button

    lateinit var Ingredient_btn : Button

    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_howtocook1)

        //button 가져오기

        tip=findViewById<Button>(R.id.tip)

        recipe_btn =findViewById<android.widget.ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<android.widget.ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<android.widget.ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<android.widget.ImageButton>(R.id.setting_btn)

        Ingredient_btn=findViewById(R.id.Ingredient_btn)

        Ingredient_btn.setOnClickListener{
            val intent = Intent(this, Ingredient1Activity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }

        //하단 메뉴바
        recipe_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        restaurant_btn.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        calendar_btn.setOnClickListener{
            val intent = Intent(this, MemoActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        setting_btn.setOnClickListener{
            val intent = Intent(this, SettingActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }

        //토스트메세지 호출
        tip.setOnClickListener{
            val toast= Toast.makeText(this, "Tip\n\n팬케이크를 너무 오래 구우면 촉촉한 맛이 떨어져요. 기포가 어느 정도 올라오면 바로 뒤집으세요.", Toast.LENGTH_SHORT).show()
        }
    }
}