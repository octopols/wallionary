package com.example.wallionary.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.wallionary.Model.TechModel
import com.example.wallionary.R

class TechnologyAdapter(val requireContext: Context,val listTech: ArrayList<TechModel>) : RecyclerView.Adapter<TechnologyAdapter.techViewHolder>() {
    inner class techViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView=itemView.findViewById<ImageView>(R.id.tech_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): techViewHolder {
        return techViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_tech, parent, false)
        )
    }

    override fun onBindViewHolder(holder: techViewHolder, position: Int) {
        holder.imageView

        Glide.with(requireContext).load(listTech[position].link).into(holder.imageView)
    }

    override fun getItemCount() = listTech.size
}