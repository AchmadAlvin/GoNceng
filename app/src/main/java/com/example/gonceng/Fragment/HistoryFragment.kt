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
    // inisialisasi layout fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    // atur logika tampilan
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // inisialisasi recyclerview
        val rvHistory = view.findViewById<RecyclerView>(R.id.rvHistoryList)

        // create dummy data history
        val historyList = listOf(
            HistoryItem("6 KM", "Kampus Universitas Terbuka Demangan, Taman", R.drawable.motor),
            HistoryItem("7 KM", "Kampus 1 Politeknik Negeri Madiun, Jl Serayu", R.drawable.mobil),
            HistoryItem("1 KM", "ayam Geprek Masbro, Jl. Pahlawan", R.drawable.motor),
            HistoryItem("8 KM", "Universitas Merdeka Madiun, Jl Serayu", R.drawable.mobil),
            HistoryItem("8 KM", "Politeknik Negeri Madiun o Politeknik Negeri Madiun", R.drawable.motor),
            HistoryItem("8 KM", "SMK 8 Madiun, Jl Ahmad Suwardi", R.drawable.mobil),
            HistoryItem("12 KM", "Pasar Besar Madiun Kota, Jl Ringroad", R.drawable.motor),
            HistoryItem("24 KM", "Alun Alun Ponorogo, Jl Cokrominoto", R.drawable.mobil)
        )

        // setup adapter history
        val adapter = HistoryAdapter(historyList)
        // set layout manager dan adapter
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
        rvHistory.adapter = adapter
    }
}