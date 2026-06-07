package com.example.quizapp

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView

class MovieDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val name = intent.getStringExtra("MOVIE_NAME") ?: return
        val movie = MoviesData.getMovies().find { it.name == name } ?: return

        findViewById<ImageView>(R.id.detailImage).setImageResource(movie.imageResId)
        findViewById<TextView>(R.id.detailName).text = movie.name
        findViewById<TextView>(R.id.detailFullName).text = movie.fullName
        findViewById<TextView>(R.id.detailDescription).text = movie.phase
        findViewById<TextView>(R.id.detailBio).text = movie.bio

        val padding = (16 * resources.displayMetrics.density * 2).toInt()
        val imageSize = (resources.displayMetrics.widthPixels - padding) / 3

        val galleryContainer = findViewById<GridLayout>(R.id.galleryContainer)
        movie.gallery.forEach { resId ->
            val img = ImageView(this).apply {
                layoutParams = GridLayout.LayoutParams().apply {
                    width = imageSize
                    height = imageSize
                    setMargins(4, 4, 4, 4)
                }
                val bitmap = android.graphics.BitmapFactory.decodeResource(resources, resId)
                val scaled = android.graphics.Bitmap.createScaledBitmap(bitmap, imageSize, imageSize, true)
                bitmap.recycle()
                setImageBitmap(scaled)
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