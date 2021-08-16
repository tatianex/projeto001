package com.proway.projeto001.endpoint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserServiceInstance() : UserService {
        return retrofit.create(UserService::class.java)
    }

    fun getProductServiceInstance() : ProductService {
        return retrofit.create(ProductService::class.java)
    }

}