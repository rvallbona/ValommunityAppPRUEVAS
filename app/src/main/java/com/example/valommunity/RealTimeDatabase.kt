package com.example.valommunity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.valommunity.databinding.ActivityRealTimeDatabaseBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RealTimeDatabase : AppCompatActivity() {

    private lateinit var binding: ActivityRealTimeDatabaseBinding
    private lateinit var database: DatabaseReference
    private val publications: ArrayList<Publication> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRealTimeDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Firebase.database("https://realtimedatabase-27494-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("publications")

        binding.submitButton.setOnClickListener{
            val titlePublication = binding.titleInput.text.toString()
            val messagePublication = binding.messageInput.text.toString()

            val publication = Publication (titlePublication)
            publication.messages.add(messagePublication)
            publications.add(publication)

            database.child(publication.id)
                .setValue(publication)

            database.child(publication.id).addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val c = snapshot.getValue(Publication::class.java)
                    Toast.makeText(this@RealTimeDatabase, "${c?.messages}", Toast.LENGTH_SHORT).show()
                }
                override fun onCancelled(error: DatabaseError) = Unit
            })
        }
    }
}