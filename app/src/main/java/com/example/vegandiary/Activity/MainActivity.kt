package com.example.vegandiary.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vegandiary.Activity.Recipe.Ingredient4Activity
import com.example.vegandiary.Activity.Recipe.ScrapActivity
import com.example.vegandiary.Activity.Search.SearchFullActivity
import com.example.vegandiary.R
import com.example.vegandiary.MemoView.MemoActivity


class MainActivity : AppCompatActivity()  {

    //세부 화면으로 가는 버튼 선언
    lateinit var SearchTextButton: Button
    //
    lateinit var FindRecipe_btn:Button
    //하단 메뉴바 버튼 선언
    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton
    //스크랩 화면 버튼 선언
    lateinit var ScrapButton:android.widget.ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //클릭시 숫자 count 늘어나는 하트 버튼 구현
        val count_num=findViewById<TextView>(R.id.hearttext1)
        val count_num2=findViewById<TextView>(R.id.hearttext2)
        val heartbtn=findViewById<ImageButton>(R.id.heart1)
        val heartbtn2=findViewById<ImageButton>(R.id.heart2)
        var count1=0
        var count2=0



        SearchTextButton = findViewById<Button>(R.id.SearchTextButton)
        recipe_btn =findViewById<android.widget.ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<android.widget.ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<android.widget.ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<android.widget.ImageButton>(R.id.setting_btn)

        FindRecipe_btn=findViewById<Button>(R.id.FindRecipe_btn)

        ScrapButton=findViewById<android.widget.ImageButton>(R.id.ScrapButton)

        SearchTextButton.setOnClickListener {
            val intent = Intent(this, SearchFullActivity::class.java)
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



        ScrapButton.setOnClickListener{
            val intent = Intent(this, ScrapActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }

        FindRecipe_btn.setOnClickListener{
            val intent = Intent(this, Ingredient4Activity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }

        heartbtn.setOnClickListener{
            count1++
            count_num.text=count1.toString()
        }
        heartbtn2.setOnClickListener{
            count2++
            count_num2.text=count2.toString()
        }


    }
}