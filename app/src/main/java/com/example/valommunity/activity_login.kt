package com.example.valommunity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.valommunity.databinding.ActivityMainBinding

class activity_login : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}