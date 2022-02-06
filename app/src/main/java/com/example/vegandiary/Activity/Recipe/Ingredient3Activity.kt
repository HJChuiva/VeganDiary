package com.example.vegandiary.Activity.Recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.R

class Ingredient3Activity : AppCompatActivity() {
    lateinit var tip: Button

    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient3)

        tip=findViewById<Button>(R.id.tip)

        tip.setOnClickListener{
            val toast= Toast.makeText(this, "Tip\n\n병아리콩을 으깰 때 적당히 으깨야 씹는\n맛이 좋아요 너무 많이 으깨지 않도록\n주의하세요", Toast.LENGTH_SHORT).show()

        }
    }
}