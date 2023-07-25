package com.bayutb.core.data

import com.bayutb.core.data.source.local.LocalDataSource
import com.bayutb.core.data.source.remote.RemoteDataSource
import com.bayutb.core.data.source.remote.network.ApiResponse
import com.bayutb.core.data.source.remote.response.ProductsResponse
import com.bayutb.core.domain.model.Product
import com.bayutb.core.domain.repository.IProductRepository
import com.bayutb.core.utils.ListMapper
import com.bayutb.core.utils.MyExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val myExecutors: MyExecutors
): IProductRepository {
    override fun getAllProduct(): Flow<Resource<List<Product>>> {
        return object : com.bayutb.core.data.NetworkBoundResource<List<Product>, List<ProductsResponse>>() {
            override fun loadFromDB(): Flow<List<Product>> {
                return localDataSource.getAllProduct().map {
                    ListMapper.mapEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductsResponse>>> {
                return remoteDataSource.getProducts()
            }

            override suspend fun saveCall(data: List<ProductsResponse>) {
                val entity = ListMapper.mapResponseToEntity(data)
                localDataSource.insertProduct(entity)
            }

            override fun shouldFetch(data: List<Product>?): Boolean {
                return true
            }

        }.asFlow()
    }

    override fun getFavouriteProduct(): Flow<List<Product>> {
        return localDataSource.getFavouriteProduct().map {
            ListMapper.mapEntityToDomain(it)
        }
    }

    override fun setFavourite(product: Product, state: Boolean) {
        val entity = ListMapper.mapDomainToEntity(product)
        myExecutors.diskIO().execute {
            localDataSource.setFavourite(entity, state)
        }
    }

}