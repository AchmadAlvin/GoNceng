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
import com.example.gonceng.Model.FoodItem
import com.example.gonceng.OrderDetailFood
import com.example.gonceng.R

class FoodActivity : AppCompatActivity() {

    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<FoodItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food)

        // Membuat variable untuk mencari view pada layout dengan tipe dan idnya
        val btnBack = findViewById<CardView>(R.id.btnBack)
        val rvFood = findViewById<RecyclerView>(R.id.rvFood)
        val etSearch = findViewById<EditText>(R.id.etSearch)

        // object dari variable yang telah dibuat dan menggunakan fungsi setOnclickListener
        btnBack.setOnClickListener {

            // digunakan untuk menutup activity yang sedang aktif
            finish()
        }

        // membuat list dari objek FoodItem yang akan ditampilkan di RecyclerView
        foodList = listOf(
            FoodItem("Mi Ayam Sleko", "Diantar dalam 10-20 min • 0.5 km", R.drawable.mi_ayam),
            FoodItem("Aneka Pecel Bu Yem", "Diantar dalam 15-25 min • 1.2 km", R.drawable.pecel),
            FoodItem("Sate Gule Siti", "Diantar dalam 20-30 min • 2.0 km", R.drawable.sate),
            FoodItem("Es Teh Kendil", "Diantar dalam 5-10 min • 0.2 km", R.drawable.es_teh),
            FoodItem("Mi Ayam Pak Bas", "Diantar dalam 15-25 min • 1.5 km", R.drawable.mi_ayam2),
            FoodItem("Geprek Masbro", "Diantar dalam 15-25 min • 1.0 km", R.drawable.geprek),
            FoodItem("Roti Bakar Suherman", "Diantar dalam 20-40 min • 3.0 km", R.drawable.rotibakar),
            FoodItem("Kopi Pinggiran", "Diantar dalam 10-15 min • 0.8 km", R.drawable.kopi)
        )

        // adapter untuk menghubungkan data ke RecyclerView, FoodAdapter adalah kelas adapter yang digunakan untuk menampilkan daftar makanan
        adapter = FoodAdapter(foodList) { food -> //food adalah objek yang diklik

            // Membuat variable intent yang memanggil konstruktor Intent
            val intent = Intent(this, OrderDetailFood::class.java)

            // menambahkan data ke intent yang akan dikirim ke OrderDetailFood
            intent.putExtra("foodName", food.name)
            intent.putExtra("foodImage", food.imageResId)

            // memulai OrderDetailFood dengan membawa data intent yang telah diatur
            startActivity(intent)

        }

        // mengatur layout manager dan adapter untuk RecyclerView, LinearLayoutManager digunakan untuk menampilkan item secara vertikal
        rvFood.layoutManager = LinearLayoutManager(this)
        // mengatur adapter untuk RecyclerView, FoodAdapter yang telah diatur sebelumnya
        rvFood.adapter = adapter

        // addTextChangedListener digunakan untuk mengetahui perubahan teks di EditText
        // menambahkan TextWatcher untuk menangani perubahan teks di EditText
        etSearch.addTextChangedListener(object : TextWatcher {

            // sebuah fungsi yang dipanggil sebelum teks berubah
            // s merupakan parameter dari teks yang akan diubah
            // CharSequence? merupakan tipe data yang digunakan untuk merepresentasikan urutan karakter
            // start merupakan indeks awal dari teks yang akan diubah
            // count merupakan jumlah karakter yang akan diubah
            // after merupakan jumlah karakter yang akan ditambahkan
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            // sebuah fungsi yang dipanggil ketika teks berubah
            // before merupakan jumlah karakter yang akan dihapus
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Memanggil fungsi filterData dengan parameter yang sesuai
                filterData(s.toString())
            }

            // sebuah fungsi yang dipanggil setelah teks berubah
            // Editable? merupakan tipe data yang digunakan untuk merepresentasikan urutan karakter yang dapat diubah
            override fun afterTextChanged(s: Editable?) {}
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Fungsi ini digunakan untuk melakukan filtering data berdasarkan query yang dimasukkan ke EditText
    // query merupakan teks yang dimasukkan ke EditText dengan tipe String
    private fun filterData(query: String) {

        // Jika query kosong, maka akan menampilkan semua data dari foodList
        // Jika query tidak kosong, maka akan menampilkan data yang sesuai dengan query
        val filteredList = if (query.isEmpty()) {
            foodList
        } else {
            foodList.filter { food ->
                food.name.contains(query, ignoreCase = true)
            }
        }

        // Mengupdate data yang ditampilkan di RecyclerView dengan data yang telah difilter
        adapter.updateData(filteredList)
    }
}