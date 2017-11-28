package com.diegoalvis.android.hotelizate.ui.activities

import android.content.Context
import android.databinding.ObservableBoolean
import com.diegoalvis.android.hotelizate.api.ApiClient
import com.diegoalvis.android.hotelizate.api.ApiInterface
import com.diegoalvis.android.hotelizate.models.Hotel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel(private val context: Context){

    var isLoading: ObservableBoolean = ObservableBoolean(false)

    private val newsApi: ApiInterface = ApiClient.getInstance()

    fun getHotels(): Observable<List<Hotel>> {
        isLoading.set(true)
        return newsApi
                .getHotelsList()
                .doOnTerminate { isLoading.set(false) }
                .observeOn(AndroidSchedulers.mainThread())
    }
}
