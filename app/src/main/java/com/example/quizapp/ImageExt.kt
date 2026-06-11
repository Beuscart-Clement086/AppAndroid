package com.example.quizapp

import android.net.Uri
import android.widget.ImageView
import java.io.File

/**
 * Affiche l'image d'un element :
 *  - si un chemin d'image (imageUri) est defini et que le fichier existe, on l'affiche ;
 *  - sinon on retombe sur l'image de ressource (imageResId) ;
 *  - en dernier recours, l'icone de l'application.
 */
fun ImageView.loadEntityImage(imageUri: String, imageResId: Int) {
    if (imageUri.isNotBlank()) {
        val file = File(imageUri)
        if (file.exists()) {
            setImageURI(Uri.fromFile(file))
            return
        }
    }
    if (imageResId != 0) setImageResource(imageResId) else setImageResource(R.drawable.ic_app)
}
