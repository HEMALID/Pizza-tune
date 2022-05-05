package com.example.test.loginmodel

import com.example.test.loginmodel.Body
import com.example.test.loginmodel.Header

data class Request(
    val body: Body,
    val header: List<Header>,
    val method: String,
    val url: String
)