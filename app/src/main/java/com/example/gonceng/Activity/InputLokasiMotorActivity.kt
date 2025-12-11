package com.example.gonceng.Activity

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
import com.example.gonceng.Fragment.HomeFragment
import com.example.gonceng.R
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class InputLokasiMotorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_lokasi_motor)
//      inisialisasi variable layout
        val button_pilih : Button = findViewById<Button>(R.id.button_pilih)

        val input_lokasi : EditText = findViewById<EditText>(R.id.input_lokasi_tujuan)

        val back_button : ImageView = findViewById<ImageView>(R.id.back_button)
        button_pilih.setOnClickListener {
//      digunakan untuk inisialisasi variable intent meenuju ke detail pesanan
            val intent = Intent(this, DetailPesananMotorActivity::class.java)
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
//      back button untuk mengembalikan ke halaman sebelumnay atau lompat ke halaman sebelumnya
        back_button.setOnClickListener {
            finish()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

}