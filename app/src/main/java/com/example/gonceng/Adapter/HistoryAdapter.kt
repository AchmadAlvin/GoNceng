package com.example.gonceng.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gonceng.Model.HistoryItem
import com.example.gonceng.R

class HistoryAdapter(
    // list item history
    private val list: List<HistoryItem>
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    // untuk mengelola tampilan item history
    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    // create ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        // inflate layout item_history
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    // bind data history ke view
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        // get data by position
        val item = list[position]

        // set data ke widget
        holder.itemView.findViewById<TextView>(R.id.tvDistance).text = item.distance
        holder.itemView.findViewById<TextView>(R.id.tvRoute).text = item.route
        holder.itemView.findViewById<ImageView>(R.id.imgVehicle).setImageResource(item.vehicleRes)
    }

    // total jumlah item
    override fun getItemCount(): Int = list.size
}