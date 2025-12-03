package com.example.gonceng

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView


class ChatAdapter(private val list: List<ChatItem>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)

        return ChatViewHolder(view)
    }


    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = list[position]

        holder.itemView.findViewById<ImageView>(R.id.imgProfile)
            .setImageResource(item.profileRes)
        holder.itemView.findViewById<TextView>(R.id.tvDriverName).text = item.name
        holder.itemView.findViewById<TextView>(R.id.tvLastMessage).text = item.lastMessage
        holder.itemView.findViewById<TextView>(R.id.tvChatTime).text = item.time
    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}