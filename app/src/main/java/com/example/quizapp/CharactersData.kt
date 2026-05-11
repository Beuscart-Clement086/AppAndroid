package com.example.quizapp

import java.lang.Character

object CharactersData {
    fun getCharacters(): List<com.example.quizapp.Character> {
        return listOf(
            Character(
                name = "Iron Man",
                fullName = "Anthony Edward Stark",
                description = "Génie, milliardaire, play-boy, philanthrope",
                bio = "Tony Stark est un génie de l'ingénierie qui, après avoir été capturé par des terroristes, construit une armure motorisée pour s'échapper. Il devient ensuite le super-héros Iron Man et l'un des membres fondateurs des Avengers.",
                imageResId = R.drawable.iron_man,
                movies = listOf(
                    R.drawable.poster_iron_man,
                    R.drawable.poster_avengers1,
                    R.drawable.poster_iron_man_2,
                    R.drawable.poster_iron_man_3
                ),
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_iron_man_2,
                    R.drawable.gallery_iron_man_3
                )
            ),
            Character(
                name = "Captain America",
                fullName = "Steven Grant Rogers",
                description = "Super-soldat et leader des Avengers",
                bio = "Steve Rogers était un jeune homme chétif de Brooklyn qui, grâce au sérum du super-soldat, devient Captain America. Après avoir été congelé pendant 70 ans, il se réveille dans le monde moderne et continue de défendre la liberté.",
                imageResId = R.drawable.captain_america,
                movies = listOf(
                    R.drawable.poster_captain_america,
                    R.drawable.poster_captain_america_2,
                    R.drawable.poster_captain_america_3
                ),
                gallery = listOf(
                    R.drawable.gallery_captain_america_1,
                    R.drawable.gallery_captain_america_2,
                    R.drawable.gallery_captain_america_3,
                    R.drawable.gallery_captain_america_4,
                    R.drawable.gallery_captain_america_5,
                    R.drawable.gallery_captain_america_6,
                    R.drawable.gallery_captain_america_7,
                    R.drawable.gallery_captain_america_8,
                    R.drawable.gallery_captain_america_9,
                    R.drawable.gallery_captain_america_10,
                    R.drawable.gallery_captain_america_11,
                    R.drawable.gallery_captain_america_12,
                    R.drawable.gallery_captain_america_13,
                    R.drawable.gallery_captain_america_14,
                    R.drawable.gallery_captain_america_15
                )
            ),
            Character(
                name = "Thor",
                fullName = "Thor Odinson",
                description = "Dieu asgardien du tonnerre",
                bio = "Thor est le prince d'Asgard et dieu du tonnerre. Banni sur Terre par son père Odin pour son arrogance, il apprend l'humilité et devient l'un des plus puissants membres des Avengers, armé de son marteau Mjolnir.",
                imageResId = R.drawable.thor,
                movies = listOf(
                    R.drawable.poster_iron_man,
                    R.drawable.poster_iron_man_2,
                    R.drawable.poster_iron_man_3
                ),
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_iron_man_2,
                    R.drawable.gallery_iron_man_3
                )
            )

        )
    }
}




