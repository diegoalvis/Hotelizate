package com.diegoalvis.android.hotelizate.ui.adapters

import android.databinding.DataBindingUtil
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.diegoalvis.android.hotelizate.R
import com.diegoalvis.android.hotelizate.databinding.ItemHotelBinding
import com.diegoalvis.android.hotelizate.models.Hotel
import com.diegoalvis.android.hotelizate.utils.inflate
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.ArrayList

class HotelAdapter : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    val hotelSelected = PublishSubject.create<Hotel>()
    var itemsHolder : List<Hotel> = emptyList()
    var items: List<Hotel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder
            = HotelViewHolder(parent.inflate(R.layout.item_hotel))

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.binding.hotel = items[position]
        holder.binding.selected = hotelSelected
    }

    fun searchResults(str: String) {
        val filterMovies = ArrayList<Hotel>()
        for (hotel in itemsHolder) {
            val title = hotel.name.toLowerCase()
            if (title.contains(str, true)) {
                filterMovies.add(hotel)
            }
        }
        this.items = filterMovies
    }


    override fun getItemCount() = items.size

    fun hotelSelected(): Observable<Hotel> = hotelSelected

    class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemHotelBinding = DataBindingUtil.bind(itemView)
    }

}