package com.bayutb.myshopapp.screen.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bayutb.myshopapp.R
import com.bayutb.myshopapp.databinding.ActivityHomeBinding
import com.bayutb.myshopapp.screen.favourite.FavouriteActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val test = homeViewModel.test
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