package com.example.gonceng.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gonceng.Model.FoodItem
import com.example.gonceng.R

class FoodAdapter(

    // menerima daftar makanan dan fungsi onItemClick untuk menangani klik item
    private var foodList: List<FoodItem>,
    private val onItemClick: (FoodItem) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    // digunakan untuk mengelola tampilan item makanan dan menyimpan referensi ke objek-objek di dalamnya
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Inisialisasi object dari layout menggunakan findViewById untuk setiap item
        val imgFood: ImageView = itemView.findViewById(R.id.imgFood)
        val tvFoodName: TextView = itemView.findViewById(R.id.tvFoodName)
        val tvFoodDetails: TextView = itemView.findViewById(R.id.tvFoodDetails)
    }

    // Membuat ViewHolder baru untuk item makanan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        // Membuat view baru dari layout item_food.xml
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        // Mengembalikan ViewHolder baru dengan view yang telah diatur
        return FoodViewHolder(view)
    }

    // Mengisi data makanan ke dalam ViewHolder
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        // Mengambil data makanan dari daftar berdasarkan posisinya
        val food = foodList[position]

        // holder digunakan untuk mengakses dan mengisi data makanan ke dalam tampilan yang sesuai
        holder.imgFood.setImageResource(food.imageResId)
        holder.tvFoodName.text = food.name
        holder.tvFoodDetails.text = food.details

        // Menambahkan event listener untuk setiap item makanan
        holder.itemView.setOnClickListener {

            // Memanggil fungsi onItemClick ketika item makanan diklik dan mengirimkan data makanan
            onItemClick(food)
        }
    }

    // Mengembalikan jumlah item dalam daftar makanan
    override fun getItemCount(): Int = foodList.size
}
