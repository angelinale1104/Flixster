package com.example.flixster

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.util.Pair as UtilPair


const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "MovieAdapter"

class MovieAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder position $position")
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)
        private val playIcon = itemView.findViewById<ImageView>(R.id.icon_play)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind (movie : Movie) {
            tvTitle.text = movie.title
            tvOverview.text = movie.overview

            // Get rating of movie
            val rating = movie.voteAverage

            val orientation: Int = context.resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // Populate image view
                Glide.with(context)
                    .load(movie.backdropUrl)
                    .into(ivPoster)
                if (rating.compareTo(5.0) > 0) {
                    playIcon.isVisible = true
                }
            }
            else {
                // Changed here
                Glide.with(context)
                    .load(movie.posterImageUrl)
                    .into(ivPoster)
                if (rating.compareTo(5.0) > 0) {
                    playIcon.isVisible = true
                }
            }
        }

        override fun onClick(v: View?) {
            // 1. Get notified of the particular movie which was clicked
            val movie = movies[adapterPosition]

            // 2. Use the intent system to navigate to new activity
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // Apply activity transition
                val options = ActivityOptions.makeSceneTransitionAnimation(context as Activity,
                    UtilPair.create(tvTitle, "title"),
                    UtilPair.create(tvOverview, "player"))
                context.startActivity(intent, options.toBundle())
            } else {
                // Swap without transition
                context.startActivity(intent)
            }
        }
    }
}
