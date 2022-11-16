package com.example.wallionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.wallionary.databinding.ActivityFinalWallpaperBinding
import com.example.wallionary.databinding.ActivityMainBinding

class FinalWallpaper : AppCompatActivity() {

    lateinit var binding: ActivityFinalWallpaperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("link")

        binding.imageView3
        Glide.with(this).load(url).into(binding.imageView3)

        binding.setWallBtn.setOnClickListener {

        }

        binding.downloadBtn.setOnClickListener {

        }

    }
}