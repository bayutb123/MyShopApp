package com.bayutb.myshopapp.screen.favourite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bayutb.myshopapp.core.ui.ProductAdapter
import com.bayutb.myshopapp.databinding.ActivityFavouriteBinding
import com.bayutb.myshopapp.screen.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavouriteBinding
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Favourite"
        val productAdapter = initAdapter()

        favouriteViewModel.favouriteProduct.observe(this) {data ->
            productAdapter.updateData(data)
            binding.progressCircular.visibility = View.GONE
            if (data.isNullOrEmpty()) {
                binding.tvErrorMsg.visibility = View.GONE
            }
            with(binding.rvProduct) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = productAdapter
            }
        }
    }

    private fun initAdapter() : ProductAdapter {
        val adapter = ProductAdapter()
        adapter.onClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA, it)
            startActivity(intent)
        }

        return adapter
    }
}