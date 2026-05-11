package com.example.quizapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Character

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        // QuizTable (pour les questions)
        const val DATABASE_NAME = "QuizAppDB"
        const val DATABASE_VERSION = 2
        const val TABLE_QUIZ = "QuizTable"
        const val COLUMN_ID_QUIZ = "id"
        const val COLUMN_QUESTION = "question"
        const val COLUMN_ANSWER = "answer"

        const val TABLE_CHARACTERS = "CharacterTable"
        const val COLUMN_ID_CHARACTER = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_IMAGE_RES_ID = "imageResId"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createQuizTableQuery = """
            CREATE TABLE $TABLE_QUIZ (
                $COLUMN_ID_QUIZ INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_QUESTION TEXT,
                $COLUMN_ANSWER TEXT
            )
        """.trimIndent()
        db?.execSQL(createQuizTableQuery)


        val createCharacterTableQuery = """
            CREATE TABLE $TABLE_CHARACTERS (
                $COLUMN_ID_CHARACTER INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT,
                $COLUMN_DESCRIPTION TEXT,
                $COLUMN_IMAGE_RES_ID INTEGER
            )
        """.trimIndent()
        db?.execSQL(createCharacterTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_QUIZ")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_CHARACTERS")
        onCreate(db)
    }


    fun insertCharacter(name: String, description: String, imageResId: Int): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_DESCRIPTION, description)
            put(COLUMN_IMAGE_RES_ID, imageResId)
        }
        return db.insert(TABLE_CHARACTERS, null, values)
    }

    fun getAllCharacters(): List<com.example.quizapp.Character> {
        val characters = mutableListOf<com.example.quizapp.Character>()
        val db = readableDatabase
        val cursor = db.query(
            TABLE_CHARACTERS,
            arrayOf(COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_IMAGE_RES_ID),
            null, null, null, null, null
        )
        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
            val description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION))
            val imageResId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_RES_ID))
            characters.add(
                com.example.quizapp.Character(
                    name = name,
                    description = description,
                    imageResId = imageResId,
                    fullName = "",
                    bio = "",
                    movies = emptyList(),
                    gallery = emptyList()
                )
            )        }
        cursor.close()
        return characters
    }




    fun insertQuestion(question: String, answer: String, category: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_QUESTION, question)
            put(COLUMN_ANSWER, answer)
            put("category", category) // Ajoute une colonne "category" dans QuizTable
        }
        return db.insert(TABLE_QUIZ, null, values)
    }

    fun getQuestionsByCategory(category: String): List<Question> {
        val questions = mutableListOf<Question>()
        val db = readableDatabase
        val cursor = db.query(
            TABLE_QUIZ,
            arrayOf(COLUMN_QUESTION, COLUMN_ANSWER),
            "category = ?",
            arrayOf(category),
            null, null, null
        )
        while (cursor.moveToNext()) {
            val questionText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION))
            val answer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWER))
              }
        cursor.close()
        return questions
    }
}