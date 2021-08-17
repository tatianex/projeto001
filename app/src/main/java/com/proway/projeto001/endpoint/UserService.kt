package com.proway.projeto001.endpoint

import com.proway.projeto001.model.Product
import com.proway.projeto001.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("/users/{id}")
    fun getUser(@Path("id") userId: Int): Call<User>
}