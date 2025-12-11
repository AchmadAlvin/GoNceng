package com.example.gonceng.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gonceng.R

class InputLokasiMobilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_lokasi_mobil)
//      inisialisasi variable layout
        val button_pilih : Button = findViewById<Button>(R.id.button_pilih)

        val inputLokasi : EditText = findViewById<EditText>(R.id.input_lokasi_tujuan)

        val back_button : ImageView = findViewById<ImageView>(R.id.back_button)

        button_pilih.setOnClickListener {
//      inisialisasi intent ke halaman detail pesanan
            val intent = Intent(this, DetailPesananMobilActivity::class.java)
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
//      ini back button untuk pindah ke halaman sebelumnya
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