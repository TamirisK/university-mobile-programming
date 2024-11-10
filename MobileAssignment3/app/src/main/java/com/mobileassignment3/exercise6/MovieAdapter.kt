package com.mobileassignment3.exercise6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobileassignment3.R
import com.mobileassignment3.exercise4.Movie

class MovieAdapter(
    private val movieList: List<Movie>,
    private val itemClickListener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener {
            itemClickListener(movie)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewMovieTitle)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            imageView.setImageResource(movie.imageRes)
        }
    }
}