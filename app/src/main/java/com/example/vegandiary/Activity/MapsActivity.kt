package com.example.vegandiary.Activity

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
import com.example.vegandiary.R
import com.google.android.gms.location.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
    val PERM_FLAG = 99

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        if (isPermitted()) {
            startProcess()
        } else {
            // 권한 요청
            ActivityCompat.requestPermissions(this, permissions, PERM_FLAG)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERM_FLAG -> {
                var check = true
                for (grant in grantResults) {
                    if (grant != PERMISSION_GRANTED) {
                        check = false
                        break
                    }
                }
                if (check) {
                    startProcess()
                } else {
                    Toast.makeText(this, "권한을 승인해야 앱을 사용할 수 있습니다", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }

    // 권한 체크
    fun isPermitted(): Boolean {
        for (perm in permissions) {
            if (ContextCompat.checkSelfPermission(this, perm) != PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    // 사용 요청
    fun startProcess() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setUpdateLocationListener()
    }

    fun getDescriptorFromDrawable(drawableId: Int): BitmapDescriptor {
        var bitmapDrawable: BitmapDrawable
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bitmapDrawable = getDrawable(drawableId) as BitmapDrawable
        } else {
            bitmapDrawable = resources.getDrawable(drawableId) as BitmapDrawable
        }
        // 마커 크기 변환
        val scaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.bitmap, 100, 100, false)
        return BitmapDescriptorFactory.fromBitmap(scaledBitmap)
    }

    // 내 위치를 가져오는 코드
    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var locationCallback: LocationCallback

    @SuppressLint("MissingPermission")
    fun setUpdateLocationListener() {
        val locationRequest = LocationRequest.create()
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY // 정확도 높게
            interval = 1000 // 1초에 한번씩 요청
        }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.let {
                    for ((i, location) in it.locations.withIndex()) {
                        Log.d("로케이션", "$i ${location.latitude}, ${location.longitude}")
                        setLastLocation(location)
                    }
                }
            }
        }

        // 로케이션 요청 함수 호출 (locationRequest, locationCallback)
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.myLooper()
        )

    }

    fun setLastLocation(location: Location) {

        // 현재 나의 위치
        val myLocation = LatLng(location.latitude, location.longitude)


        // 마커 아이콘 만들기
        val descriptor = getDescriptorFromDrawable(R.drawable.marker) // 현재 위치 (RED)
        val descriptor2 = getDescriptorFromDrawable(R.drawable.marker3) // 식당 위치 (BROWN)

        // 현재 위치 마커
        val marker = MarkerOptions()
            .position(myLocation)
            .title("현재 위치")
            .icon(descriptor)

        // 식당 위치 마커
        val marker1 = MarkerOptions()
            .position(LatLng(37.636810098806, 127.066396184056))
            .title("502 세컨즈카페")
            .snippet("양식")
            .icon(descriptor2)

        val marker2 = MarkerOptions()
            .position(LatLng(37.6340522250578, 127.051491429932))
            .title("5길반찬")
            .snippet("한식")
            .icon(descriptor2)

        val marker3 = MarkerOptions()
            .position(LatLng(37.6467024983811, 127.083737077543))
            .title("고향보리밥쌈밥")
            .snippet("한식")
            .icon(descriptor2)

        val marker4 = MarkerOptions()
            .position(LatLng(37.624597796799, 127.07649582856))
            .title("굿피자파스타")
            .snippet("양식")
            .icon(descriptor2)

        val marker5 = MarkerOptions()
            .position(LatLng(37.6511256659606, 127.062638552294))
            .title("권순옥김밥")
            .snippet("한식")
            .icon(descriptor2)

        val marker6 = MarkerOptions()
            .position(LatLng(37.6267450093012, 127.087912442601))
            .title("귀빈반점")
            .snippet("중식")
            .icon(descriptor2)

        val marker7 = MarkerOptions()
            .position(LatLng(37.6558595520912, 127.078489309937))
            .title("까르보네 (중계은행사거리점)")
            .snippet("양식")
            .icon(descriptor2)

        val marker8 = MarkerOptions()
            .position(LatLng(37.6227650416546, 127.060063066786))
            .title("꽃제비칼국수")
            .snippet("한식")
            .icon(descriptor2)

        val marker9 = MarkerOptions()
            .position(LatLng(37.6577670301141, 127.062338304855))
            .title("나빈")
            .snippet("인도/중동")
            .icon(descriptor2)

        val marker10 = MarkerOptions()
            .position(LatLng(37.6524383700379, 127.078501126526))
            .title("닐리 (중계점)")
            .snippet("양식")
            .icon(descriptor2)


        mMap.clear() // 이전 마커 삭제
        mMap.addMarker(marker)  // 현재 위치
        mMap.addMarker(marker1) // 식당 위치
        mMap.addMarker(marker2)
        mMap.addMarker(marker3)
        mMap.addMarker(marker4)
        mMap.addMarker(marker5)
        mMap.addMarker(marker6)
        mMap.addMarker(marker7)
        mMap.addMarker(marker8)
        mMap.addMarker(marker9)
        mMap.addMarker(marker10)

        // 카메라의 위치
        val cameraPosition = CameraPosition.Builder()
            .target(myLocation)
            .zoom(15.0f) // zoom in
            .build()

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)) // 카메라 이동
    }
}
