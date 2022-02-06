package com.example.vegandiary.Activity.Recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.R

class Ingredient6Activity : AppCompatActivity() {
    lateinit var tip: Button

    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient6)

        tip=findViewById<Button>(R.id.tip)

        tip.setOnClickListener{
            val toast= Toast.makeText(this, "Tip\n\n커민 대신 참깨를 넣어 섞어도 좋아요", Toast.LENGTH_SHORT).show()

        }
    }
}