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
import com.example.gonceng.PesananBerhasilDibuat
import com.example.gonceng.R

class DetailPesananMobilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_pesanan_mobil)
//      inisilisasi variable layout
        val button_pesan : Button = findViewById<Button>(R.id.button_pesan)

        val lokasi_tujuan : TextView = findViewById<TextView>(R.id.text_data_lokasi_tujuan)

        val back_button : ImageView = findViewById<ImageView>(R.id.back_button)
//      variable yang menagmbil data dari inputlkasi yang putextra parameter yakni key yang ada di input
        val data_lokasi_tujuan = intent.getStringExtra("data_lokasi_tujuan")
//      merubah textview lokasi tujuan menjadi text yang diinpit oleh user
        lokasi_tujuan.text = data_lokasi_tujuan
//      button pessn udah paham
        button_pesan.setOnClickListener {
            val intent = Intent(this, PesananBerhasilDibuat::class.java)
            startActivity(intent)
        }
//      button back udah paham
        back_button.setOnClickListener {
            val intent = Intent(this, InputLokasiMobilActivity::class.java)
            startActivity(intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}