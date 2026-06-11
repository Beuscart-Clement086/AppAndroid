package com.example.quizapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.File

/**
 * Creation / modification d'un realisateur.
 * Mode edition si l'intent contient un "DIRECTOR_ID" different de 0.
 */
class RealisateurAddEditActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var imagePreview: ImageView
    private var editingId: Int = 0
    private var existing: Realisateur? = null
    private var selectedImagePath: String = ""

    private val pickImage =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                val path = copyImageToInternal(uri)
                if (path != null) {
                    selectedImagePath = path
                    imagePreview.setImageURI(Uri.fromFile(File(path)))
                } else {
                    Toast.makeText(this, "Image illisible", Toast.LENGTH_SHORT).show()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realisateur_add_edit)

        dbHelper = DatabaseHelper(this)

        val title = findViewById<TextView>(R.id.formTitle)
        val editPrenom = findViewById<EditText>(R.id.editPrenom)
        val editNom = findViewById<EditText>(R.id.editNom)
        val editDateNaissance = findViewById<EditText>(R.id.editDateNaissance)
        val editDateDeces = findViewById<EditText>(R.id.editDateDeces)
        val editNationalite = findViewById<EditText>(R.id.editNationalite)
        val btnSave = findViewById<Button>(R.id.btnSave)
        imagePreview = findViewById(R.id.imagePreview)

        findViewById<Button>(R.id.btnPickImage).setOnClickListener {
            pickImage.launch("image/*")
        }
        findViewById<Button>(R.id.btnRemoveImage).setOnClickListener {
            selectedImagePath = ""
            imagePreview.setImageResource(R.drawable.ic_app)
        }

        editingId = intent.getIntExtra("DIRECTOR_ID", 0)
        if (editingId != 0) {
            existing = dbHelper.getDirectorById(editingId)
            existing?.let {
                title.text = "Modifier le réalisateur"
                editPrenom.setText(it.prenom)
                editNom.setText(it.nom)
                editDateNaissance.setText(it.dateNaissance)
                editDateDeces.setText(it.dateDeces)
                editNationalite.setText(it.nationalite)
                selectedImagePath = it.imageUri
                imagePreview.loadEntityImage(it.imageUri, it.imageResId)
            }
        } else {
            imagePreview.setImageResource(R.drawable.ic_app)
        }

        btnSave.setOnClickListener {
            val prenom = editPrenom.text.toString().trim()
            val nom = editNom.text.toString().trim()
            if (prenom.isEmpty() && nom.isEmpty()) {
                Toast.makeText(this, "Le nom ou le prénom est obligatoire", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val director = Realisateur(
                id = editingId,
                prenom = prenom,
                nom = nom,
                dateNaissance = editDateNaissance.text.toString().trim(),
                dateDeces = editDateDeces.text.toString().trim(),
                nationalite = editNationalite.text.toString().trim(),
                imageResId = existing?.imageResId ?: 0,
                imageUri = selectedImagePath
            )

            if (editingId == 0) {
                dbHelper.insertDirector(director)
                Toast.makeText(this, "Réalisateur ajoute", Toast.LENGTH_SHORT).show()
            } else {
                dbHelper.updateDirector(director)
                Toast.makeText(this, "Réalisateur modifie", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }

    private fun copyImageToInternal(uri: Uri): String? {
        return try {
            val input = contentResolver.openInputStream(uri) ?: return null
            val file = File(filesDir, "dir_${System.currentTimeMillis()}.jpg")
            file.outputStream().use { out -> input.use { it.copyTo(out) } }
            file.absolutePath
        } catch (e: Exception) {
            null
        }
    }
}
