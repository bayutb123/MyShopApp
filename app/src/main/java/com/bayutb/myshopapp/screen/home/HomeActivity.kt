package com.bayutb.myshopapp.screen.home

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bayutb.myshopapp.R
import com.bayutb.myshopapp.core.data.Resource
import com.bayutb.myshopapp.core.domain.model.Product
import com.bayutb.myshopapp.core.ui.ProductAdapter
import com.bayutb.myshopapp.databinding.ActivityHomeBinding
import com.bayutb.myshopapp.screen.detail.DetailActivity
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
                adapter = initAdapter()
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