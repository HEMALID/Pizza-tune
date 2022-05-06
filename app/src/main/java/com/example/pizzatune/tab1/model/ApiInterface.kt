package com.example.pizzatune.tab1.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

abstract class ApiInterface {

    @GET("getRestaurantMenuList")
    abstract fun getData(): Call<ArrayList<Menu.MenuX>>

}