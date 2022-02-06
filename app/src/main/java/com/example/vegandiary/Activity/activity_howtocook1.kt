package com.example.vegandiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.vegandiary.R

class activity_howtocook1 : AppCompatActivity() {

    lateinit var Ingredient_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_howtocook1)

        Ingredient_btn=findViewById(R.id.Ingredient_btn)

        Ingredient_btn.setOnClickListener{
            val intent = Intent(this, Ingredient1Activity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
    }
}