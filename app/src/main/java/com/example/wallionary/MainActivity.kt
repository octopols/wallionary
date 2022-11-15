package com.example.wallionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.wallionary.databinding.ActivityMainBinding
import com.example.wallionary.fragments.HomeFragment
import com.example.wallionary.fragments.LibraryFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.fragmentReplacer(HomeFragment())

        binding.homeButton.setOnClickListener {
            fragmentReplacer(HomeFragment())
        }

        binding.libraryButton.setOnClickListener {
            fragmentReplacer(LibraryFragment())
        }

    }

    private fun fragmentReplacer(fragment:Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentFrame, fragment)
        transaction.commit()
    }

}