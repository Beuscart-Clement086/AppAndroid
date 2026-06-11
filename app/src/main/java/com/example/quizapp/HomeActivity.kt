package com.example.quizapp

import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import android.widget.ImageView

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Premier lancement : on remplit la base SQLite avec les donnees de depart
        DatabaseHelper(this).seedIfEmpty()

        Thread {
            val source = ImageDecoder.createSource(resources, R.drawable.gif_home)
            val drawable = ImageDecoder.decodeDrawable(source)
            val imageView = findViewById<ImageView>(R.id.image_view)
            imageView.post {
                imageView.setImageDrawable(drawable)
                if (drawable is AnimatedImageDrawable) {
                    drawable.start()
                }
            }
        }.start()
    }
}
