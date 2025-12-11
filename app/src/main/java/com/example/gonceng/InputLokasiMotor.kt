package com.example.gonceng

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gonceng.Fragment.HomeFragment
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class InputLokasiMotor : AppCompatActivity() {
    private final lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val ctx = applicationContext
        org.osmdroid.config.Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        setContentView(R.layout.activity_input_lokasi_motor)

        val button_pilih : Button = findViewById<Button>(R.id.button_pilih)

        val input_lokasi : EditText = findViewById<EditText>(R.id.input_lokasi_tujuan)

        val back_button : ImageView = findViewById<ImageView>(R.id.back_button)

        mapView = findViewById(R.id.maps_views)

        mapView.setBuiltInZoomControls(false)
        mapView.setMultiTouchControls(true)

        val mapviewcontroller = mapView.controller
        mapviewcontroller.setZoom(13.2)
        val pointstat = GeoPoint(-7.8821, 111.5306)
        mapviewcontroller.setCenter(pointstat)

        val startMarker = Marker(mapView)
        startMarker.position = pointstat
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        startMarker.title = "Lokasi"
        startMarker.icon = resources.getDrawable(R.drawable.lokasi)
        mapView.overlays.add(startMarker)
        mapView.invalidate()
        button_pilih.setOnClickListener {
            val intent = Intent(this, DetailPesananMotor::class.java)
            val inputLokasiConvert = input_lokasi.text.toString()

            if (inputLokasiConvert.isNotEmpty()){
                intent.putExtra("data_lokasi_tujuan", inputLokasiConvert)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan Alamat Tujuan", Toast.LENGTH_SHORT).show()
            }

        }

        back_button.setOnClickListener {
            val intent = Intent(this, HomeFragment::class.java)
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