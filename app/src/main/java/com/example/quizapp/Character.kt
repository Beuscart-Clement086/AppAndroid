package com.example.quizapp

data class Character(
    val id: Int = 0,
    val name: String,
    val description: String,
    val imageResId: Int,
    val fullName: String,
    val bio: String,
    val movies: List<Int> = emptyList(),
    val gallery: List<Int> = emptyList(),
    val imageUri: String = ""   // chemin d'une image choisie par l'utilisateur (vide = image par defaut)
)