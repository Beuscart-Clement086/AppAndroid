package com.example.quizapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.characterImage)
        val nameTextView: TextView = itemView.findViewById(R.id.characterName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.characterDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.imageView.loadEntityImage(character.imageUri, character.imageResId)
        holder.nameTextView.text = character.name
        holder.descriptionTextView.text = character.description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, CharacterDetailActivity::class.java).apply {
                putExtra("CHARACTER_ID", character.id)  // passer l'id SQLite
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = characters.size
}