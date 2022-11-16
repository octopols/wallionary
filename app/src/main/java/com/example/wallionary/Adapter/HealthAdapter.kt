package com.example.wallionary.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallionary.Model.HealthModel
import com.example.wallionary.R

class HealthAdapter(val requireContext: Context, val listHealth: ArrayList<HealthModel>) : RecyclerView.Adapter<HealthAdapter.healthViewHolder>() {

    inner class healthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.health_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): healthViewHolder {
        return healthViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_health, parent, false)
        )
    }

    override fun onBindViewHolder(holder: healthViewHolder, position: Int) {
        Glide.with(requireContext).load(listHealth[position].link).into(holder.imageView);
    }

    override fun getItemCount() = listHealth.size

}