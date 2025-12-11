package com.example.gonceng

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

class DetailPesananMobil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_pesanan_mobil)
        val button_pesan : Button = findViewById<Button>(R.id.button_pesan)

        val lokasi_tujuan : TextView = findViewById<TextView>(R.id.text_data_lokasi_tujuan)

        val data_lokasi_tujuan = intent.getStringExtra("data_lokasi_tujuan")

        val back_button : ImageView = findViewById<ImageView>(R.id.back_button)


        lokasi_tujuan.text = data_lokasi_tujuan

        button_pesan.setOnClickListener {
            val intent = Intent(this, PesananBerhasilDibuat::class.java)
            startActivity(intent)
        }

        back_button.setOnClickListener {
            val intent = Intent(this, InputLokasiMobil::class.java)
            startActivity(intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}