package com.proway.projeto001.endpoint

import com.proway.projeto001.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    fun getAllProducts(): Call<List<Product>>

    @GET("/products/{id}")
    fun getProduct(@Path("id") productId: Int): Call<Product>
}