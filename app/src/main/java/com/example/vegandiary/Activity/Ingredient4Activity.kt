package com.example.vegandiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.R

class Ingredient4Activity : AppCompatActivity() {
    lateinit var tip: Button

    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient4)

        tip=findViewById<Button>(R.id.tip)

        tip.setOnClickListener{
            val toast= Toast.makeText(this, "Tip\n\n동그란 케이크 틀에 담은 뒤, 6등분\n으로 칼집을 내 자르면 깔끔하게 세모\n모양의 스콘을 만들 수 있어요", Toast.LENGTH_SHORT).show()

        }
    }
}