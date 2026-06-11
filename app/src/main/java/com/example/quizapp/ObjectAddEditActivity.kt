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
 * Creation / modification d'un objet.
 * Mode edition si l'intent contient un "OBJECT_ID" different de 0.
 * L'utilisateur peut choisir une image (depuis le telephone) ou n'en mettre aucune.
 */
class ObjectAddEditActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var imagePreview: ImageView
    private var editingId: Int = 0
    private var existing: MarvelObject? = null
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
        setContentView(R.layout.activity_object_add_edit)

        dbHelper = DatabaseHelper(this)

        val title = findViewById<TextView>(R.id.formTitle)
        val editName = findViewById<EditText>(R.id.editName)
        val editFullName = findViewById<EditText>(R.id.editFullName)
        val editDescription = findViewById<EditText>(R.id.editDescription)
        val editBio = findViewById<EditText>(R.id.editBio)
        val btnSave = findViewById<Button>(R.id.btnSave)
        imagePreview = findViewById(R.id.imagePreview)

        findViewById<Button>(R.id.btnPickImage).setOnClickListener {
            pickImage.launch("image/*")
        }
        findViewById<Button>(R.id.btnRemoveImage).setOnClickListener {
            selectedImagePath = ""
            imagePreview.setImageResource(R.drawable.ic_app)
        }

        editingId = intent.getIntExtra("OBJECT_ID", 0)
        if (editingId != 0) {
            existing = dbHelper.getObjectById(editingId)
            existing?.let {
                title.text = "Modifier l'objet"
                editName.setText(it.name)
                editFullName.setText(it.fullName)
                editDescription.setText(it.description)
                editBio.setText(it.bio)
                selectedImagePath = it.imageUri
                imagePreview.loadEntityImage(it.imageUri, it.imageResId)
            }
        } else {
            imagePreview.setImageResource(R.drawable.ic_app)
        }

        btnSave.setOnClickListener {
            val name = editName.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(this, "Le nom est obligatoire", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val obj = MarvelObject(
                id = editingId,
                name = name,
                fullName = editFullName.text.toString().trim(),
                description = editDescription.text.toString().trim(),
                bio = editBio.text.toString().trim(),
                imageResId = existing?.imageResId ?: R.drawable.ic_app,
                movies = existing?.movies ?: emptyList(),
                gallery = existing?.gallery ?: emptyList(),
                imageUri = selectedImagePath
            )

            if (editingId == 0) {
                dbHelper.insertObject(obj)
                Toast.makeText(this, "Objet ajoute", Toast.LENGTH_SHORT).show()
            } else {
                dbHelper.updateObject(obj)
                Toast.makeText(this, "Objet modifie", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }

    private fun copyImageToInternal(uri: Uri): String? {
        return try {
            val input = contentResolver.openInputStream(uri) ?: return null
            val file = File(filesDir, "obj_${System.currentTimeMillis()}.jpg")
            file.outputStream().use { out -> input.use { it.copyTo(out) } }
            file.absolutePath
        } catch (e: Exception) {
            null
        }
    }
}
