package com.example.gonceng.Activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.gonceng.R

class ProfileActivity : AppCompatActivity() {
    // inisialisasi activity dan mengatur layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Menangani event klik back btn
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}