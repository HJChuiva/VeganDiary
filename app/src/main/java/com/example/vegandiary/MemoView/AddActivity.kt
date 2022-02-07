package com.example.vegandiary.MemoView


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.vegandiary.R
import com.example.vegandiary.MemoDB.Memo
import com.example.vegandiary.MemoDB.MemoDb
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add.edit_title

class AddActivity : AppCompatActivity() {

    //메모 추가 액티비티
    private var memoDB: MemoDb? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        memoDB = MemoDb.getInstance(this)

        //값 삽입
        val addRunnable = Runnable {
            val newMemo = Memo()
            newMemo.title = edit_title.text.toString()
            newMemo.content = edit_content.text.toString()
            memoDB?.MemoDao()?.insert(newMemo)
        }
        //float 버튼 클릭 이벤트
        add_text_btn.setOnClickListener {

            if (edit_title.text.isNullOrBlank()) {
                showDialog()
            } else {
                val addThread = Thread(addRunnable)
                addThread.start()
                val i = Intent(this, MemoActivity::class.java)      //memoActivity 호출
                startActivity(i)
                finish()
            }
        }
    }

    //화면을 메모리에서 없앰
    override fun onDestroy() {
        MemoDb.destroyInstance()
        super.onDestroy()
    }
    //경고메세지 출력 함수
    private fun showDialog() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("경고")
            .setMessage("제목이 입력되지 않았습니다!")
            .setPositiveButton("확인", null)
            .create()

        alertDialog.show()
    }
}