package com.example.gonceng.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.gonceng.Activity.FoodActivity
import com.example.gonceng.InputLokasiMobil
import com.example.gonceng.InputLokasiMotor
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

        //hmm.. pake image apa card?
        val button_mobil : ImageView = view.findViewById(R.id.gambar_mobil)

        val button_motor : ImageView = view.findViewById(R.id.gambar_motor)

        button_mobil.setOnClickListener {
            val intent = Intent(requireContext(), InputLokasiMobil::class.java)
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

    }
}