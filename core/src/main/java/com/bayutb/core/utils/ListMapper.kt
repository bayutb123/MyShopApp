package com.bayutb.core.utils

import com.bayutb.core.data.source.local.entity.ProductEntity
import com.bayutb.core.data.source.remote.response.ProductsResponse
import com.bayutb.core.domain.model.Product

object ListMapper {

    fun mapResponseToEntity(input: List<ProductsResponse>): List<ProductEntity> {
        val result = ArrayList<ProductEntity>()
        input.map {
            val data = ProductEntity(
                productId = it.id,
                title = it.title,
                description = it.description,
                price = it.price,
                image = it.thumbnail
            )
            result.add(data)
        }
        return result
    }

    fun mapEntityToDomain(input: List<ProductEntity>) : List<Product> {
        val result = ArrayList<Product>()
        input.map {
            val data = Product(
                id = it.productId,
                title = it.title,
                description = it.description,
                price = it.price,
                image = it.image,
                isFavourite = it.isFavourite
            )
            result.add(data)
        }
        return result
    }

    fun mapDomainToEntity(input : Product) : ProductEntity = ProductEntity(
        productId = input.id,
        title = input.title,
        description = input.description,
        price = input.price,
        image = input.image,
        isFavourite = input.isFavourite,
    )
}