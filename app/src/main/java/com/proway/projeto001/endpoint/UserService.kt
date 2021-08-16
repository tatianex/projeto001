package com.proway.projeto001.endpoint

import com.proway.projeto001.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

//    @GET("users/{ id }")
//    fun getUser(id: Int): Call<User>

    @GET("users/1")
    fun getUser(): Call<User>
}