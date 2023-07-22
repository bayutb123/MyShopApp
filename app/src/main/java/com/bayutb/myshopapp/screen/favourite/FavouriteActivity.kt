package com.bayutb.myshopapp.screen.favourite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bayutb.myshopapp.R
import com.bayutb.myshopapp.databinding.ActivityFavouriteBinding

class FavouriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavouriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}