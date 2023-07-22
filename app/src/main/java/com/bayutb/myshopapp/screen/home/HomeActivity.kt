package com.bayutb.myshopapp.screen.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.bayutb.myshopapp.R
import com.bayutb.myshopapp.databinding.ActivityHomeBinding
import com.bayutb.myshopapp.screen.favourite.FavouriteActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_favourite -> {
                Intent(this, FavouriteActivity::class.java).also {
                    startActivity(it)
                }
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

}