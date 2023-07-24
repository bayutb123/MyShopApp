package com.bayutb.myshopapp.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bayutb.myshopapp.R
import com.bayutb.myshopapp.core.domain.model.Product
import com.bayutb.myshopapp.core.utils.convertToCurrency
import com.bayutb.myshopapp.databinding.ProductItemBinding
import com.bumptech.glide.Glide

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var products = ArrayList<Product>()
    var onClick : ((Product) -> Unit)?= null

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<Product>?)  {
        if (newData == null) return
        products.clear()
        products.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val data = products[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ProductItemBinding.bind(item)

        fun bind(data: Product) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(binding.ivProduct)
                tvTitle.text = data.title
                tvPrice.text = convertToCurrency(data.price)
            }
        }

        init {

            binding.root.setOnClickListener {
                onClick?.invoke(products[adapterPosition])
            }

        }
    }
}