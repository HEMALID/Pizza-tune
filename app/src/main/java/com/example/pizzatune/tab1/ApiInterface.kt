package com.example.pizzatune.tab1

import com.example.pizzatune.tab1.model.MenuX
import retrofit2.Call
import retrofit2.http.GET

abstract class ApiInterface {

    @GET("getRestaurantMenuList")
    abstract fun getData(): Call<ArrayList<MenuX>>

}
/*
data class Menu(val menu: List<Menu.MenuX>, val type: String)
{
    data class MenuX(
        val food_type: String,
        val image: String,
        val menu_name: String,
        val price: Int,
        val restaurant_id: Int,
        val restaurant_menu_id: Int,
        val restaurant_menu_type_id: Int
    )
}*/
