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
    private val list: List<HistoryItem>
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = list[position]

        holder.itemView.findViewById<TextView>(R.id.tvDistance).text = item.distance
        holder.itemView.findViewById<TextView>(R.id.tvRoute).text = item.route
        holder.itemView.findViewById<ImageView>(R.id.imgVehicle).setImageResource(item.vehicleRes)
    }

    override fun getItemCount(): Int = list.size
}