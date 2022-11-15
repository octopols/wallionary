package com.example.wallionary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallionary.Adapter.TechnologyAdapter
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

        return binding.root
    }

}