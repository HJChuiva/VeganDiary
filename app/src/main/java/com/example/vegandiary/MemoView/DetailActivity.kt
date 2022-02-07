package com.example.vegandiary.MemoView

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.vegandiary.R
import com.example.vegandiary.MemoDB.MemoDb
import kotlinx.android.synthetic.main.activity_detail.*
import java.time.LocalDate

class DetailActivity : AppCompatActivity() {

    //메모 상세페이지 화면 액티비티
    //전역변수로 선언
    private var memoDb: MemoDb? = null
    private var contents: String? = null
    var title: String? = null
    @RequiresApi(Build.VERSION_CODES.O)
    val time: LocalDate = LocalDate.now()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        memoDb = MemoDb.getInstance(this)
        contents = intent.getStringExtra("content")
        title = intent.getStringExtra("title")

        watch_edit_content.setMovementMethod(ScrollingMovementMethod()) //텍스트뷰 내에서 스크롤가능하게 해줌
        watch_edit_title.text = title
        watch_edit_content.text = contents

        delBtn.setOnClickListener {//Delete버튼 클릭시
            showDialog() //showDialog함수 실행
        }
    }

    // 다이얼로그창을 보여주는 함수
    private fun showDialog() {

        val delRunnable = Runnable { // delRunnable 쓰레드 제작
            memoDb?.MemoDao()
                ?.delete(title + "", contents + "") //OnClickListener에서 delRunnable쓰레드로 이동
        }

        // 삭제 경고 문구
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("삭제")
            .setMessage("정말 삭제하시겠습니까? \n" + "한번 삭제하면 복구 할 수 없습니다")
            .setPositiveButton("삭제") { dialog, which -> //다이얼로그창에서 삭제버튼을 눌렀을 시 행동
                Thread(delRunnable).start() // delRunnable쓰레드 시작
                var intent = Intent(this, MemoActivity::class.java) //삭제 후 메인으로 이동
                startActivity(intent)
                finish()
            }
            .setNeutralButton("취소", null) //취소버튼 설정
            .create()

        alertDialog.show()
    }
}