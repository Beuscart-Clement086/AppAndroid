package com.example.quizapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CharacterDetailActivity : BaseActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private var characterId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        dbHelper = DatabaseHelper(this)
        characterId = intent.getIntExtra("CHARACTER_ID", 0)

        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            val intent = Intent(this, CharacterAddEditActivity::class.java)
            intent.putExtra("CHARACTER_ID", characterId)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener { confirmDelete() }
    }

    override fun onResume() {
        super.onResume()
        showCharacter()   // recharge depuis SQLite (apres une modification)
    }

    private fun showCharacter() {
        val character = dbHelper.getCharacterById(characterId)
        if (character == null) {
            finish()
            return
        }

        findViewById<ImageView>(R.id.detailImage).loadEntityImage(character.imageUri, character.imageResId)
        findViewById<TextView>(R.id.detailName).text = character.name
        findViewById<TextView>(R.id.detailFullName).text = character.fullName
        findViewById<TextView>(R.id.detailDescription).text = character.description
        findViewById<TextView>(R.id.detailBio).text = character.bio

        // Films
        val moviesContainer = findViewById<LinearLayout>(R.id.moviesContainer)
        moviesContainer.removeAllViews()
        character.movies.forEach { resId ->
            val img = ImageView(this).apply {
                layoutParams = LinearLayout.LayoutParams(220, 300).also { it.marginEnd = 16 }
                setImageResource(resId)
                scaleType = ImageView.ScaleType.CENTER_CROP
                setOnClickListener { showImageDialog(resId) }
            }
            moviesContainer.addView(img)
        }

        // Galerie
        val galleryContainer = findViewById<GridLayout>(R.id.galleryContainer)
        galleryContainer.removeAllViews()
        character.gallery.forEach { resId ->
            val size = (resources.displayMetrics.widthPixels - 48) / 3
            val img = ImageView(this).apply {
                layoutParams = GridLayout.LayoutParams().apply {
                    width = size
                    height = size
                    setMargins(4, 4, 4, 4)
                }
                setImageResource(resId)
                scaleType = ImageView.ScaleType.CENTER_CROP
                setOnClickListener { showImageDialog(resId) }
            }
            galleryContainer.addView(img)
        }
    }

    private fun confirmDelete() {
        AlertDialog.Builder(this)
            .setTitle("Supprimer")
            .setMessage("Supprimer ce personnage ?")
            .setPositiveButton("Supprimer") { _, _ ->
                dbHelper.deleteCharacter(characterId)
                finish()
            }
            .setNegativeButton("Annuler", null)
            .show()
    }

    private fun showImageDialog(imageResId: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.image_fullscreen)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.setLayout(
            android.view.WindowManager.LayoutParams.MATCH_PARENT,
            android.view.WindowManager.LayoutParams.MATCH_PARENT
        )
        val imageView = dialog.findViewById<ImageView>(R.id.dialogImageView)
        imageView.setImageResource(imageResId)
        imageView.setOnClickListener { dialog.dismiss() }
        dialog.setOnCancelListener { dialog.dismiss() }
        dialog.show()
    }
}
