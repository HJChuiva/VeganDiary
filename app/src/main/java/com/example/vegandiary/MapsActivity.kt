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
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION )
    val PERM_FLAG = 99

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        if(isPermitted()){
            startProcess()
        }else{
            // 권한 요청
            ActivityCompat.requestPermissions(this, permissions, PERM_FLAG)
        }
    }

    // 권한 체크
    fun isPermitted() : Boolean {
        for(perm in permissions){
            if (ContextCompat.checkSelfPermission(this, perm) != PERMISSION_GRANTED){
                return false
            }
        }
        return true
    }

    // 사용 요청
    fun startProcess(){
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setUpdateLocationListener()
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

    // 내 위치를 가져오는 코드
    lateinit var fusedLocationClient:FusedLocationProviderClient
    lateinit var locationCallback:LocationCallback

    @SuppressLint("MissingPermission")
    fun setUpdateLocationListener(){
        val locationRequest = LocationRequest.create()
        locationRequest.run{
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY // 정확도 높게
            interval = 1000 // 1초에 한번씩 요청
        }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.let{
                    for((i, location) in it.locations.withIndex()){
                        Log.d("로케이션", "$i ${location.latitude}, ${location.longitude}")
                        setLastLocation(location)
                    }
                }
            }
        }

        // 로케이션 요청 함수 호출 (locationRequest, locationCallback)
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())

    }

    fun setLastLocation(location : Location){

        // 현재 나의 위치
        val myLocation = LatLng(location.latitude, location.longitude)

        // 마커 아이콘 만들기
        val descriptor = getDescriptorFromDrawable(R.drawable.marker)

        // 마커
        val marker = MarkerOptions()
            .position(myLocation)
            .title("현재 위치")
            .icon(descriptor)

        // 카메라의 위치
        val cameraOption = CameraPosition.Builder()
            .target(myLocation)
            .zoom(15.0f) // zoom in
            .build()
        val camera = CameraUpdateFactory.newCameraPosition(cameraOption)

        mMap.clear() // 이전 마커 삭제
        mMap.addMarker(marker)
        mMap.moveCamera(camera)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            PERM_FLAG -> {
                var check = true
                for(grant in grantResults){
                    if(grant != PERMISSION_GRANTED){
                        check = false
                        break
                    }
                }
                if(check){
                    startProcess()
                }else{
                    Toast.makeText(this,"권한을 승인해야 앱을 사용할 수 있습니다", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}