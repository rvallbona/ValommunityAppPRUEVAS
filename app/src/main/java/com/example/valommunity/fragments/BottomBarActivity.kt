package com.example.valommunity.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.valommunity.FirstFragment
import com.example.valommunity.ImageFragment
import com.example.valommunity.R
import com.example.valommunity.databinding.ActivityBottomBarBinding

class BottomBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val imageFragment = ImageFragment()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.firstButton -> setFragment(firstFragment)
                R.id.secondButton -> setFragment(imageFragment)
            }
            true
        }

        setFragment(firstFragment)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id, fragment)
            commit()
        }
    }
}