package com.example.gonceng.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gonceng.Adapter.ChatAdapter
import com.example.gonceng.ChatDetailActivity
import com.example.gonceng.Model.ChatItem
import com.example.gonceng.R

class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvChat = view.findViewById<RecyclerView>(R.id.rvChatList)

        val chatList = listOf(
            ChatItem("Abdul Driver", "Halo mas, saya sudah sampai", "11.58 AM", R.drawable.profile),
            ChatItem("Budi Santoso", "Oke siap, ditunggu ya", "Yesterday", R.drawable.profile),
            ChatItem("Siti Aminah", "Terima kasih kembali", "Yesterday", R.drawable.profile)
        )

        val adapter = ChatAdapter(chatList) { chat ->
            val intent = Intent(requireContext(), ChatDetailActivity::class.java)
            intent.putExtra("driverName", chat.name)
            intent.putExtra("driverImage", chat.profileRes)
            startActivity(intent)
        }

        rvChat.layoutManager = LinearLayoutManager(requireContext())
        rvChat.adapter = adapter
    }
}