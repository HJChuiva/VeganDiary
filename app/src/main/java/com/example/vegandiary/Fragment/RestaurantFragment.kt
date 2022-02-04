package com.example.vegandiary.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.vegandiary.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class RestaurantFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mView: MapView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_restaurant, container, false)

        mView = rootView.findViewById(R.id.mv_contactUs_gMap) as MapView
        mView.onCreate(savedInstanceState)
        mView.getMapAsync(this)

        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // 현재 나의 위치
        val myLocation = LatLng(37.654601, 127.060530)
        // 카메라 위치
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15f)) // zoom in

        //마커
        val marker = MarkerOptions()
                .position(myLocation)
                .title("현재 위치")
        //.snippet("노원역입니다.")
        googleMap?.addMarker(marker) //지도에 마커 표시
    }


    override fun onStart() {
        super.onStart()
        mView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mView.onStop()
    }

    override fun onResume() {
        super.onResume()
        mView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mView.onLowMemory()
    }

    override fun onDestroy() {
        mView.onDestroy()
        super.onDestroy()
    }

}

