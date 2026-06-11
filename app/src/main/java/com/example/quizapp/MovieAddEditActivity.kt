package com.example.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Creation / modification d'un film.
 * Mode edition si l'intent contient un "MOVIE_ID" different de 0.
 */
class MovieAddEditActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private var editingId: Int = 0
    private var existing: Movies? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_add_edit)

        dbHelper = DatabaseHelper(this)

        val title = findViewById<TextView>(R.id.formTitle)
        val editName = findViewById<EditText>(R.id.editName)
        val editFullName = findViewById<EditText>(R.id.editFullName)
        val editPhase = findViewById<EditText>(R.id.editPhase)
        val editDirector = findViewById<EditText>(R.id.editDirector)
        val editDescription = findViewById<EditText>(R.id.editDescription)
        val editBio = findViewById<EditText>(R.id.editBio)
        val btnSave = findViewById<Button>(R.id.btnSave)

        editingId = intent.getIntExtra("MOVIE_ID", 0)
        if (editingId != 0) {
            existing = dbHelper.getMovieById(editingId)
            existing?.let {
                title.text = "Modifier le film"
                editName.setText(it.name)
                editFullName.setText(it.fullName)
                editPhase.setText(it.phase)
                editDirector.setText(it.director)
                editDescription.setText(it.description)
                editBio.setText(it.bio)
            }
        }

        btnSave.setOnClickListener {
            val name = editName.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(this, "Le nom est obligatoire", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val movie = Movies(
                id = editingId,
                name = name,
                fullName = editFullName.text.toString().trim(),
                phase = editPhase.text.toString().trim(),
                director = editDirector.text.toString().trim(),
                description = editDescription.text.toString().trim(),
                bio = editBio.text.toString().trim(),
                imageResId = existing?.imageResId ?: R.drawable.ic_app,
                gallery = existing?.gallery ?: emptyList()
            )

            if (editingId == 0) {
                dbHelper.insertMovie(movie)
                Toast.makeText(this, "Film ajoute", Toast.LENGTH_SHORT).show()
            } else {
                dbHelper.updateMovie(movie)
                Toast.makeText(this, "Film modifie", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}
