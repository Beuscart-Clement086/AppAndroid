package com.example.quizapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RealisateurAdapter(private val directors: List<Realisateur>) :
    RecyclerView.Adapter<RealisateurAdapter.DirectorViewHolder>() {

    class DirectorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.characterImage)
        val nameTextView: TextView = itemView.findViewById(R.id.characterName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.characterDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return DirectorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DirectorViewHolder, position: Int) {
        val r = directors[position]
        holder.imageView.loadEntityImage(r.imageUri, r.imageResId)
        holder.nameTextView.text = r.nomComplet
        holder.descriptionTextView.text = r.nationalite

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, RealisateurDetailActivity::class.java).apply {
                putExtra("DIRECTOR_ID", r.id)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = directors.size
}
