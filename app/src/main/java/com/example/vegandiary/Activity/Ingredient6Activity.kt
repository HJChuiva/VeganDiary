package com.example.vegandiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.vegandiary.R

class Ingredient6Activity : AppCompatActivity() {
    lateinit var tip: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient6)

        tip=findViewById<Button>(R.id.tip)

        tip.setOnClickListener{
            val toast= Toast.makeText(this, "Tip\n\n커민 대신 참깨를 넣어 섞어도 좋아요", Toast.LENGTH_SHORT).show()

        }
    }
}