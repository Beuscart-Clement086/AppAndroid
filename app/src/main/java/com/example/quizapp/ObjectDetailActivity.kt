package com.example.quizapp

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout

class ObjectDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_detail)

        val index = intent.getIntExtra("OBJECT_INDEX", 0)
        val obj = ObjectsData.getObjects().getOrNull(index) ?: return

        findViewById<ImageView>(R.id.detailImage).setImageResource(obj.imageResId)
        findViewById<android.widget.TextView>(R.id.detailName).text = obj.name
        findViewById<android.widget.TextView>(R.id.detailFullName).text = obj.fullName
        findViewById<android.widget.TextView>(R.id.detailDescription).text = obj.description
        findViewById<android.widget.TextView>(R.id.detailBio).text = obj.bio

        // Films
        val moviesContainer = findViewById<LinearLayout>(R.id.moviesContainer)
        obj.movies.forEach { resId ->
            val img = ImageView(this).apply {
                layoutParams = LinearLayout.LayoutParams(220, 300).also { it.marginEnd = 16 }
                setImageResource(resId)
                scaleType = ImageView.ScaleType.CENTER_CROP
                setOnClickListener { showImageDialog(resId) }
            }
            moviesContainer.addView(img)
        }

        // Galerie
        val galleryContainer = findViewById<LinearLayout>(R.id.galleryContainer)
        obj.gallery.forEach { resId ->
            val img = ImageView(this).apply {
                layoutParams = LinearLayout.LayoutParams(200, 200).also { it.marginEnd = 12 }
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