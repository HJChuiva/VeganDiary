package com.example.vegandiary

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.example.vegandiary.Fragment.CalenderFragment
import com.example.vegandiary.Fragment.DashboardFragment
import com.example.vegandiary.Fragment.RestaurantFragment
import com.example.vegandiary.Fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val restaurantFragment = RestaurantFragment()
    private val calenderFragment = CalenderFragment()
    private val settingFragment = SettingFragment()

    lateinit var bottom_navigation : BottomNavigationView



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

        bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        replaceFragment(dashboardFragment) // 기본 화면 : dashboardFragment

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_recipe-> replaceFragment(dashboardFragment)
                R.id.menu_restaurant-> replaceFragment(restaurantFragment)
                R.id.menu_calender-> replaceFragment(calenderFragment)
                R.id.menu_setting -> replaceFragment(settingFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

      }

