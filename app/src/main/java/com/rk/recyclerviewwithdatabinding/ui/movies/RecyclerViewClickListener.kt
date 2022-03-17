package com.rk.recyclerviewwithdatabinding.ui.movies

import android.view.View
import com.rk.recyclerviewwithdatabinding.data.response.HealthItem

interface RecyclerViewClickListener {

    fun onRecyclerViewItemClick(view: View, movieItem: HealthItem)
}