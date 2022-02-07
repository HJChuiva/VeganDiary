package com.example.vegandiary.Activity.Recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.Activity.DashboardActivity
import com.example.vegandiary.Activity.MapsActivity
import com.example.vegandiary.Activity.SettingActivity
import com.example.vegandiary.R
import com.example.vegandiary.memoView.MemoActivity

class Ingredient4Activity : AppCompatActivity() {
    lateinit var tip: Button
    lateinit var Howtocook_btn : Button

    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient4)

        recipe_btn =findViewById<android.widget.ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<android.widget.ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<android.widget.ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<android.widget.ImageButton>(R.id.setting_btn)

        Howtocook_btn=findViewById<Button>(R.id.Howtocook_btn)


        tip=findViewById<Button>(R.id.tip)

        Howtocook_btn.setOnClickListener{
            val intent = Intent(this, Activity_howtocook4::class.java)
            this.startActivity(intent)
        }

        tip.setOnClickListener{
            val toast= Toast.makeText(this, "Tip\n\n동그란 케이크 틀에 담은 뒤, 6등분\n으로 칼집을 내 자르면 깔끔하게 세모\n모양의 스콘을 만들 수 있어요", Toast.LENGTH_SHORT).show()
        }
        //하단 메뉴바
        recipe_btn.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
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
    }
}