package com.example.gonceng.Activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
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

    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<FoodItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food)

        val btnBack = findViewById<CardView>(R.id.btnBack)
        val rvFood = findViewById<RecyclerView>(R.id.rvFood)
        val etSearch = findViewById<EditText>(R.id.etSearch)

        btnBack.setOnClickListener {
            finish()
        }

        // Initialize Data
        foodList = listOf(
            FoodItem(
                name = "Ayam Geprek Masbro",
                details = "Diantar dalam 15-25 min • 1.0 km",
                imageResId = R.drawable.geprek
            ),
            FoodItem(
                name = "Mie Ayam Pak Bas",
                details = "Diantar dalam 15-25 min • 0.5 km",
                imageResId = R.drawable.mi_ayam
            ),
             FoodItem(
                name = "Sate Gule Siti",
                details = "Diantar dalam 20-30 min • 2.0 km",
                imageResId = R.drawable.sate
            ),
            FoodItem(
                name = "Es Teh Kendil",
                details = "Diantar dalam 5-10 min • 0.2 km",
                imageResId = R.drawable.es_teh
            ),
             FoodItem(
                name = "Mi Ayam Sleko",
                details = "Diantar dalam 10-20 min • 0.5 km",
                imageResId = R.drawable.mi_ayam
            ),
            FoodItem(
                name = "Aneka Pecel Bu Yem",
                details = "Diantar dalam 15-25 min • 1.2 km",
                imageResId = R.drawable.pecel
            )
        )

        // Initialize Adapter
        adapter = FoodAdapter(foodList) { food ->
            val intent = Intent(this, DetailFood::class.java)
            startActivity(intent)
        }

        // Set RecyclerView
        rvFood.layoutManager = LinearLayoutManager(this)
        rvFood.adapter = adapter

        // Search Listener
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun filterData(query: String) {
        val filteredList = if (query.isEmpty()) {
            foodList
        } else {
            foodList.filter { food ->
                food.name.contains(query, ignoreCase = true)
            }
        }
        adapter.updateData(filteredList)
    }
}