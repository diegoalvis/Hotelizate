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

class HotelAdapter : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    val hotelSelected = PublishSubject.create<Hotel>()
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

    override fun getItemCount() = items.size

    fun articleSelected(): Observable<Hotel> = hotelSelected

    class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemHotelBinding = DataBindingUtil.bind(itemView)
    }

}