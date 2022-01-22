package com.example.vegandiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var tv_id : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tv_id = findViewById<TextView>(R.id.tv_id)

        if(intent.hasExtra("User")){
            tv_id.text = intent.getStringExtra("User") +"님 환영합니다!" //value 값이 넘어옴
        }
    }
}