package com.example.pizzatune.loginmodel.userlogin.model

data class LoginRequest(
    val data: Data
){
    data class Data(
        val email: String,
        val password: String

       /* ,val restaurant_id: String,
        val user_parent_id: String,
        val device_token: String,
        val device_type: String*/
    )
}