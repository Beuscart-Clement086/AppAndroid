package com.example.quizapp

data class MarvelObject(
    val name: String,
    val description: String,
    val imageResId: Int,
    val fullName: String = "",
    val bio: String = "",
    val movies: List<Int> = emptyList(),
    val gallery: List<Int> = emptyList()
)