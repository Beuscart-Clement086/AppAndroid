package com.example.quizapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ObjectDetailActivity : BaseActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private var objectId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_detail)

        dbHelper = DatabaseHelper(this)
        objectId = intent.getIntExtra("OBJECT_ID", 0)

        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            val intent = Intent(this, ObjectAddEditActivity::class.java)
            intent.putExtra("OBJECT_ID", objectId)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener { confirmDelete() }
    }

    override fun onResume() {
        super.onResume()
        showObject()
    }

    private fun showObject() {
        val obj = dbHelper.getObjectById(objectId)
        if (obj == null) {
            finish()
            return
        }

        findViewById<ImageView>(R.id.detailImage).loadEntityImage(obj.imageUri, obj.imageResId)
        findViewById<TextView>(R.id.detailName).text = obj.name
        findViewById<TextView>(R.id.detailFullName).text = obj.fullName
        findViewById<TextView>(R.id.detailDescription).text = obj.description
        findViewById<TextView>(R.id.detailBio).text = obj.bio

        // Films
        val moviesContainer = findViewById<LinearLayout>(R.id.moviesContainer)
        moviesContainer.removeAllViews()
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
        galleryContainer.removeAllViews()
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

    private fun confirmDelete() {
        AlertDialog.Builder(this)
            .setTitle("Supprimer")
            .setMessage("Supprimer cet objet ?")
            .setPositiveButton("Supprimer") { _, _ ->
                dbHelper.deleteObject(objectId)
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
