package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersActivity : BaseActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        dbHelper = DatabaseHelper(this)

        recyclerView = findViewById(R.id.charactersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddCharacter).setOnClickListener {
            startActivity(Intent(this, CharacterAddEditActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        // Lecture depuis SQLite a chaque affichage (ajout / modif / suppr pris en compte)
        recyclerView.adapter = CharacterAdapter(dbHelper.getAllCharacters())
    }
}
