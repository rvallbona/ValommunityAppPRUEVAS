package com.example.valommunity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.valommunity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.helloButton.setOnClickListener {
            Toast.makeText(this, "Hola classe", Toast.LENGTH_LONG).show()
        }

        binding.helloText.setOnLongClickListener {
            val snack = Snackbar.make(this, it, "Vols canviar el text?", Snackbar.LENGTH_LONG)
            snack.setAction("Sí") {
                binding.helloText.text = "Text canviat"
            }
            snack.show()

            true
        }
    }
}
