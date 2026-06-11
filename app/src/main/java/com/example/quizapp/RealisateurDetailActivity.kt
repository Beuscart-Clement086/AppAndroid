package com.example.quizapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class RealisateurDetailActivity : BaseActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private var directorId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realisateur_detail)

        dbHelper = DatabaseHelper(this)
        directorId = intent.getIntExtra("DIRECTOR_ID", 0)

        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            val intent = Intent(this, RealisateurAddEditActivity::class.java)
            intent.putExtra("DIRECTOR_ID", directorId)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener { confirmDelete() }
    }

    override fun onResume() {
        super.onResume()
        showDirector()
    }

    private fun showDirector() {
        val r = dbHelper.getDirectorById(directorId)
        if (r == null) {
            finish()
            return
        }

        findViewById<ImageView>(R.id.detailImage).loadEntityImage(r.imageUri, r.imageResId)
        findViewById<TextView>(R.id.detailName).text = r.nomComplet

        // Dates (le deces est facultatif)
        val dates = StringBuilder()
        if (r.dateNaissance.isNotBlank()) dates.append("Né(e) : ${r.dateNaissance}")
        if (r.dateDeces.isNotBlank()) {
            if (dates.isNotEmpty()) dates.append("   •   ")
            dates.append("Décédé(e) : ${r.dateDeces}")
        }
        findViewById<TextView>(R.id.detailDates).text = dates.toString()
        findViewById<TextView>(R.id.detailNationalite).text = r.nationalite

        // Films realises par ce realisateur (relation 1 -> N)
        val container = findViewById<LinearLayout>(R.id.filmsContainer)
        container.removeAllViews()
        val films = dbHelper.getMoviesByDirector(r.nomComplet)

        if (films.isEmpty()) {
            val empty = TextView(this).apply {
                text = "Aucun film enregistré pour ce réalisateur."
                setTextColor(0xFFDDDDDD.toInt())
                textSize = 15f
            }
            container.addView(empty)
            return
        }

        films.forEach { film ->
            container.addView(buildFilmRow(film))
        }
    }

    /** Construit une ligne cliquable (affiche + titre) menant au detail du film. */
    private fun buildFilmRow(film: Movies): LinearLayout {
        val row = LinearLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).also { it.bottomMargin = 16 }
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            isClickable = true
            setBackgroundResource(android.R.drawable.list_selector_background)
            setOnClickListener {
                val intent = Intent(this@RealisateurDetailActivity, MovieDetailActivity::class.java)
                intent.putExtra("MOVIE_ID", film.id)
                startActivity(intent)
            }
        }

        val poster = ImageView(this).apply {
            layoutParams = LinearLayout.LayoutParams(120, 160).also { it.marginEnd = 16 }
            scaleType = ImageView.ScaleType.CENTER_CROP
            if (film.imageResId != 0) setImageResource(film.imageResId)
            else setImageResource(R.drawable.ic_app)
        }
        row.addView(poster)

        val title = TextView(this).apply {
            text = if (film.fullName.isNotBlank()) film.fullName else film.name
            setTextColor(0xFFFFFFFF.toInt())
            textSize = 16f
        }
        row.addView(title)

        return row
    }

    private fun confirmDelete() {
        AlertDialog.Builder(this)
            .setTitle("Supprimer")
            .setMessage("Supprimer ce réalisateur ?")
            .setPositiveButton("Supprimer") { _, _ ->
                dbHelper.deleteDirector(directorId)
                finish()
            }
            .setNegativeButton("Annuler", null)
            .show()
    }
}
