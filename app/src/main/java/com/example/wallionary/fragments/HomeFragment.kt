package com.example.wallionary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallionary.Adapter.HealthAdapter
import com.example.wallionary.Adapter.SportsAdapter
import com.example.wallionary.Adapter.TechnologyAdapter
import com.example.wallionary.Model.HealthModel
import com.example.wallionary.Model.SportsModel
import com.example.wallionary.Model.TechModel
import com.example.wallionary.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var db: FirebaseFirestore = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        db = FirebaseFirestore.getInstance()

        db.collection("technology").addSnapshotListener { value, error ->
            val listTech = arrayListOf<TechModel>()
            val data = value?.toObjects(TechModel::class.java)
            listTech.addAll(data!!)

            binding.rcvTech.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
            binding.rcvTech.adapter = TechnologyAdapter(requireContext(), listTech)

        }

        db.collection("sports").addSnapshotListener { value, error ->
            val listSports = arrayListOf<SportsModel>()
            val data = value?.toObjects(SportsModel::class.java)
            listSports.addAll(data!!)

            binding.rcvSports.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
            binding.rcvSports.adapter = SportsAdapter(requireContext(), listSports)
        }

        db.collection("health").addSnapshotListener { value, error ->
            val listHealth = arrayListOf<HealthModel>()
            val data = value?.toObjects(HealthModel::class.java)
            listHealth.addAll(data!!)

            binding.rcvHealth.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
            binding.rcvHealth.adapter = HealthAdapter(requireContext(), listHealth)
        }

        return binding.root
    }

}