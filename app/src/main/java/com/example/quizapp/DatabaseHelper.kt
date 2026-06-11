package com.example.quizapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Base de donnees SQLite de l'application.
 *
 * Toutes les operations CRUD passent par les methodes du SDK Android
 * (ContentValues + db.insert / db.query / db.update / db.delete).
 *
 * Les listes d'images (movies, gallery) et la liste d'options des questions
 * sont serialisees en TEXT car SQLite ne stocke pas de listes nativement.
 */
class DatabaseHelper(private val ctx: Context) :
    SQLiteOpenHelper(ctx, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "QuizAppDB"
        const val DATABASE_VERSION = 7

        // Separateurs utilises pour serialiser les listes en TEXT.
        private const val SEP = "|~|"   // listes de texte (options de questions)
        private const val CSV = ","     // listes d'entiers (ids d'images)

        // --- Tables ---
        const val TABLE_CHARACTERS = "characters"
        const val TABLE_MOVIES = "movies"
        const val TABLE_OBJECTS = "objects"
        const val TABLE_QUESTIONS = "questions"
        const val TABLE_DIRECTORS = "directors"

        // Colonnes communes
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_DESCRIPTION = "description"
        const val COL_IMAGE = "imageResId"
        const val COL_FULLNAME = "fullName"
        const val COL_BIO = "bio"

        const val COL_GALLERY = "gallery"
        const val COL_PHASE = "phase"
        const val COL_IMAGE_URI = "imageUri"
        const val COL_DIRECTOR = "director"

        // Colonnes Realisateurs
        const val COL_PRENOM = "prenom"
        const val COL_NOM = "nom"
        const val COL_DATE_NAISSANCE = "dateNaissance"
        const val COL_DATE_DECES = "dateDeces"
        const val COL_NATIONALITE = "nationalite"

        // Colonnes Questions
        const val COL_TEXT = "text"
        const val COL_OPTIONS = "options"
        const val COL_CORRECT = "correctAnswerIndex"
        const val COL_CATEGORY = "category"
    }

    // ---------------------------------------------------------------------
    //  Creation / mise a jour du schema
    // ---------------------------------------------------------------------

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE $TABLE_CHARACTERS (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_NAME TEXT,
                $COL_DESCRIPTION TEXT,
                $COL_IMAGE INTEGER,
                $COL_FULLNAME TEXT,
                $COL_BIO TEXT,
                $COL_MOVIES TEXT,
                $COL_GALLERY TEXT,
                $COL_IMAGE_URI TEXT
            )
            """.trimIndent()
        )

        db.execSQL(
            """
            CREATE TABLE $TABLE_MOVIES (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_NAME TEXT,
                $COL_DESCRIPTION TEXT,
                $COL_IMAGE INTEGER,
                $COL_FULLNAME TEXT,
                $COL_BIO TEXT,
                $COL_PHASE TEXT,
                $COL_GALLERY TEXT,
                $COL_DIRECTOR TEXT
            )
            """.trimIndent()
        )

        db.execSQL(
            """
            CREATE TABLE $TABLE_OBJECTS (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_NAME TEXT,
                $COL_DESCRIPTION TEXT,
                $COL_IMAGE INTEGER,
                $COL_FULLNAME TEXT,
                $COL_BIO TEXT,
                $COL_MOVIES TEXT,
                $COL_GALLERY TEXT,
                $COL_IMAGE_URI TEXT
            )
            """.trimIndent()
        )

        db.execSQL(
            """
            CREATE TABLE $TABLE_QUESTIONS (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_TEXT TEXT,
                $COL_OPTIONS TEXT,
                $COL_CORRECT INTEGER,
                $COL_CATEGORY TEXT
            )
            """.trimIndent()
        )

        db.execSQL(
            """
            CREATE TABLE $TABLE_DIRECTORS (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_PRENOM TEXT,
                $COL_NOM TEXT,
                $COL_DATE_NAISSANCE TEXT,
                $COL_DATE_DECES TEXT,
                $COL_NATIONALITE TEXT,
                $COL_IMAGE INTEGER,
                $COL_IMAGE_URI TEXT
            )
            """.trimIndent()
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Anciennes tables eventuelles
        db.execSQL("DROP TABLE IF EXISTS QuizTable")
        db.execSQL("DROP TABLE IF EXISTS CharacterTable")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CHARACTERS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_MOVIES")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_OBJECTS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_QUESTIONS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_DIRECTORS")
        onCreate(db)
    }

    // ---------------------------------------------------------------------
    //  Initialisation : remplit la base avec les donnees de depart
    //  (uniquement si la table concernee est vide).
    // ---------------------------------------------------------------------

    fun seedIfEmpty() {
        if (DatabaseUtils.queryNumEntries(readableDatabase, TABLE_CHARACTERS) == 0L) {
            SeedLoader.loadCharacters(ctx).forEach { insertCharacter(it) }
        }
        if (DatabaseUtils.queryNumEntries(readableDatabase, TABLE_MOVIES) == 0L) {
            SeedLoader.loadMovies(ctx).forEach { insertMovie(it) }
        }
        if (DatabaseUtils.queryNumEntries(readableDatabase, TABLE_OBJECTS) == 0L) {
            SeedLoader.loadObjects(ctx).forEach { insertObject(it) }
        }
        if (DatabaseUtils.queryNumEntries(readableDatabase, TABLE_DIRECTORS) == 0L) {
            SeedLoader.loadDirectors(ctx).forEach { insertDirector(it) }
        }
        if (DatabaseUtils.queryNumEntries(readableDatabase, TABLE_QUESTIONS) == 0L) {
            QuizData.categories.forEach { category ->
                category.questions.forEach { question ->
                    insertQuestion(question.copy(category = category.name))
                }
            }
        }
    }

    // ---------------------------------------------------------------------
    //  Helpers de (de)serialisation des listes
    // ---------------------------------------------------------------------

    private fun intListToText(list: List<Int>): String = list.joinToString(CSV)

    private fun textToIntList(text: String?): List<Int> =
        if (text.isNullOrBlank()) emptyList()
        else text.split(CSV).mapNotNull { it.trim().toIntOrNull() }

    private fun stringListToText(list: List<String>): String = list.joinToString(SEP)

    private fun textToStringList(text: String?): List<String> =
        if (text.isNullOrEmpty()) emptyList() else text.split(SEP)

    private fun Cursor.str(col: String): String =
        getString(getColumnIndexOrThrow(col)) ?: ""

    private fun Cursor.int(col: String): Int =
        getInt(getColumnIndexOrThrow(col))

    // =====================================================================
    //  CRUD PERSONNAGES
    // =====================================================================

    fun insertCharacter(c: Character): Long {
        val values = ContentValues().apply {
            put(COL_NAME, c.name)
            put(COL_DESCRIPTION, c.description)
            put(COL_IMAGE, c.imageResId)
            put(COL_FULLNAME, c.fullName)
            put(COL_BIO, c.bio)
            put(COL_MOVIES, intListToText(c.movies))
            put(COL_GALLERY, intListToText(c.gallery))
            put(COL_IMAGE_URI, c.imageUri)
        }
        return writableDatabase.insert(TABLE_CHARACTERS, null, values)
    }

    fun updateCharacter(c: Character): Int {
        val values = ContentValues().apply {
            put(COL_NAME, c.name)
            put(COL_DESCRIPTION, c.description)
            put(COL_IMAGE, c.imageResId)
            put(COL_FULLNAME, c.fullName)
            put(COL_BIO, c.bio)
            put(COL_MOVIES, intListToText(c.movies))
            put(COL_GALLERY, intListToText(c.gallery))
            put(COL_IMAGE_URI, c.imageUri)
        }
        return writableDatabase.update(
            TABLE_CHARACTERS, values, "$COL_ID = ?", arrayOf(c.id.toString())
        )
    }

    fun deleteCharacter(id: Int): Int =
        writableDatabase.delete(TABLE_CHARACTERS, "$COL_ID = ?", arrayOf(id.toString()))

    fun getCharacterById(id: Int): Character? {
        val cursor = readableDatabase.query(
            TABLE_CHARACTERS, null, "$COL_ID = ?", arrayOf(id.toString()),
            null, null, null
        )
        val result = if (cursor.moveToFirst()) cursorToCharacter(cursor) else null
        cursor.close()
        return result
    }

    fun getAllCharacters(): List<Character> {
        val list = mutableListOf<Character>()
        val cursor = readableDatabase.query(
            TABLE_CHARACTERS, null, null, null, null, null, "$COL_NAME ASC"
        )
        while (cursor.moveToNext()) list.add(cursorToCharacter(cursor))
        cursor.close()
        return list
    }

    private fun cursorToCharacter(c: Cursor) = Character(
        id = c.int(COL_ID),
        name = c.str(COL_NAME),
        description = c.str(COL_DESCRIPTION),
        imageResId = c.int(COL_IMAGE),
        fullName = c.str(COL_FULLNAME),
        bio = c.str(COL_BIO),
        movies = textToIntList(c.str(COL_MOVIES)),
        gallery = textToIntList(c.str(COL_GALLERY)),
        imageUri = c.str(COL_IMAGE_URI)
    )

    // =====================================================================
    //  CRUD FILMS
    // =====================================================================

    fun insertMovie(m: Movies): Long {
        val values = ContentValues().apply {
            put(COL_NAME, m.name)
            put(COL_DESCRIPTION, m.description)
            put(COL_IMAGE, m.imageResId)
            put(COL_FULLNAME, m.fullName)
            put(COL_BIO, m.bio)
            put(COL_PHASE, m.phase)
            put(COL_GALLERY, intListToText(m.gallery))
            put(COL_DIRECTOR, m.director)
        }
        return writableDatabase.insert(TABLE_MOVIES, null, values)
    }

    fun updateMovie(m: Movies): Int {
        val values = ContentValues().apply {
            put(COL_NAME, m.name)
            put(COL_DESCRIPTION, m.description)
            put(COL_IMAGE, m.imageResId)
            put(COL_FULLNAME, m.fullName)
            put(COL_BIO, m.bio)
            put(COL_PHASE, m.phase)
            put(COL_GALLERY, intListToText(m.gallery))
            put(COL_DIRECTOR, m.director)
        }
        return writableDatabase.update(
            TABLE_MOVIES, values, "$COL_ID = ?", arrayOf(m.id.toString())
        )
    }

    fun deleteMovie(id: Int): Int =
        writableDatabase.delete(TABLE_MOVIES, "$COL_ID = ?", arrayOf(id.toString()))

    fun getMovieById(id: Int): Movies? {
        val cursor = readableDatabase.query(
            TABLE_MOVIES, null, "$COL_ID = ?", arrayOf(id.toString()),
            null, null, null
        )
        val result = if (cursor.moveToFirst()) cursorToMovie(cursor) else null
        cursor.close()
        return result
    }

    fun getAllMovies(): List<Movies> {
        val list = mutableListOf<Movies>()
        val cursor = readableDatabase.query(
            TABLE_MOVIES, null, null, null, null, null, "$COL_PHASE ASC"
        )
        while (cursor.moveToNext()) list.add(cursorToMovie(cursor))
        cursor.close()
        return list
    }

    /** Films realises par un realisateur donne (lien via le nom complet). */
    fun getMoviesByDirector(director: String): List<Movies> {
        val list = mutableListOf<Movies>()
        val cursor = readableDatabase.query(
            TABLE_MOVIES, null, "$COL_DIRECTOR = ?", arrayOf(director),
            null, null, "$COL_PHASE ASC"
        )
        while (cursor.moveToNext()) list.add(cursorToMovie(cursor))
        cursor.close()
        return list
    }

    private fun cursorToMovie(c: Cursor) = Movies(
        id = c.int(COL_ID),
        name = c.str(COL_NAME),
        description = c.str(COL_DESCRIPTION),
        imageResId = c.int(COL_IMAGE),
        fullName = c.str(COL_FULLNAME),
        bio = c.str(COL_BIO),
        phase = c.str(COL_PHASE),
        gallery = textToIntList(c.str(COL_GALLERY)),
        director = c.str(COL_DIRECTOR)
    )

    // =====================================================================
    //  CRUD OBJETS
    // =====================================================================

    fun insertObject(o: MarvelObject): Long {
        val values = ContentValues().apply {
            put(COL_NAME, o.name)
            put(COL_DESCRIPTION, o.description)
            put(COL_IMAGE, o.imageResId)
            put(COL_FULLNAME, o.fullName)
            put(COL_BIO, o.bio)
            put(COL_MOVIES, intListToText(o.movies))
            put(COL_GALLERY, intListToText(o.gallery))
            put(COL_IMAGE_URI, o.imageUri)
        }
        return writableDatabase.insert(TABLE_OBJECTS, null, values)
    }

    fun updateObject(o: MarvelObject): Int {
        val values = ContentValues().apply {
            put(COL_NAME, o.name)
            put(COL_DESCRIPTION, o.description)
            put(COL_IMAGE, o.imageResId)
            put(COL_FULLNAME, o.fullName)
            put(COL_BIO, o.bio)
            put(COL_MOVIES, intListToText(o.movies))
            put(COL_GALLERY, intListToText(o.gallery))
            put(COL_IMAGE_URI, o.imageUri)
        }
        return writableDatabase.update(
            TABLE_OBJECTS, values, "$COL_ID = ?", arrayOf(o.id.toString())
        )
    }

    fun deleteObject(id: Int): Int =
        writableDatabase.delete(TABLE_OBJECTS, "$COL_ID = ?", arrayOf(id.toString()))

    fun getObjectById(id: Int): MarvelObject? {
        val cursor = readableDatabase.query(
            TABLE_OBJECTS, null, "$COL_ID = ?", arrayOf(id.toString()),
            null, null, null
        )
        val result = if (cursor.moveToFirst()) cursorToObject(cursor) else null
        cursor.close()
        return result
    }

    fun getAllObjects(): List<MarvelObject> {
        val list = mutableListOf<MarvelObject>()
        val cursor = readableDatabase.query(
            TABLE_OBJECTS, null, null, null, null, null, "$COL_NAME ASC"
        )
        while (cursor.moveToNext()) list.add(cursorToObject(cursor))
        cursor.close()
        return list
    }

    private fun cursorToObject(c: Cursor) = MarvelObject(
        id = c.int(COL_ID),
        name = c.str(COL_NAME),
        description = c.str(COL_DESCRIPTION),
        imageResId = c.int(COL_IMAGE),
        fullName = c.str(COL_FULLNAME),
        bio = c.str(COL_BIO),
        movies = textToIntList(c.str(COL_MOVIES)),
        gallery = textToIntList(c.str(COL_GALLERY)),
        imageUri = c.str(COL_IMAGE_URI)
    )

    // =====================================================================
    //  CRUD QUESTIONS
    // =====================================================================

    fun insertQuestion(q: Question): Long {
        val values = ContentValues().apply {
            put(COL_TEXT, q.text)
            put(COL_OPTIONS, stringListToText(q.options))
            put(COL_CORRECT, q.correctAnswerIndex)
            put(COL_CATEGORY, q.category)
        }
        return writableDatabase.insert(TABLE_QUESTIONS, null, values)
    }

    fun updateQuestion(q: Question): Int {
        val values = ContentValues().apply {
            put(COL_TEXT, q.text)
            put(COL_OPTIONS, stringListToText(q.options))
            put(COL_CORRECT, q.correctAnswerIndex)
            put(COL_CATEGORY, q.category)
        }
        return writableDatabase.update(
            TABLE_QUESTIONS, values, "$COL_ID = ?", arrayOf(q.id.toString())
        )
    }

    fun deleteQuestion(id: Int): Int =
        writableDatabase.delete(TABLE_QUESTIONS, "$COL_ID = ?", arrayOf(id.toString()))

    fun getQuestionById(id: Int): Question? {
        val cursor = readableDatabase.query(
            TABLE_QUESTIONS, null, "$COL_ID = ?", arrayOf(id.toString()),
            null, null, null
        )
        val result = if (cursor.moveToFirst()) cursorToQuestion(cursor) else null
        cursor.close()
        return result
    }

    fun getAllQuestions(): List<Question> {
        val list = mutableListOf<Question>()
        val cursor = readableDatabase.query(
            TABLE_QUESTIONS, null, null, null, null, null, "$COL_CATEGORY ASC"
        )
        while (cursor.moveToNext()) list.add(cursorToQuestion(cursor))
        cursor.close()
        return list
    }

    fun getQuestionsByCategory(category: String): List<Question> {
        val list = mutableListOf<Question>()
        val cursor = readableDatabase.query(
            TABLE_QUESTIONS, null, "$COL_CATEGORY = ?", arrayOf(category),
            null, null, null
        )
        while (cursor.moveToNext()) list.add(cursorToQuestion(cursor))
        cursor.close()
        return list
    }

    private fun cursorToQuestion(c: Cursor) = Question(
        id = c.int(COL_ID),
        text = c.str(COL_TEXT),
        options = textToStringList(c.str(COL_OPTIONS)),
        correctAnswerIndex = c.int(COL_CORRECT),
        category = c.str(COL_CATEGORY)
    )

    // =====================================================================
    //  CRUD REALISATEURS
    // =====================================================================

    fun insertDirector(r: Realisateur): Long {
        val values = ContentValues().apply {
            put(COL_PRENOM, r.prenom)
            put(COL_NOM, r.nom)
            put(COL_DATE_NAISSANCE, r.dateNaissance)
            put(COL_DATE_DECES, r.dateDeces)
            put(COL_NATIONALITE, r.nationalite)
            put(COL_IMAGE, r.imageResId)
            put(COL_IMAGE_URI, r.imageUri)
        }
        return writableDatabase.insert(TABLE_DIRECTORS, null, values)
    }

    fun updateDirector(r: Realisateur): Int {
        val values = ContentValues().apply {
            put(COL_PRENOM, r.prenom)
            put(COL_NOM, r.nom)
            put(COL_DATE_NAISSANCE, r.dateNaissance)
            put(COL_DATE_DECES, r.dateDeces)
            put(COL_NATIONALITE, r.nationalite)
            put(COL_IMAGE, r.imageResId)
            put(COL_IMAGE_URI, r.imageUri)
        }
        return writableDatabase.update(
            TABLE_DIRECTORS, values, "$COL_ID = ?", arrayOf(r.id.toString())
        )
    }

    fun deleteDirector(id: Int): Int =
        writableDatabase.delete(TABLE_DIRECTORS, "$COL_ID = ?", arrayOf(id.toString()))

    fun getDirectorById(id: Int): Realisateur? {
        val cursor = readableDatabase.query(
            TABLE_DIRECTORS, null, "$COL_ID = ?", arrayOf(id.toString()),
            null, null, null
        )
        val result = if (cursor.moveToFirst()) cursorToDirector(cursor) else null
        cursor.close()
        return result
    }

    fun getAllDirectors(): List<Realisateur> {
        val list = mutableListOf<Realisateur>()
        val cursor = readableDatabase.query(
            TABLE_DIRECTORS, null, null, null, null, null, "$COL_NOM ASC"
        )
        while (cursor.moveToNext()) list.add(cursorToDirector(cursor))
        cursor.close()
        return list
    }

    private fun cursorToDirector(c: Cursor) = Realisateur(
        id = c.int(COL_ID),
        prenom = c.str(COL_PRENOM),
        nom = c.str(COL_NOM),
        dateNaissance = c.str(COL_DATE_NAISSANCE),
        dateDeces = c.str(COL_DATE_DECES),
        nationalite = c.str(COL_NATIONALITE),
        imageResId = c.int(COL_IMAGE),
        imageUri = c.str(COL_IMAGE_URI)
    )
}
