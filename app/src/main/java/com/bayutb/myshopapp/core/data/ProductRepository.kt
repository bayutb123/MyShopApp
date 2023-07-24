package com.bayutb.myshopapp.core.data

import com.bayutb.myshopapp.core.data.source.local.LocalDataSource
import com.bayutb.myshopapp.core.data.source.remote.RemoteDataSource
import com.bayutb.myshopapp.core.data.source.remote.network.ApiResponse
import com.bayutb.myshopapp.core.data.source.remote.response.ProductResponse
import com.bayutb.myshopapp.core.utils.ListMapper
import com.bayutb.myshopapp.core.utils.MyExecutors
import com.bayutb.myshopapp.core.domain.model.Product
import com.bayutb.myshopapp.core.domain.repository.IProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val myExecutors: MyExecutors
): IProductRepository {
    override fun getAllProduct(): Flow<Resource<List<Product>>> {
        return object : NetworkBoundResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromDB(): Flow<List<Product>> {
                return localDataSource.getAllProduct().map {
                    ListMapper.mapEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return remoteDataSource.getProducts()
            }

            override suspend fun saveCall(data: List<ProductResponse>) {
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
            localDataSource.setFavourite(productEntity = entity, newState = entity.isFavourite)
        }
    }

}