package com.diegoalvis.android.hotelizate.api

import com.diegoalvis.android.hotelizate.models.Hotel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("hotels")
    fun getHotelsList(): Observable<List<Hotel>>

}