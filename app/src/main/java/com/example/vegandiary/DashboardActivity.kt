package com.example.vegandiary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.vegandiary.Fragment.*
import com.example.vegandiary.Fragment.SearchFragment
import com.example.vegandiary.DashboardActivity as DashboardActivity1



class DashboardActivity : AppCompatActivity()  {
    var context: Context? = null

    lateinit var searchTextButton: Button


    private val searchFragment = SearchFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_dashboard)

        searchTextButton=findViewById<Button>(R.id.SearchTextButton)

        searchTextButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java);
            startActivity(intent)
            }
        }



}


