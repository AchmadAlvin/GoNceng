package com.example.gonceng.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gonceng.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Membuat variabel yang berisi hasil pencarian fragment wadah pada layout berdasarkan ID menjadi NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment

        // Membuat variabel yang menggunakan objek pengontrol navigasi menggunakan navHostFragment untuk mengatur navigasi antar fragment
        val navController = navHostFragment.navController

        // Membuat variabel yang berisi objek BottomNavigationView dari layout
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)

        // menggunakan fungsi setupWithNavController untuk mengatur navigasi antar fragment
        navView.setupWithNavController(navController)
    }
}