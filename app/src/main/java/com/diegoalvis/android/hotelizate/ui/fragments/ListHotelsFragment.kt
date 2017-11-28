package com.diegoalvis.android.hotelizate.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegoalvis.android.hotelizate.databinding.FragmentListHotelsBinding
import com.diegoalvis.android.hotelizate.models.Hotel
import com.diegoalvis.android.hotelizate.ui.activities.MainViewModel
import com.diegoalvis.android.hotelizate.ui.adapters.HotelAdapter
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_list_hotels.*
import android.content.Intent
import com.diegoalvis.android.hotelizate.ui.activities.DetailActivity
import com.google.gson.Gson




class ListHotelsFragment : Fragment(), SearchView.OnQueryTextListener {

    lateinit var binding: FragmentListHotelsBinding


    val hotelAdapter: HotelAdapter = HotelAdapter()
    var viewModel: MainViewModel? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListHotelsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        hotelAdapter.items = emptyList()
        hotelAdapter.itemsHolder = emptyList()
        recyclerHotel.adapter = hotelAdapter
        loadData()
        searchView.setOnQueryTextListener(this)

        // Set item click subscription
        hotelAdapter.hotelSelected()
                .subscribeBy(onNext = { itemSelected(it) },
                             onError = { it.printStackTrace() })

    }

    override fun onQueryTextSubmit(query: String): Boolean = false


    override fun onQueryTextChange(newText: String): Boolean {
        hotelAdapter.searchResults(newText)
        return false
    }

    fun itemSelected(hotel: Hotel) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("hotel", Gson().toJson(hotel))
        startActivity(intent)

        // Toast.makeText(context, hotel.name.plus(" selected"), Toast.LENGTH_SHORT).show()
    }


    private fun loadData() {
        viewModel?.getHotels()
                 ?.subscribeBy(
                        onNext = { hotelAdapter.items = it
                                   hotelAdapter.itemsHolder = it},
                        onError = {
                            it.printStackTrace()
                        }
                )
    }


}