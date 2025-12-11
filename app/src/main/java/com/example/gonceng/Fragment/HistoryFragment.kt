package com.example.gonceng.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gonceng.Adapter.HistoryAdapter
import com.example.gonceng.Model.HistoryItem
import com.example.gonceng.R

class HistoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvHistory = view.findViewById<RecyclerView>(R.id.rvHistoryList)

        val historyList = listOf(
            HistoryItem("6 KM", "Politeknik Negeri Madiun o Demangan, Taman", R.drawable.motor),
            HistoryItem("7 KM", "Politeknik Negeri Madiun o Dagangan, dagangan", R.drawable.mobil),
            HistoryItem("1 KM", "Politeknik Negeri Madiun o Universitas Merdeka", R.drawable.motor),
            HistoryItem("8 KM", "Politeknik Negeri Madiun o Universitas PGRI", R.drawable.mobil),
            HistoryItem("8 KM", "Politeknik Negeri Madiun o Politeknik Negeri Madiun", R.drawable.motor),
            HistoryItem("8 KM", "Politeknik Negeri Madiun o SMK 8 Madiun", R.drawable.mobil),
            HistoryItem("12 KM", "Politeknik Negeri Madiun o Pasar Besar", R.drawable.motor),
            HistoryItem("4 KM", "Politeknik Negeri Madiun o Alun-Alun Madiun", R.drawable.mobil)
        )

        val adapter = HistoryAdapter(historyList)
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
        rvHistory.adapter = adapter
    }
}