package com.diegoalvis.android.hotelizate.ui.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.diegoalvis.android.hotelizate.R
import com.diegoalvis.android.hotelizate.databinding.ActivityDetailBinding
import com.diegoalvis.android.hotelizate.models.Hotel
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_hotel.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val strObj = intent.getStringExtra("hotel")
        val hotelItem: Hotel = Gson().fromJson(strObj, Hotel::class.java)

        binding.hotel = hotelItem

        setSupportActionBar(toolbar as Toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        Picasso.with(this).load(hotelItem.images[2]).into(iv_hotel_detail)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

}
