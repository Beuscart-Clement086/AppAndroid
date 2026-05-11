package com.example.quizapp

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersActivity : BaseActivity() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        dbHelper = DatabaseHelper(this)
        insertSampleCharacters() // garde la DB à jour si besoin

        // Utilise CharactersData pour l'affichage (données complètes)
        val characters = CharactersData.getCharacters().sortedBy { it.name }

        val recyclerView = findViewById<RecyclerView>(R.id.charactersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CharacterAdapter(characters)
    }

    private fun insertSampleCharacters() {
        if (dbHelper.getAllCharacters().isEmpty()) {
            dbHelper.insertCharacter("Iron Man", "Genie, milliardaire, play-boy, philanthrope", R.drawable.iron_man)
            dbHelper.insertCharacter("Captain America", "Super-soldat et leader des Avengers", R.drawable.captain_america)
            dbHelper.insertCharacter("Thor", "Dieu asgardien du tonnerre", R.drawable.thor)
        }
    }
}