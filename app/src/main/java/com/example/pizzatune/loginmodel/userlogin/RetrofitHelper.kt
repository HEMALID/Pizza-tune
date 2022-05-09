package com.example.pizzatune.loginmodel.userlogin

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object{
        private const val BASE_URL = "http://139.59.84.117/mocha/api/"

        val interceptor= HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client : OkHttpClient= OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()


        val retrofit =Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()!!

    }

}