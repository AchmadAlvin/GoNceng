package com.example.gonceng

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class InputLokasiMotor : AppCompatActivity() {
    private final lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val ctx = applicationContext
        org.osmdroid.config.Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        setContentView(R.layout.activity_input_lokasi_motor)

        val button_pilih : Button = findViewById<Button>(R.id.button_pilih)

        mapView = findViewById(R.id.maps_views)

        mapView.setBuiltInZoomControls(false)
        mapView.setMultiTouchControls(true)

        val mapviewcontroller = mapView.controller
        mapviewcontroller.setZoom(13.2)
        val pointstat = GeoPoint(-7.8821, 111.5306)
        mapviewcontroller.setCenter(pointstat)

        button_pilih.setOnClickListener {
            val intent = Intent(this, DetailPesananMobil::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }
}