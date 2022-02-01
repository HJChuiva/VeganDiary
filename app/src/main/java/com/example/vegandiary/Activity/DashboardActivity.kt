package com.example.vegandiary.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vegandiary.R


class DashboardActivity : AppCompatActivity()  {

    lateinit var SearchTextButton: Button
    lateinit var ScrapButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_dashboard)

        SearchTextButton=findViewById<Button>(R.id.SearchTextButton)
        ScrapButton=findViewById<Button>(R.id.ScrapButton)

        /*SearchTextButton.setOnClickListener{
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)*/

        }

    }
