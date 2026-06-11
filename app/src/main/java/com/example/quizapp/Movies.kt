package com.example.quizapp

data class Movies(
    val id: Int = 0,
    val name: String,
    val description: String,
    val imageResId: Int,
    val fullName: String = "",
    val bio: String = "",
    val phase: String = "",
    val gallery: List<Int> = emptyList(),
    val director: String = ""   // nom complet du realisateur (lien Film -> Realisateur)
)