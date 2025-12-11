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

    //balajar lateinit
//  kenapa pakai lateinit karena yang pertama mapview akan digunakan di semua lifecycle maka dari itu diluar on create dan apabila di innisialisai langsung disini itu tidak bisa krena layout xml nggak bisa di inisialisasi di luar life cycle
    private lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//      inisialisasi context aplikas yakni ya halaman aplaikasi ini
        val ctx = applicationContext
//      configurasi osm
        org.osmdroid.config.Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        setContentView(R.layout.activity_input_lokasi_motor)
//      inisialisasi variable layout
        val button_pilih : Button = findViewById<Button>(R.id.button_pilih)

        val input_lokasi : EditText = findViewById<EditText>(R.id.input_lokasi_tujuan)

        val back_button : ImageView = findViewById<ImageView>(R.id.back_button)
//      inisiaslisi mapview tadi yang masih belum ada isinya yang tadi masih lateinit
        mapView = findViewById(R.id.maps_views)
//      menghilangkan ikon zoom kayak - atau + default
        mapView.setBuiltInZoomControls(false)
//      agar bisa nge zoom
        mapView.setMultiTouchControls(true)
//      inisialisasi controller punya map osm
        val mapviewcontroller = mapView.controller
//      digunakan untuk zoom berapa atu besarnya map atau ya gitulah
        mapviewcontroller.setZoom(13.2)
//      digunakan untuk geopoint atau dimananya mapview focusnya  letak deo pakai long dan lat
        val pointstat = GeoPoint(-7.8821, 111.5306)
//      digunakan untuk menengahkan map focus di tengah  dengan geo tadi
        mapviewcontroller.setCenter(pointstat)

//      Marker adalah pin pada map itu
//      inisialisasi marker map
        val startMarker = Marker(mapView)
//      possi untuk markernya
        startMarker.position = pointstat
//      nggak tau untuk apa
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//      kayak alt kalo di web paling
        startMarker.title = "Lokasi"
//      inisialisasi ikon ngambil di drawable
        startMarker.icon = resources.getDrawable(R.drawable.lokasi)
//      untuk menambah markenya
        mapView.overlays.add(startMarker)
//      refresh halaman mapviewnya
        mapView.invalidate()
//      button pilih untuk lompat ke halaman selanjutnya
        button_pilih.setOnClickListener {
//      digunakan untuk inisialisasi variable intent meenuju ke detail pesanan
            val intent = Intent(this, DetailPesananMotor::class.java)
//      mengubah tipe data edit text menjadi string
            val inputLokasiConvert = input_lokasi.text.toString()
//      jika user mengisi edittextnya maka ya isinya akn dijelasin di bawah
            if (inputLokasiConvert.isNotEmpty()){
//      untuk mengirim data menggunan putextra kemudai data_lokasi_tujuan untuk key atau
                intent.putExtra("data_lokasi_tujuan", inputLokasiConvert)
                startActivity(intent)
//      jika tidak maka akan ada oast dengan text yang ada di bawah itu
            } else {
                Toast.makeText(this, "Masukkan Alamat Tujuan", Toast.LENGTH_SHORT).show()
            }

        }
//      back buttn udah tahu ngak usah dijelasin
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
//  inisilisasi mapview di lifecycle nresume
    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }
//  inisialisasi mapview di lifecycle onpause
    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }
}