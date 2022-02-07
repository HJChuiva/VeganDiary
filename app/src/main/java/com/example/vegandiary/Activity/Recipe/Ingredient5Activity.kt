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
import com.example.vegandiary.MemoView.MemoActivity

class Ingredient5Activity : AppCompatActivity() {
    lateinit var tip: Button
    lateinit var Howtocook_btn : Button

    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient5)

        recipe_btn =findViewById<android.widget.ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<android.widget.ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<android.widget.ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<android.widget.ImageButton>(R.id.setting_btn)


        tip=findViewById<Button>(R.id.tip)

        Howtocook_btn=findViewById<Button>(R.id.Howtocook_btn)

        Howtocook_btn.setOnClickListener{
            val intent = Intent(this, Activity_howtocook5::class.java)
            this.startActivity(intent)
        }

        tip.setOnClickListener{
            val toast= Toast.makeText(this, "Tip\n\n더 바삭바삭한 식감을 원하면 오븐에 굽\n는 시간을 조금 늘려도 됩니다 하지만\n너무 오래 구우면 딱딱해질 수 있어요", Toast.LENGTH_SHORT).show()
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
    }
}