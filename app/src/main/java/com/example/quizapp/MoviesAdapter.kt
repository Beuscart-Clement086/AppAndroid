package com.example.quizapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val movies: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.characterImage)
        val nameTextView: TextView = itemView.findViewById(R.id.characterName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.characterDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.imageView.setImageResource(movie.imageResId)
        holder.nameTextView.text = movie.name
        holder.descriptionTextView.text = movie.phase  // affiche la phase

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("MOVIE_NAME", movie.name)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = movies.size
}