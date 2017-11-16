package com.egco428.map

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(15.0, 100.0), 8f))
        //mMap.addMarker(MarkerOptions().position(LatLng(13.7934, 100.3225)).title("Mahidol University"))
        mMap.setOnMapClickListener {
            LatLng -> mMap.animateCamera(CameraUpdateFactory.newLatLng(LatLng))
        }
        mMap.setOnMapClickListener {
            LatLng -> mMap.addMarker(MarkerOptions().position(LatLng).title(LatLng.toString()))
        }
        mMap.addMarker(MarkerOptions()
                .position(LatLng(15.55234, 100.0))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Blue Marker")
        )
        mMap.addMarker(MarkerOptions()
                .position(LatLng(13.794483, 100.323351))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mu))
                .title("Custome Marker")
        )
        val line = mMap.addPolyline(PolylineOptions()
                .add(LatLng(13.7934, 100.3225), LatLng(15.55234, 100.0), LatLng(15.55234, 100.6))
                .width(9f)
                .color(Color.RED)
        )
//        val polygon = mMap.addPolygon(PolygonOptions()
//                .add(LatLng(13.7934, 100.3225), LatLng(13.7934, 99.5), LatLng(13.3, 99.5))
//                .strokeColor(Color.DKGRAY)
//                .fillColor(Color.YELLOW)
//        )
    }
}
