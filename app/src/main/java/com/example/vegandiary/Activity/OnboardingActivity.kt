package com.example.vegandiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.viewpager2.widget.ViewPager2
import com.example.vegandiary.Activity.com.example.vegandiary.Intro.IntroRecyclerAdapter
import com.example.vegandiary.Activity.com.example.vegandiary.Intro.PageItem
import com.example.vegandiary.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {


    lateinit var handler: Handler

    companion object{
        const val TAG: String="로그"
   }

    //데이터 배열 선언
    private var pageItemList=ArrayList<PageItem>()
    //리사이클러뷰 어댑터 선언
    private lateinit var IntroRecyclerAdapter:IntroRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        handler= Handler()

        previous_btn.setOnClickListener{
            my_intro_view_pager.currentItem=my_intro_view_pager.currentItem-1       //previous_btn 클릭했을 때 currentItem 감소, 이전 페이지
        }
        next_btn.setOnClickListener{                                                //next button 클릭했을 때 currentItem 증가, 다음 페이지
            my_intro_view_pager.currentItem=my_intro_view_pager.currentItem+1       //1500 시간 뒤 호출
            if(my_intro_view_pager.currentItem==2)
            {
                handler.postDelayed({
                val intent= Intent(this,LoginActivity::class.java)      //로그인 액티비티 호출
                startActivity(intent)
                    overridePendingTransition(0, 0); //애니메이션 없애기
                    finish()},1500)
            }
        }

        //데이터 배열을 준비
        pageItemList.add(PageItem(R.color.backgroud, R.drawable.intro_1,
            "Get Healthy Recipes",
        "다양한 비건 레시피들을 찾아 나의 것으로 만드세요!"
        ))
        pageItemList.add(PageItem(R.color.backgroud, R.drawable.intro_2,
            "Challenge Vegan Life",
            "비건 관련 습관을 기록합니다!\n" +
                    "나만의 비건 다이어리를 가꾸어보세요"
            ))
        pageItemList.add(PageItem(R.color.backgroud, R.drawable.intro_3,
            "Find Your Vegan Restaurant",
            "당신 주변의 비건 식당을 추천해드립니다!\n" +
                    "건강한 음식을 만나보세요"
            ))

        //어댑터 인스턴스 생성
        IntroRecyclerAdapter=IntroRecyclerAdapter(pageItemList)

        //github에서 받은 인디케이터 소스 사용, 뷰페이저2에 호출
        my_intro_view_pager.apply{
            adapter=IntroRecyclerAdapter
            orientation=ViewPager2.ORIENTATION_HORIZONTAL
            dots_indicator.setViewPager2(this)
        }


    }


}
