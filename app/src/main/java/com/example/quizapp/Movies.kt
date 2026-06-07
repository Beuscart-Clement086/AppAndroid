package com.example.quizapp

data class Movies(
    val name: String,
    val description: String,
    val imageResId: Int,
    val fullName: String = "",
    val bio: String = "",
    val phase: String = "",
    val gallery: List<Int> = emptyList()
)