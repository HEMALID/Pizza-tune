package com.example.pizzatune.loginmodel.userlogin

import com.example.pizzatune.loginmodel.userlogin.model.LoginRequest
import com.example.pizzatune.loginmodel.userlogin.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface
ApiInterface {

    @POST("login")
    suspend fun createPost(@Body modelClass: LoginRequest): Response<LoginResponse?>?

}