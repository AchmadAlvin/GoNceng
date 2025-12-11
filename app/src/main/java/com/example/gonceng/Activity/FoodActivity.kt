package com.example.gonceng.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gonceng.DetailGeprek
import com.example.gonceng.R

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food)

        val btnBack = findViewById<CardView>(R.id.btnBack)
        val btnGeprek = findViewById<CardView>(R.id.btnGeprek)
        val btnMieAyam = findViewById<CardView>(R.id.btnMieAyam)


        btnBack.setOnClickListener {
            finish()
        }

        btnGeprek.setOnClickListener {
            val intent = Intent(this, DetailGeprek::class.java)
            startActivity(intent)
        }

        btnMieAyam.setOnClickListener {
            val intent = Intent(this, DetailGeprek::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}