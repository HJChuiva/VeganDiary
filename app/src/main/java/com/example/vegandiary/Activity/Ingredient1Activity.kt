package com.example.vegandiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.R

class Ingredient1Activity : AppCompatActivity() {

    lateinit var tip: Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient1)

        tip=findViewById<Button>(R.id.tip)

        tip.setOnClickListener{
            val toast=Toast.makeText(this, "Tip\n\n팬케이크를 너무 오래 구우면 촉촉한 맛이 떨어져요. 기포가 어느 정도 올라오면 바로 뒤집으세요.", Toast.LENGTH_SHORT).show()
        }
    }
}