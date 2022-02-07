package com.example.vegandiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.vegandiary.R

class SplashScreenActivity : AppCompatActivity() {

    //스플래시 스크린 화면 호출
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler= Handler()
        handler.postDelayed({
            val intent=Intent(this,OnboardingActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
            finish()
        }, 3000)            //3000 시간이 지나면 호출
    }
}