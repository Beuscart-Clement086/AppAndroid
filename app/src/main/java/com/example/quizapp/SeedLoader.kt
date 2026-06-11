package com.example.quizapp

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

/**
 * Charge les donnees initiales depuis des fichiers JSON places dans assets/.
 *
 * Les images sont stockees dans le JSON sous forme de NOM de drawable
 * (ex: "iron_man"), puis resolues en identifiant de ressource a l'execution.
 *
 * Le chargement est tolerant : en cas de fichier manquant ou de JSON invalide,
 * on retourne une liste vide et on logue l'erreur (l'app ne plante pas).
 */
object SeedLoader {

    private const val TAG = "SeedLoader"

    private fun readAsset(ctx: Context, fileName: String): String =
        ctx.assets.open(fileName).bufferedReader().use { it.readText() }

    private fun drawableId(ctx: Context, name: String?): Int {
        if (name.isNullOrBlank()) return 0
        return ctx.resources.getIdentifier(name, "drawable", ctx.packageName)
    }

    /** Liste de noms de drawables -> liste d'identifiants de ressources. */
    private fun JSONObject.drawableIds(ctx: Context, key: String): List<Int> {
        val arr = optJSONArray(key) ?: return emptyList()
        val list = mutableListOf<Int>()
        for (i in 0 until arr.length()) {
            val id = drawableId(ctx, arr.optString(i))
            if (id != 0) list.add(id)
        }
        return list
    }

    /** Liste de chaines JSON -> List<String>. */
    private fun JSONObject.stringList(key: String): List<String> {
        val arr = optJSONArray(key) ?: return emptyList()
        val list = mutableListOf<String>()
        for (i in 0 until arr.length()) list.add(arr.optString(i))
        return list
    }

    // -----------------------------------------------------------------
    //  Personnages
    // -----------------------------------------------------------------
    fun loadCharacters(ctx: Context): List<Character> {
        val out = mutableListOf<Character>()
        try {
            val arr = JSONArray(readAsset(ctx, "characters.json"))
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                out.add(
                    Character(
                        name = o.optString("name"),
                        description = o.optString("description"),
                        imageResId = drawableId(ctx, o.optString("image")),
                        fullName = o.optString("fullName"),
                        bio = o.optString("bio"),
                        movies = o.drawableIds(ctx, "movies"),
                        gallery = o.drawableIds(ctx, "gallery")
                    )
                )
            }
        } catch (e: Exception) {
            Log.e(TAG, "characters.json: ${e.message}")
        }
        return out
    }

    // -----------------------------------------------------------------
    //  Films
    // -----------------------------------------------------------------
    fun loadMovies(ctx: Context): List<Movies> {
        val out = mutableListOf<Movies>()
        try {
            val arr = JSONArray(readAsset(ctx, "movies.json"))
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                out.add(
                    Movies(
                        name = o.optString("name"),
                        description = o.optString("description"),
                        imageResId = drawableId(ctx, o.optString("image")),
                        fullName = o.optString("fullName"),
                        bio = o.optString("bio"),
                        phase = o.optString("phase"),
                        gallery = o.drawableIds(ctx, "gallery"),
                        director = o.optString("director")
                    )
                )
            }
        } catch (e: Exception) {
            Log.e(TAG, "movies.json: ${e.message}")
        }
        return out
    }

    // -----------------------------------------------------------------
    //  Objets
    // -----------------------------------------------------------------
    fun loadObjects(ctx: Context): List<MarvelObject> {
        val out = mutableListOf<MarvelObject>()
        try {
            val arr = JSONArray(readAsset(ctx, "objects.json"))
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                out.add(
                    MarvelObject(
                        name = o.optString("name"),
                        description = o.optString("description"),
                        imageResId = drawableId(ctx, o.optString("image")),
                        fullName = o.optString("fullName"),
                        bio = o.optString("bio"),
                        movies = o.drawableIds(ctx, "movies"),
                        gallery = o.drawableIds(ctx, "gallery")
                    )
                )
            }
        } catch (e: Exception) {
            Log.e(TAG, "objects.json: ${e.message}")
        }
        return out
    }

    // -----------------------------------------------------------------
    //  Questions
    // -----------------------------------------------------------------
    fun loadQuestions(ctx: Context): List<Question> {
        val out = mutableListOf<Question>()
        try {
            val arr = JSONArray(readAsset(ctx, "questions.json"))
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                out.add(
                    Question(
                        text = o.optString("text"),
                        options = o.stringList("options"),
                        correctAnswerIndex = o.optInt("correctAnswerIndex"),
                        category = o.optString("category")
                    )
                )
            }
        } catch (e: Exception) {
            Log.e(TAG, "questions.json: ${e.message}")
        }
        return out
    }

    // -----------------------------------------------------------------
    //  Realisateurs
    // -----------------------------------------------------------------
    fun loadDirectors(ctx: Context): List<Realisateur> {
        val out = mutableListOf<Realisateur>()
        try {
            val arr = JSONArray(readAsset(ctx, "directors.json"))
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                out.add(
                    Realisateur(
                        prenom = o.optString("prenom"),
                        nom = o.optString("nom"),
                        dateNaissance = o.optString("dateNaissance"),
                        dateDeces = o.optString("dateDeces"),
                        nationalite = o.optString("nationalite")
                    )
                )
            }
        } catch (e: Exception) {
            Log.e(TAG, "directors.json: ${e.message}")
        }
        return out
    }
}
