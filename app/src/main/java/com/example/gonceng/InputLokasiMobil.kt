package com.example.gonceng

import android.content.Intent
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
import com.example.gonceng.Activity.HomeActivity
import com.example.gonceng.Fragment.HomeFragment
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class InputLokasiMobil : AppCompatActivity() {
//balajar lateinit
//  kenapa pakai lateinit karena yang pertama mapview akan digunakan di semua lifecycle maka dari itu diluar on create dan apabila di innisialisai langsung disini itu tidak bisa krena layout xml nggak bisa di inisialisasi di luar life cycle
    private lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val ctx = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        setContentView(R.layout.activity_input_lokasi_mobil)
//      inisialisasi variable layout
        val button_pilih : Button = findViewById<Button>(R.id.button_pilih)

        val inputLokasi : EditText = findViewById<EditText>(R.id.input_lokasi_tujuan)

        val back_button : ImageView = findViewById<ImageView>(R.id.back_button)

//      inisiaslisi mapview tadi yang masih belum ada isinya
        mapView = findViewById(R.id.maps_views)
//      menghilangkan ikon zoom default
        mapView.setBuiltInZoomControls(false)
//      agar bisa nge zoom
        mapView.setMultiTouchControls(true)
//      inisialisasi controller punya map
        val mapController = mapView.controller
//      digunakan untuk zoom berapa atu besarnya map atau ya gitulah
        mapController.setZoom(13.2)
//      digunakan untuk geopoint atau dimananya mapview focusnya
        val startPoint = GeoPoint(-7.8821, 111.5306)
//      digunakan untuk menengahkan map focus di tengah
        mapController.setCenter(startPoint)
//      Marker adalah pin pada map itu
//      inisialisasi marker map
        val startMarker = Marker(mapView)
//      di posisi mana marker berada di sintaks ini
        startMarker.position = startPoint
//      inni wajib tapi nggak tau untuk apa
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//      ini mungkin kayak alt di web
        startMarker.title = "Lokasi"
//      inisialisasi icon yang dibuat marker
        startMarker.icon = resources.getDrawable(R.drawable.lokasi)
//      ini diguankan untuk menambahkan markernya itu di map
        mapView.overlays.add(startMarker)
//      refresh map
        mapView.invalidate()
//      digunakan untuk button pilih lompat ke halamn selanjutnya
        button_pilih.setOnClickListener {
//      inisialisasi intent ke halaman detail pesanan
            val intent = Intent(this, DetailPesananMobil::class.java)
//      digunakan nutk convert input lokasi dari tipedata edit text ke string
            val inputLokasiConvert = inputLokasi.text.toString()
//      logika jika lokasi tujuan terisi maka lompat ke halaman selanjutnya
            if (inputLokasiConvert.isNotEmpty()){
//      digunakan untuk mengirim data ke halaman intent disini berarti detailpesanan
                intent.putExtra("data_lokasi_tujuan", inputLokasiConvert)
                startActivity(intent)
//      jika tidak maka ada toast yang isi text bisa dilihat sendiri
            } else {
                Toast.makeText(this, "Masukkan Lokasi Tujuan", Toast.LENGTH_SHORT).show()
            }

        }
//      ini back button udah paham
        back_button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
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