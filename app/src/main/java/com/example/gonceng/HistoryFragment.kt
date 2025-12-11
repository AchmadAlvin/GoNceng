package com.example.gonceng

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gonceng.HistoryItem
import com.example.gonceng.HistoryAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.rvHistoryList)

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

        rv.adapter = HistoryAdapter(historyList)
        rv.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}