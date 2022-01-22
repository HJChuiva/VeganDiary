package com.example.vegandiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {

    var auth : FirebaseAuth? = null

    lateinit var Login_Btn : Button
    lateinit var edit_ID : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Login_Btn = findViewById<Button>(R.id.Login_Btn)
        edit_ID = findViewById<EditText>(R.id.edit_ID)

        Login_Btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java) //화면 전환
            // id가 다음 화면에 보임
            intent.putExtra("User", edit_ID.text.toString()) //key:WMI, value : ed_ID.text
            Toast.makeText(this, "회원가입 완료!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}