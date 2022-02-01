package com.example.vegandiary.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.vegandiary.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DashboardFragment : Fragment() {

    lateinit var SearchTextButton: Button
    // 뷰가 생성되었을 때
    // 프레그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
        //SearchTextButton = findViewById<Button>(R.id.SearchTextButton)
    }
/*
    lateinit var SearchTextButton: Button
    lateinit var ScrapButton: Button*/


        //SearchTextButton = findViewById<Button>(R.id.SearchTextButton)
        //ScrapButton = findViewById<Button>(R.id.ScrapButton)

        /* SearchTextButton.setOnClickListener {
             val intent = Intent(this, SearchActivity::class.java)
             startActivity(intent)

         }*/

    }



