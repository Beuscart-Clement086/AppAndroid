package com.example.quizapp

data class Character(
    val name: String,
    val description: String,
    val imageResId: Int,
    val fullName: String,
    val bio: String,
    val movies: List<Int> = emptyList(),
    val gallery: List<Int> = emptyList()
)