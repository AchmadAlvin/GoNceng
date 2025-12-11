package com.example.gonceng

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_food)

        val btnBackFood = findViewById<CardView>(R.id.btnBackFood)
        val btnOrderGeprekJuara = findViewById<LinearLayout>(R.id.btnOrderGeprekJuara)

        btnBackFood.setOnClickListener {
            finish()
        }


        btnOrderGeprekJuara.setOnClickListener {
            val intent = Intent(this, OrderDetailFood::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}