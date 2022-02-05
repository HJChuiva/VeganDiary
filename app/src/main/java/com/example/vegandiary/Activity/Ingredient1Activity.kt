package com.example.vegandiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.R

class Ingredient1Activity : AppCompatActivity() {

    lateinit var tip: Button
    lateinit var Howtocook_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient1)

        tip=findViewById<Button>(R.id.tip)
        Howtocook_btn=findViewById<Button>(R.id.Howtocook_btn)

        tip.setOnClickListener{
            val toast=Toast.makeText(this, "Tip\n\n팬케이크를 너무 오래 구우면 촉촉한 맛이 떨어져요. \n기포가 어느 정도 올라오면 바로 뒤집으세요.", Toast.LENGTH_SHORT).show()

        }
        Howtocook_btn.setOnClickListener{
            val intent = Intent(this, activity_howtocook1::class.java)
            this.startActivity(intent)
        }
    }
}