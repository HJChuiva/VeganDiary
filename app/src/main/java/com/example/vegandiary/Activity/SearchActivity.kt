package com.example.veganDiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.vegandiary.R


class SearchActivity : AppCompatActivity() {

    lateinit var brunch_btn: ImageButton
    lateinit var dessert_btn: ImageButton
    lateinit var GoBack_Btn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

    }
}
