package com.example.vegandiary.Activity

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vegandiary.R
import com.example.vegandiary.MemoView.MemoActivity


class SettingActivity : AppCompatActivity() {

    private var textViewName: TextView? = null

    //하단 메뉴바
    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        textViewName = findViewById<TextView>(R.id.ProfileName) as TextView
        val nameFromIntent = intent.getStringExtra("EMAIL")
        textViewName!!.text = "Welcome $nameFromIntent"

        //하단 메뉴바 이미지버튼 id 받아오기
        recipe_btn =findViewById<android.widget.ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<android.widget.ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<android.widget.ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<android.widget.ImageButton>(R.id.setting_btn)


        //하단 메뉴바 버튼 클릭 이벤트
        recipe_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        restaurant_btn.setOnClickListener{
            val intent = Intent(this, MemoActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        calendar_btn.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        setting_btn.setOnClickListener{
            val intent = Intent(this, SettingActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }

    }

        //SQLiteOpenHelper
    class myDBHelper(context: Context?) : SQLiteOpenHelper(context, "groupDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL("CREATE TABLE groupTBL ( gName CHAR(20) PRIMARY KEY,gNumber INTEGER);")
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL")
            onCreate(db)
        }

    }
}