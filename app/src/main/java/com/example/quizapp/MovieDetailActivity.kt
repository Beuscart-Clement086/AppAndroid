package com.example.quizapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView

class MovieDetailActivity : BaseActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private var movieId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        dbHelper = DatabaseHelper(this)
        movieId = intent.getIntExtra("MOVIE_ID", 0)

        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            val intent = Intent(this, MovieAddEditActivity::class.java)
            intent.putExtra("MOVIE_ID", movieId)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener { confirmDelete() }
    }

    override fun onResume() {
        super.onResume()
        showMovie()
    }

    private fun showMovie() {
        val movie = dbHelper.getMovieById(movieId)
        if (movie == null) {
            finish()
            return
        }

        findViewById<ImageView>(R.id.detailImage).setImageResource(movie.imageResId)
        findViewById<TextView>(R.id.detailName).text = movie.name
        findViewById<TextView>(R.id.detailFullName).text = movie.fullName
        findViewById<TextView>(R.id.detailDescription).text = movie.phase
        findViewById<TextView>(R.id.detailBio).text = movie.bio

        val padding = (16 * resources.displayMetrics.density * 2).toInt()
        val imageSize = (resources.displayMetrics.widthPixels - padding) / 3

        val galleryContainer = findViewById<GridLayout>(R.id.galleryContainer)
        galleryContainer.removeAllViews()
        movie.gallery.forEach { resId ->
            val img = ImageView(this).apply {
                layoutParams = GridLayout.LayoutParams().apply {
                    width = imageSize
                    height = imageSize
                    setMargins(4, 4, 4, 4)
                }
                val bitmap = android.graphics.BitmapFactory.decodeResource(resources, resId)
                if (bitmap != null) {
                    val scaled = android.graphics.Bitmap.createScaledBitmap(bitmap, imageSize, imageSize, true)
                    bitmap.recycle()
                    setImageBitmap(scaled)
                }
                scaleType = ImageView.ScaleType.CENTER_CROP
                setOnClickListener { showImageDialog(resId) }
            }
            galleryContainer.addView(img)
        }
    }

    private fun confirmDelete() {
        AlertDialog.Builder(this)
            .setTitle("Supprimer")
            .setMessage("Supprimer ce film ?")
            .setPositiveButton("Supprimer") { _, _ ->
                dbHelper.deleteMovie(movieId)
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
