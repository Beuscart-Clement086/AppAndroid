package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout

class CharacterDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        val name = intent.getStringExtra("CHARACTER_NAME") ?: return
        val character = CharactersData.getCharacters().find { it.name == name } ?: return


        findViewById<ImageView>(R.id.detailImage).setImageResource(character.imageResId)
        findViewById<android.widget.TextView>(R.id.detailName).text = character.name
        findViewById<android.widget.TextView>(R.id.detailFullName).text = character.fullName
        findViewById<android.widget.TextView>(R.id.detailDescription).text = character.description
        findViewById<android.widget.TextView>(R.id.detailBio).text = character.bio

        // Films
        val moviesContainer = findViewById<LinearLayout>(R.id.moviesContainer)
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
        character.gallery.forEach { resId ->  // ou obj.gallery pour les objets
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