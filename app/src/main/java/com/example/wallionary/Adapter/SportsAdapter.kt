package com.example.wallionary.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallionary.Model.SportsModel
import com.example.wallionary.R

class SportsAdapter(val requireContext: Context, val listSports: ArrayList<SportsModel>) : RecyclerView.Adapter<SportsAdapter.sportsViewHolder>() {

    inner class sportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.sports_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sportsViewHolder {
        return sportsViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_sports, parent, false)
        )
    }

    override fun onBindViewHolder(holder: sportsViewHolder, position: Int) {
        Glide.with(requireContext).load(listSports[position].link).into(holder.imageView);
    }

    override fun getItemCount() = listSports.size

}