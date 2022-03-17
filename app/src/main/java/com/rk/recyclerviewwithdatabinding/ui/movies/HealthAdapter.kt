package com.rk.recyclerviewwithdatabinding.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rk.recyclerviewwithdatabinding.R
import com.rk.recyclerviewwithdatabinding.data.response.HealthItem
import com.rk.recyclerviewwithdatabinding.databinding.HeathItemBinding

class HealthAdapter(
    private val movies: List<HealthItem>,
    private val listener: RecyclerViewClickListener
) :
    RecyclerView.Adapter<HealthAdapter.MoviesHolder>() {

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesHolder(
            DataBindingUtil.inflate<HeathItemBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.heath_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {

        holder.recyclerviewMovieBinding.health = movies[position]
        holder.recyclerviewMovieBinding.imageView.setOnClickListener {
            listener.onRecyclerViewItemClick(
                holder.recyclerviewMovieBinding.imageView,
                movies[position]
            )

        }

    }

    inner class MoviesHolder(val recyclerviewMovieBinding: HeathItemBinding) :
        RecyclerView.ViewHolder(recyclerviewMovieBinding.root) {

    }
}