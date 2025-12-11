package com.example.gonceng.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gonceng.Activity.FoodActivity
import com.example.gonceng.Activity.InputLokasiMobilActivity
import com.example.gonceng.Activity.ProfileActivity
import com.example.gonceng.Adapter.FoodAdapter
import com.example.gonceng.Activity.InputLokasiMotorActivity
import com.example.gonceng.Model.FoodItem
import com.example.gonceng.OrderDetailFood
import com.example.gonceng.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi objek-objek UI dari layout menggunakan findViewById
        val btnFood = view.findViewById<CardView>(R.id.btnFood)
        val btnProfile = view.findViewById<CardView>(R.id.cvProfile)
        val button_mobil = view.findViewById<ImageView>(R.id.gambar_mobil)
        val button_motor = view.findViewById<ImageView>(R.id.gambar_motor)
        val rvFoodNearMe = view.findViewById<RecyclerView>(R.id.rvFoodNearMe)

        // membuat event listener untuk setiap object yang telah dibuat
        button_mobil.setOnClickListener {
            val intent = Intent(requireContext(), InputLokasiMobilActivity::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            startActivity(intent)
        }

        button_motor.setOnClickListener {
            val intent = Intent(requireContext(), InputLokasiMotorActivity::class.java)
            startActivity(intent)
        }

        btnFood.setOnClickListener{
            val intent = Intent(requireContext(), FoodActivity::class.java)
            startActivity(intent)
        }

        // Membuat daftar objek FoodItem yang akan ditampilkan di RecyclerView
        val foodList = listOf(
            FoodItem("Mi Ayam Sleko", "Diantar dalam 10-20 min • 0.5 km", R.drawable.mi_ayam),
            FoodItem("Aneka Pecel Bu Yem", "Diantar dalam 15-25 min • 1.2 km", R.drawable.pecel),
            FoodItem("Sate Gule Siti", "Diantar dalam 20-30 min • 2.0 km", R.drawable.sate),
            FoodItem("Es Teh Kendil", "Diantar dalam 5-10 min • 0.2 km", R.drawable.es_teh),
            FoodItem("Mi Ayam Pak Bas", "Diantar dalam 15-25 min • 1.5 km", R.drawable.mi_ayam2),
            FoodItem("Geprek Masbro", "Diantar dalam 15-25 min • 1.0 km", R.drawable.geprek),
            FoodItem("Roti Bakar Suherman", "Diantar dalam 20-40 min • 3.0 km", R.drawable.rotibakar),
            FoodItem("Kopi Pinggiran", "Diantar dalam 10-15 min • 0.8 km", R.drawable.kopi)
        )

        // Membuat adapter untuk RecyclerView dan menghubungkannya dengan data
        val adapter = FoodAdapter(foodList) { food -> // FoodItem yang diklik

            // Membuat intent untuk membuka OrderDetailFood dan mengirimkan data makanan yang dipilih
            val intent = Intent(requireContext(), OrderDetailFood::class.java)

            // Mengirim data makanan yang dipilih ke OrderDetailFood
            intent.putExtra("foodName", food.name)
            intent.putExtra("foodImage", food.imageResId)
            startActivity(intent)
        }

        // Mengatur layout manager dan adapter untuk RecyclerView
        rvFoodNearMe.layoutManager = LinearLayoutManager(requireContext())
        rvFoodNearMe.adapter = adapter
    }
}