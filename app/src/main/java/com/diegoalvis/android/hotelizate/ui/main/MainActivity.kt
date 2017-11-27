package com.diegoalvis.android.hotelizate.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.diegoalvis.android.hotelizate.R
import com.diegoalvis.android.hotelizate.databinding.ActivityMainBinding
import com.diegoalvis.android.hotelizate.models.Hotel
import com.diegoalvis.android.hotelizate.ui.adapters.HotelAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy { MainViewModel(this) }
    private val hotelAdapter: HotelAdapter = HotelAdapter()

    private val subscriptions = CompositeDisposable()



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        recyclerHotel.adapter = hotelAdapter
//          setSubscriptions()
        loadData()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setSubscriptions() {
        subscriptions.addAll(
                hotelAdapter.articleSelected().subscribe(this::itemSelected)
        )
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.dispose()
    }

    fun itemSelected(hotel: Hotel) {
        Toast.makeText(this, hotel.name.plus(" selected"), Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        subscriptions.add(viewModel.getHotels()
                .subscribeBy(
                        onNext = { hotelAdapter.items = it },
                        onError = {
                            it.printStackTrace()
                            Toast.makeText(this, "Connection error!", Toast.LENGTH_SHORT).show()
                        }
                ))
    }

}
