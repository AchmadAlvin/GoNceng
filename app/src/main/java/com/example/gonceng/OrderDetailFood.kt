package com.example.gonceng

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderDetailFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_detail_food)

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val btnBack = findViewById<android.view.View>(R.id.btnBackDetail)

        val foodName = intent.getStringExtra("foodName")
        val foodImage = intent.getIntExtra("foodImage", 0)

        findViewById<android.widget.TextView>(R.id.tvFoodNameDetail).text = foodName
        findViewById<android.widget.ImageView>(R.id.imgFoodDetail).setImageResource(foodImage)

        btnBack.setOnClickListener {
            finish()
        }

        btnOrder.setOnClickListener {
            val intent = Intent(this, PesananBerhasilDibuat::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}