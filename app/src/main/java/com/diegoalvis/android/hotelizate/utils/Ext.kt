package com.diegoalvis.android.hotelizate.utils

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(layout:Int) = LayoutInflater.from(context).inflate(layout, this, false)