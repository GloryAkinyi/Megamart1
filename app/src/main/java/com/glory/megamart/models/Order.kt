package com.glory.megamart.models


data class Order(
    val orderId: String = "",
    val userId: String = "",
    val productName: String = "",
    val quantity: Int = 0,
    val price: Double = 0.0,
    val address: String = "",
    val status: String = "Pending"
)