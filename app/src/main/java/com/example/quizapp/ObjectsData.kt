package com.example.quizapp

object ObjectsData {
    fun getObjects(): List<MarvelObject> {
        return listOf(
            MarvelObject(
                name = "Mjolnir",
                fullName = "Mjolnir, le marteau de Thor",
                description = "Marteau magique d'Asgard",
                bio = "Mjolnir est le marteau légendaire forgé par les nains d'Asgard. Il ne peut être manié que par celui qui en est digne. Thor l'utilise pour contrôler la foudre et voler.",
                imageResId = R.drawable.mjolnir,
                movies = listOf(
                    R.drawable.poster_thor,
                    R.drawable.poster_avengers_1
                ),
                gallery = listOf(
                    R.drawable.gallery_mjolnir_1,
                    R.drawable.gallery_mjolnir_2,
                    R.drawable.gallery_mjolnir_3,
                    R.drawable.gallery_mjolnir_4,
                    R.drawable.gallery_mjolnir_5,
                    R.drawable.gallery_mjolnir_6,
                    R.drawable.gallery_mjolnir_7,
                    R.drawable.gallery_mjolnir_8
                )
            ),
            MarvelObject(
                name = "Bouclier Captain America",
                fullName = "Bouclier en Vibranium",
                description = "Bouclier indestructible en Vibranium",
                bio = "Le bouclier de Captain America est fabriqué en Vibranium, le métal le plus résistant au monde. Il peut absorber et rediriger toute forme d'énergie cinétique.",
                imageResId = R.drawable.shield,
                movies = listOf(
                    R.drawable.poster_captain_america,
                    R.drawable.poster_avengers_1
                ),
                gallery = listOf(
                    R.drawable.gallery_shield_1,
                    R.drawable.gallery_shield_2
                )
            )
        ).sortedBy { it.name }
    }
}