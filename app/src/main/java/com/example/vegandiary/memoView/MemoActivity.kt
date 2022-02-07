package com.example.vegandiary.memoView

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vegandiary.Activity.MainActivity
import com.example.vegandiary.Activity.MapsActivity
import com.example.vegandiary.Activity.SettingActivity
import com.example.vegandiary.R
import com.example.vegandiary.db.Memo
import com.example.vegandiary.db.MemoDb
import com.example.vegandiary.db.RcViewAdapter
import kotlinx.android.synthetic.main.activity_memo.*
import java.text.SimpleDateFormat
import java.util.*

class MemoActivity : AppCompatActivity() {

    private var memoDb: MemoDb? = null
    private var memoList = listOf<Memo>()
    private lateinit var memoAdapter: RcViewAdapter
    private var mBackWait: Long = 0

    private val currentDateTime = Calendar.getInstance().time
    private var dateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).format(currentDateTime)

    lateinit var recipe_btn: android.widget.ImageButton
    lateinit var restaurant_btn: android.widget.ImageButton
    lateinit var calendar_btn:android.widget.ImageButton
    lateinit var setting_btn:android.widget.ImageButton

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)

        memoDb = MemoDb.getInstance(this)// Db에 접근을 가능하게 해줌
        memoAdapter = RcViewAdapter(this, memoList)

        recipe_btn =findViewById<android.widget.ImageButton>(R.id.recipe_btn)
        restaurant_btn =findViewById<android.widget.ImageButton>(R.id.restaurant_btn)
        calendar_btn =findViewById<android.widget.ImageButton>(R.id.calendar_btn)
        setting_btn =findViewById<android.widget.ImageButton>(R.id.setting_btn)


        val r = Runnable {
            try {
                Log.d("TAG", "Hello")

                memoList = memoDb?.MemoDao()?.getAll()!!
                memoAdapter =
                        RcViewAdapter(this, memoList)
                memoAdapter.notifyDataSetChanged()

                runOnUiThread { // 일반 쓰레드 -> Main쓰레드가 처리하게 만듬
                    rcView.adapter = memoAdapter
                    rcView.layoutManager = LinearLayoutManager(this)
                    rcView.setHasFixedSize(true) // 아이템이 추가될때마다 사이즈 변형 여부
                }
            } catch (e: Exception) {  //try에서 문제가 발생하면 여기를 실행
                Log.d("tag", "Error - $e") //try에서 문제가 발생하면 로그에 'Error - 에러난 곳'을 출력
            }
        }
        Log.d("TAG", "실행") //try에서 문제가 없을 시 로그에 '실행'을 찍는다
        val thread = Thread(r) //try에서 문제가 없을 시 여기를 실행
        thread.start()

        delBtn.setOnClickListener {//delete버튼을 누를시 행동
            var intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        //하단 메뉴바
        recipe_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        restaurant_btn.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        calendar_btn.setOnClickListener{
            val intent = Intent(this, MemoActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }
        setting_btn.setOnClickListener{
            val intent = Intent(this, SettingActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0); //애니메이션 없애기
        }

    }

    override fun onDestroy() {
        MemoDb.destroyInstance()
        memoDb = null
        super.onDestroy()
    }

    override fun onBackPressed() {
        // 뒤로가기 버튼 클릭
        if (System.currentTimeMillis() - mBackWait >= 1500) {
            mBackWait = System.currentTimeMillis()
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_LONG).show() //토스트 출력
        } else {
            moveTaskToBack(true) //finish후 다른 액티비티가 보여지는것을 방지
            finish() //액티비티 종료
            android.os.Process.killProcess(android.os.Process.myPid()) //앱, 프로세스까지 강제종료
        }
    }

}