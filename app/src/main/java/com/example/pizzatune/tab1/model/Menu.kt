package com.example.pizzatune.tab1.model

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
}