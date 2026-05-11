package com.example.quizapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.jvm.java

class ObjectAdapter(private val objects: List<MarvelObject>) :
    RecyclerView.Adapter<ObjectAdapter.ObjectViewHolder>() {

    class ObjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.characterImage)
        val nameTextView: TextView = itemView.findViewById(R.id.characterName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.characterDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return ObjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectViewHolder, position: Int) {
        val obj = objects[position]
        holder.imageView.setImageResource(obj.imageResId)
        holder.nameTextView.text = obj.name
        holder.descriptionTextView.text = obj.description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ObjectDetailActivity::class.java).apply {
                putExtra("OBJECT_INDEX", position)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = objects.size
}