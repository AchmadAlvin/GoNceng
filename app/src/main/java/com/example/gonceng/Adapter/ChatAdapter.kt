package com.example.gonceng.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gonceng.Model.ChatItem
import com.example.gonceng.R

class ChatAdapter(
    // menerima daftar item chat dan fungsi callback ketika item diklik
    private val list: List<ChatItem>,
    private val onItemClick: (ChatItem) -> Unit
    ) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    // untuk mengelola tampilan item chat
    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    // Membuat ViewHolder baru untuk item chat
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        // Membuat view dari layout item_chat
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)

        return ChatViewHolder(view)
    }


    // Mengikat data chat ke view holder
    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        // Mendapatkan data chat berdasarkan posisi
        val item = list[position]

        // Mengisi data ke dalam view
        holder.itemView.findViewById<ImageView>(R.id.imgProfile)
            .setImageResource(item.profileRes)
        holder.itemView.findViewById<TextView>(R.id.tvDriverName).text = item.name
        holder.itemView.findViewById<TextView>(R.id.tvLastMessage).text = item.lastMessage
        holder.itemView.findViewById<TextView>(R.id.tvChatTime).text = item.time

        // Menangani klik pada item chat
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    // Mengembalikan jumlah item dalam daftar chat
    override fun getItemCount(): Int = list.size
}