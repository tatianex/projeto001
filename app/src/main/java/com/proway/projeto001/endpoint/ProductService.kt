package com.proway.projeto001.endpoint

import com.proway.projeto001.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getAllProducts(): Call<List<Product>>

    @GET("products/{ id }")
    fun getProduct(): Call<Product>
}