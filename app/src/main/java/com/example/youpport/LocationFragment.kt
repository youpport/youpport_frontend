package com.example.youpport

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class LocationFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mGoogleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SupportMapFragment를 가져옵니다.
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        // 맵이 준비되면 콜백이 호출됩니다.
        mapFragment?.getMapAsync(this)
    }


    //GoogleMap Setting
    override fun onMapReady(map: GoogleMap) {
        mGoogleMap = map
        // 맵 조작 또는 마커 추가 등의 작업 수행
        addMarkers()
    }
    private fun addMarkers() {
        // 각 마커의 좌표와 정보를 정의
        val marker1 = LatLng(37.6540782, 127.0566045)
        val marker2 = LatLng(37.668707, 127.047117)
        val marker3 = LatLng(37.639715, 127.025456)
        val marker4 = LatLng(37.611345, 127.013808)
        val marker5 = LatLng(37.574010, 127.039868)
        val marker6 = LatLng(37.563358, 127.036901)
        val marker7 = LatLng(37.563655, 126.997477)
        val marker8 = LatLng(37.573439, 126.978847)
        val marker9 = LatLng(37.532291, 126.990604)
        val marker10 = LatLng(37.579294, 126.936501)
        val marker11 = LatLng(37.550879, 126.849519)
        val marker12 = LatLng(37.524636, 126.887625)
        val marker13 = LatLng(37.516991, 126.866513)
        val marker14 = LatLng(37.512418, 126.939670)
        val marker15 = LatLng(37.478055, 126.951513)
        val marker16 = LatLng(37.483556, 127.032648)
        val marker17 = LatLng(37.538346, 127.082202)
        val marker18 = LatLng(37.514415, 127.105901)
        val marker19 = LatLng(37.517430, 127.047261)
        val marker20 = LatLng(37.530104, 127.123830)

        // 각 마커를 지도에 추가
        mGoogleMap.addMarker(MarkerOptions().position(marker1).title("노원구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker2).title("도봉구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker3).title("강북구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker4).title("성북구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker5).title("동대문구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker6).title("성동구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker7).title("중구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker8).title("종로구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker9).title("용산구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker10).title("서대문구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker11).title("강서구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker12).title("영등포구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker13).title("양천구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker7).title("동작구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker8).title("관악구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker9).title("서초구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker10).title("광진구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker11).title("송파구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker12).title("강남구청"))
        mGoogleMap.addMarker(MarkerOptions().position(marker13).title("강동구청"))

        // 마커를 모두 포함하는 경계로 카메라 이동
        val builder = LatLngBounds.Builder()
        builder.include(marker1)
        builder.include(marker2)
        builder.include(marker3)
        builder.include(marker4)
        builder.include(marker5)
        builder.include(marker6)
        builder.include(marker7)
        builder.include(marker8)
        builder.include(marker9)
        builder.include(marker10)
        builder.include(marker11)
        builder.include(marker12)
        builder.include(marker13)
        builder.include(marker14)
        builder.include(marker15)
        builder.include(marker16)
        builder.include(marker17)
        builder.include(marker18)
        builder.include(marker19)
        builder.include(marker20)
        val bounds = builder.build()
        val padding = 200 // 마커 주위에 여백 추가
        val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        mGoogleMap.animateCamera(cameraUpdate)
    }

}