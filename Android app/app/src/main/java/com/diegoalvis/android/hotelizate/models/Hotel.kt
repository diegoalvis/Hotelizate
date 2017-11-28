package com.diegoalvis.android.hotelizate.models

data class Hotel(val name: String, val stars: Int, val price: String, val phone: Double, val description: String,
                 val email: String, val address: String, val images: Array<String>)

