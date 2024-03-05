package com.example.assignment_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.assignment_2.R

class Shopping : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping)

        setOnClickListeners();
    }

    @SuppressLint("SetTextI18n")
    private fun setOnClickListeners() {
        val homeAndKitchen: LinearLayout = findViewById(R.id.home_and_kitchen)
        val beauty: LinearLayout = findViewById(R.id.beauty_care)
        val petSupplies: LinearLayout = findViewById(R.id.pet_supplies)
        val toysAndGames: LinearLayout = findViewById(R.id.toys_and_cars)
        val welcomeMessage: TextView = findViewById(R.id.welcome)
        welcomeMessage.text = "Welcome "+Data.user?.name
        homeAndKitchen.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Home and Kitchen Clicked", Toast.LENGTH_SHORT).show()
        })
        beauty.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Beauty Clicked", Toast.LENGTH_SHORT).show()
        })
        petSupplies.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Pet Supplies Clicked", Toast.LENGTH_SHORT).show()
        })
        toysAndGames.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Toys and games Clicked", Toast.LENGTH_SHORT).show()
        })
    }
}