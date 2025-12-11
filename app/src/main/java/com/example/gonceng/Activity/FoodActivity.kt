package com.example.gonceng.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gonceng.Adapter.FoodAdapter
import com.example.gonceng.DetailFood
import com.example.gonceng.Model.FoodItem
import com.example.gonceng.R

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food)

        val btnBack = findViewById<CardView>(R.id.btnBack)
        val rvFood = findViewById<RecyclerView>(R.id.rvFood)

        btnBack.setOnClickListener {
            finish()
        }

        // data dummy menu
        val foodList = listOf(
            FoodItem(
                name = "Ayam Geprek Masbro",
                details = "Diantar dalam 15-25 min • 1.0 km",
                imageResId = R.drawable.geprek
            ),
            FoodItem(
                name = "Mie Ayam Pak Bas",
                details = "Diantar dalam 15-25 min • 0.5 km",
                imageResId = R.drawable.mi_ayam
            )
        )

        // Adapter
        val adapter = FoodAdapter(foodList) { food ->
            val intent = Intent(this, DetailFood::class.java)
            startActivity(intent)
        }

        // Set RecyclerView
        rvFood.layoutManager = LinearLayoutManager(this)
        rvFood.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}