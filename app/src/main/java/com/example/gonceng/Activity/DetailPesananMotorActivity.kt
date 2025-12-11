package com.example.gonceng.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gonceng.Fragment.HomeFragment
import com.example.gonceng.PesananBerhasilDibuat
import com.example.gonceng.R

class DetailPesananMotorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_pesanan_motor)
//      inisialisasi variable layout

        val buttob_pesan : Button = findViewById<Button>(R.id.button_pesan)

        val lokasi_tujuan : TextView = findViewById<TextView>(R.id.text_data_lokasi_tujuan)

        val back_button : ImageView = findViewById<ImageView>(R.id.back_button)
//      mengambil daat dari halama sebelumnya yakni input lokasi menggunnakan intet.get... dan parameter dari key di input bisa lihat  di halaman input
        val data_lokasi_tujuan = intent.getStringExtra("data_lokasi_tujuan")
//      mengubah text view denagn text yang diinput oleh user
        lokasi_tujuan.text = data_lokasi_tujuan
//      button pea untuk lompat ke halaman pesana telah berhasil dibuat
        buttob_pesan.setOnClickListener {
            val intent = Intent(this, PesananBerhasilDibuat::class.java)
            startActivity(intent)
        }
//      button back untuk kembali ke halaman sebelumnya dengan  intent
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