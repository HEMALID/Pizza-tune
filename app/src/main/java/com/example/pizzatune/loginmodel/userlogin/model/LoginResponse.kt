package com.example.pizzatune.loginmodel.userlogin.model

data class LoginResponse(
    val data: Data,
    val message: String,
    val status: Int
){
    data class Data(
        /*val auth_id: Any,
        val auth_provider: Any,
        val confirmation_code: Any,
        val created_at: String,
        val device_token: String,
        val device_type: String,
        val email: String,*/
        val first_name: String,
        val last_name: String,
        /*val phone: Any,
        val profile_pic: String,
        val status: String,
        val token: String,
        val updated_at: String,
        val user_id: Int,
        val user_parent: Int,
        val user_type: String*/
    )
}