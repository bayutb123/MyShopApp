package com.bayutb.myshopapp.screen.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bayutb.core.domain.model.Product
import com.bayutb.core.utils.convertToCurrency
import com.bayutb.myshopapp.R
import com.bayutb.myshopapp.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel by viewModel<DetailViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getParcelableExtra<Product>(DATA)
        if (data != null) {
            showDetail(data)
        }
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    private fun showDetail(data: Product) {
        supportActionBar?.title = data.title
        binding.title.text = data.title
        binding.description.text = data.description
        binding.price.text = convertToCurrency(data.price)
        Glide.with(this)
            .load(data.image)
            .into(binding.ivProduct)
        var status = data.isFavourite
        favouriteStatus(status)
        binding.btnFavourite.setOnClickListener {
            status = !status
            detailViewModel.setFavourite(data, status)
            favouriteStatus(status)
        }
    }

    private fun favouriteStatus(isFavourite: Boolean) {
        if (isFavourite) {
            binding.btnFavourite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24))
        } else {
            binding.btnFavourite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_border_24))
        }
    }

    companion object {
        const val DATA = "data"
    }
}