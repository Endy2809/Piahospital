package com.example.login2

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class APIActivity : AppCompatActivity() {

    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apiactivity)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return@OnMapReadyCallback
            }
            googleMap.isMyLocationEnabled = true

            val location1 = LatLng(233526.6, 464212.3)
            googleMap.addMarker(MarkerOptions().position(location1).title("Hospital Sao Luiz Morumbi"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 5f))

            val location2 = LatLng(233529.9, 463821.1)
            googleMap.addMarker(MarkerOptions().position(location2).title("Hospital Albert Einstein"))
        })





        val espera = findViewById<Button>(R.id.tempEspera)

        espera.setOnClickListener {
            setContentView(R.layout.activity_espera)
        }
    }
}