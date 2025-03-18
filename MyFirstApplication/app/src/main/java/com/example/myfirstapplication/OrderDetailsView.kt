package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapplication.databinding.ActivityOrderDetailsViewBinding

class OrderDetailsView : AppCompatActivity() {
    private lateinit var binding: ActivityOrderDetailsViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOrderDetailsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve product name and image resource ID from intent
        val productName = intent.getStringExtra("product_name")
        val imageResId = intent.getIntExtra("image_res_id", 0)

        // Set the product name in the UI
        binding.txtView.text = "You ordered: $productName"

        // Set the selected beverage image
        if (imageResId != 0) {
            binding.imageView2.setImageResource(imageResId)
        }
    }
}