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

        // Membuat variable untuk mencari view pada layout dengan tipe dan idnya
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val btnBack = findViewById<android.view.View>(R.id.btnBackDetail)

        // Mengambil data dari intent yang dikirimkan dari FoodActivity
        val foodName = intent.getStringExtra("foodName")
        val foodImage = intent.getIntExtra("foodImage", 0)

        // Menampilkan data di layout
        findViewById<android.widget.TextView>(R.id.tvFoodNameDetail).text = foodName
        findViewById<android.widget.ImageView>(R.id.imgFoodDetail).setImageResource(foodImage)

        // object dari variable yang telah dibuat dan menggunakan fungsi setOnclickListener
        btnBack.setOnClickListener {

            // digunakan untuk menutup activity yang sedang aktif
            finish()
        }

        // object dari variable yang telah dibuat dan menggunakan fungsi setOnclickListener
        btnOrder.setOnClickListener {

            // Membuat variable intent yang memanggil konstruktor Intent
            val intent = Intent(this, PesananBerhasilDibuat::class.java)

            // memulai PesananBerhasilDibuat
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}