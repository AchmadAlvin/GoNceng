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
import com.example.gonceng.Activity.ProfileActivity
import com.example.gonceng.Adapter.FoodAdapter
import com.example.gonceng.InputLokasiMobil
import com.example.gonceng.InputLokasiMotor
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

        val btnFood : CardView = view.findViewById(R.id.btnFood)
        val btnProfile : CardView = view.findViewById(R.id.cvProfile)
        val button_mobil : ImageView = view.findViewById(R.id.gambar_mobil)
        val button_motor : ImageView = view.findViewById(R.id.gambar_motor)
        val rvFoodNearMe : RecyclerView = view.findViewById(R.id.rvFoodNearMe)

        button_mobil.setOnClickListener {
            val intent = Intent(requireContext(), InputLokasiMobil::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            startActivity(intent)
        }

        button_motor.setOnClickListener {
            val intent = Intent(requireContext(), InputLokasiMotor::class.java)
            startActivity(intent)
        }

        btnFood.setOnClickListener{
            val intent = Intent(requireContext(), FoodActivity::class.java)
            startActivity(intent)
        }

        // Data Dummy untuk HomeFragment
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

        val adapter = FoodAdapter(foodList) { food ->
            val intent = Intent(requireContext(), OrderDetailFood::class.java)
            intent.putExtra("foodName", food.name)
            intent.putExtra("foodImage", food.imageResId)
            startActivity(intent)
        }
        
        rvFoodNearMe.layoutManager = LinearLayoutManager(requireContext())
        rvFoodNearMe.adapter = adapter
    }
}