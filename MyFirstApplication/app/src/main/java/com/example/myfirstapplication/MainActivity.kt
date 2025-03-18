package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var order = Order()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgSb1.setOnClickListener(this)
        binding.imgSb2.setOnClickListener(this)
        binding.imgSb3.setOnClickListener(this)
        binding.imgSb4.setOnClickListener(this)
        binding.imgSb5.setOnClickListener(this)
        binding.imgSb6.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, OrderDetailsView::class.java)
        var productName = ""
        var imageResId = 0

        when (v?.id) {
            R.id.img_sb1 -> {
                productName = "Soy Latte"
                imageResId = R.drawable.sb1
            }
            R.id.img_sb2 -> {
                productName = "Chocco Frappo"
                imageResId = R.drawable.sb2
            }
            R.id.img_sb3 -> {
                productName = "Bottled Americano"
                imageResId = R.drawable.sb3
            }
            R.id.img_sb4 -> {
                productName = "Rainbow Frappo"
                imageResId = R.drawable.sb4
            }
            R.id.img_sb5 -> {
                productName = "Caramel Frappo"
                imageResId = R.drawable.sb5
            }
            R.id.img_sb6 -> {
                productName = "Black Forest Frappo"
                imageResId = R.drawable.sb6
            }
            else -> return
        }

        intent.putExtra("product_name", productName)
        intent.putExtra("image_res_id", imageResId) // Pass image resource ID
        startActivity(intent)
    }
}