package com.example.vegandiary

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {


    lateinit var imageButton5: ImageButton

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            TODO("Not yet implemented")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton5 = findViewById<ImageButton>(R.id.imageButton5)

        // 비건 식당 페이지로 이동
        imageButton5.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java) //화면 전환
            startActivity(intent)
        }

    }
}

