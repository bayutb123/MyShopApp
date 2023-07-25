package com.bayutb.myshopapp.screen.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bayutb.core.data.Resource
import com.bayutb.core.ui.ProductAdapter
import com.bayutb.myshopapp.R
import com.bayutb.myshopapp.databinding.ActivityHomeBinding
import com.bayutb.myshopapp.screen.detail.DetailActivity
import com.bayutb.myshopapp.screen.favourite.FavouriteActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productAdapter = initAdapter()

        homeViewModel.products.observe(this) { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                        binding.progressCircular.visibility = View.VISIBLE
                        binding.tvErrorMsg.visibility = View.GONE
                    }
                    is Resource.Success -> {
                        binding.progressCircular.visibility = View.GONE
                        binding.tvErrorMsg.visibility = View.GONE
                        productAdapter.updateData(data.data)
                    }
                    is Resource.Error -> {
                        binding.progressCircular.visibility = View.GONE
                        binding.tvErrorMsg.visibility = View.VISIBLE
                    }
                }
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