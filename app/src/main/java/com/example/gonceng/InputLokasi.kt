package com.example.gonceng

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import java.util.prefs.Preferences

class InputLokasi : AppCompatActivity() {
//balajar lateinit
    private final lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val ctx = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        setContentView(R.layout.activity_input_lokasi)

        mapView = findViewById(R.id.maps_views)

        mapView.setBuiltInZoomControls(false)
        mapView.setMultiTouchControls(true)

        val mapController = mapView.controller
        mapController.setZoom(13.2)
        val startPoint = GeoPoint(-7.8821, 111.5306)
        mapController.setCenter(startPoint)



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