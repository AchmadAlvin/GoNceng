package com.example.gonceng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gonceng.Activity.HomeActivity

class PesananBerhasilDibuat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pesanan_berhasil_dibuat)
//      inisialisasi variable layout
        val button_oke : Button = findViewById<Button>(R.id.button_oke)
//      digunakan untuk melompat ke halaman homepage
        button_oke.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
//          seharusnya mergahapus semua tumpukan halaman activity tetapi nggak bisa
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}