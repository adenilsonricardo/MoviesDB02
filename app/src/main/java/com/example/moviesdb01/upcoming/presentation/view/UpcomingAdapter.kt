package com.example.moviesdb01.upcoming.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb01.databinding.UpcomingListBinding
import com.example.moviesdb01.utils.POSTER_BASE_URL
import com.example.moviesdb01.upcoming.domain.model.UpcomingResult
import com.squareup.picasso.Picasso

class UpcomingAdapter(private var list: MutableList<UpcomingResult> = mutableListOf()) :
    RecyclerView.Adapter<UpcomingAdapter.ViewHolder>() {

    class ViewHolder(private val binding: UpcomingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(upcoming: UpcomingResult) {
            binding.upcomingReleaseDate.text = upcoming.releaseDate
            binding.upcomingMovieName.text = upcoming.title
            Picasso.get().load(POSTER_BASE_URL + upcoming.posterPath)
                .into(binding.upcomingMovieImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UpcomingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val upcoming = list[position]
        holder.onBind(upcoming)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newList: MutableList<UpcomingResult>) {
        this.list.removeAll(list)
        if (newList != null) {
            this.list = newList
        }
        notifyDataSetChanged()
    }

}