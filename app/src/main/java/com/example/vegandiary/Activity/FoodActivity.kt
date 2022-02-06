package com.example.vegandiary.Activity


import androidx.appcompat.app.AppCompatActivity
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.TextView
import com.example.vegandiary.Helper.PlaceDBHelper
import com.example.vegandiary.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class FoodActivity : AppCompatActivity(), OnMapReadyCallback {


    // 지도 조작을 위한 객체.
    private lateinit var mMap: GoogleMap

    // db 객체 선언 및 연결
    lateinit var dbHelper: PlaceDBHelper
    lateinit var sqlDB : SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        dbHelper = PlaceDBHelper(this, "placeDB", null, 1)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        sqlDB = dbHelper.writableDatabase


        // placeTBL : 비건 식당
        var cursor: Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM placeTBL;", null)

        var num: Int = 0

        // cursor를 이용하여 각 컬럼 값 추출
        while (cursor.moveToNext()) {
            var pName = cursor.getString(cursor.getColumnIndex("pName"))
            var pKind = cursor.getString(cursor.getColumnIndex("pKind"))
            // var pStar = cursor.getString(cursor.getColumnIndex("pStar")).toString()
            var lat = cursor.getString(cursor.getColumnIndex("lat"))
            var lng = cursor.getString(cursor.getColumnIndex("lng"))

            var location = LatLng(lat.toDouble(), lng.toDouble()) //위도, 경도

            val markerOptions = MarkerOptions()
                .title(pName)   // 식당 이름
                .snippet(pKind) // 음식 종류
                .position(location)  // 위치

            //핀 추가하면서 나머지 데이터도 미리 저장해 둔다
            val marker: Marker = mMap.addMarker(markerOptions) //핀 추가 및 마커 생성
            marker.tag =  location

            // 해당 마커로 카메라 이동
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14F))


            var str_name = findViewById<TextView>(R.id.name)
            var str_field = findViewById<TextView>(R.id.field)
            var str_location = findViewById<TextView>(R.id.location)

            str_name.setText(cursor.getString(0))
            str_field.text = cursor.getString(1)
            str_location.text = cursor.getString(2)

        }
        num++

        //cursor.close()
        //sqlDB.close()
        //dbHelper.close()

    }
}