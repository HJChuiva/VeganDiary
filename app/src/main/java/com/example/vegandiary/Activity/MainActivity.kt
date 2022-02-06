package com.example.vegandiary.Activity

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.vegandiary.Fragment.*
import com.example.vegandiary.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()   // 메인 화면
    private val restaurantFragment = RestaurantFragment() // 비건 식당 화면
    private val calenderFragment = CalenderFragment()     // 챌린지 화면
    private val settingFragment = SettingFragment()       // 설정 화면

    private val searchFragment = SearchFragment()

    lateinit var bottom_navigation : BottomNavigationView // 메뉴바



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


        val intentRegister = Intent(applicationContext, DashboardActivity::class.java)
        startActivity(intentRegister)
        overridePendingTransition(0, 0); //애니메이션 없애기


       /* bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        replaceFragment(dashboardFragment) // 기본 화면 : dashboardFragment

        // 하단 네비게이션으로 화면 이동
        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                //메뉴 아이콘 선택 -> 화면 전환
                R.id.menu_recipe -> replaceFragment(dashboardFragment)
                R.id.menu_restaurant -> replaceFragment(restaurantFragment)
                R.id.menu_calender -> replaceFragment(calenderFragment)
                R.id.menu_setting -> replaceFragment(settingFragment)
            }
            true
        }
    }

    // 화면 전환
    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction() // 프래그먼트 트랜잭션 시작
            transaction.replace(R.id.fragment_container, fragment) // 프래그먼트 교체
            transaction.commit() //프래그먼트 작동
        }*/
    }
}