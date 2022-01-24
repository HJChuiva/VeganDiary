package com.example.vegandiary

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val seoul = LatLng(37.5663,126.9)

        // 마커 아이콘 만들기
        val descriptor = getDescriptorFromDrawable(R.drawable.marker)

        // 마커
        mMap.addMarker(MarkerOptions()
                .position(seoul)
                .title("현재 위치")
                .icon(descriptor))

        // 카메라의 위치
        var cameraOption = CameraPosition.Builder()
                .target(seoul)
                .zoom(12f) // zoom in
                .build()
        var camera = CameraUpdateFactory.newCameraPosition(cameraOption)

        mMap.moveCamera(camera)
    }

    fun getDescriptorFromDrawable(drawableId : Int) : BitmapDescriptor {
        var bitmapDrawable:BitmapDrawable
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            bitmapDrawable = getDrawable(drawableId) as BitmapDrawable
        }else{
            bitmapDrawable = resources.getDrawable(drawableId) as BitmapDrawable
        }
        // 마커 크기 변환
        val scaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.bitmap, 100, 100, false)
        return BitmapDescriptorFactory.fromBitmap(scaledBitmap)
    }
}