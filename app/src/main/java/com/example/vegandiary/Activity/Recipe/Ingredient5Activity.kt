package com.example.vegandiary.Activity.Recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.R

class Ingredient5Activity : AppCompatActivity() {
    lateinit var tip: Button

    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient5)

        tip=findViewById<Button>(R.id.tip)

        tip.setOnClickListener{
            val toast= Toast.makeText(this, "Tip\n\n더 바삭바삭한 식감을 원하면 오븐에 굽\n는 시간을 조금 늘려도 됩니다 하지만\n너무 오래 구우면 딱딱해질 수 있어요", Toast.LENGTH_SHORT).show()

        }
    }
}