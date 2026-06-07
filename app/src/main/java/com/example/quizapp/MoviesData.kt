package com.example.quizapp

object MoviesData {
    fun getMovies(): List<Movies> {
        return listOf(
            Movies(
                name = "Iron Man",
                fullName = "Iron Man (2008)",
                description = "Le début du MCU",
                phase = "Phase 1",
                bio = "Tony Stark, génie milliardaire, est capturé par des terroristes et construit une armure pour s'échapper. Il devient Iron Man.",
                imageResId = R.drawable.poster_iron_man,
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_iron_man_2,
                    R.drawable.gallery_iron_man_3
                )
            ),
            Movies(
                name = "The Incredible Hulk",
                fullName = "The Incredible Hulk (2008)",
                description = "Bruce Banner en fuite",
                phase = "Phase 1",
                bio = "Bruce Banner, traqué par l'armée américaine, cherche un remède à sa condition tout en tentant de contrôler la bête qui sommeille en lui.",
                imageResId = R.drawable.poster_thor,
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_iron_man_2,
                    R.drawable.gallery_iron_man_3
                )
            ),
            Movies(
                name = "Iron Man 2",
                fullName = "Iron Man 2 (2010)",
                description = "Le retour de Stark",
                phase = "Phase 1",
                bio = "Tony Stark fait face à Ivan Vanko, un génie russe qui cherche à se venger, tandis que le gouvernement tente de lui confisquer son armure.",
                imageResId = R.drawable.poster_iron_man_2,
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_iron_man_2,
                    R.drawable.gallery_iron_man_3
                )
            ),
            Movies(
                name = "Thor",
                fullName = "Thor (2011)",
                description = "Le dieu du tonnerre",
                phase = "Phase 1",
                bio = "Thor, prince arrogant d'Asgard, est banni sur Terre par son père Odin. Il doit apprendre l'humilité pour regagner son pouvoir et Mjolnir.",
                imageResId = R.drawable.poster_thor,
                gallery = listOf(
                    R.drawable.gallery_thor_1,
                    R.drawable.gallery_thor_2,
                    R.drawable.gallery_thor_3
                )
            ),
            Movies(
                name = "Captain America",
                fullName = "Captain America : First Avenger (2011)",
                description = "Le premier Avenger",
                phase = "Phase 1",
                bio = "Steve Rogers devient Captain America grâce au sérum du super-soldat et combat HYDRA pendant la Seconde Guerre Mondiale.",
                imageResId = R.drawable.poster_captain_america,
                gallery = listOf(
                    R.drawable.gallery_captain_america_1,
                    R.drawable.gallery_captain_america_2,
                    R.drawable.gallery_captain_america_3
                )
            ),
            Movies(
                name = "The Avengers",
                fullName = "The Avengers (2012)",
                description = "Les héros s'assemblent",
                phase = "Phase 1",
                bio = "Nick Fury rassemble Iron Man, Captain America, Thor, Hulk, Black Widow et Hawkeye pour stopper l'invasion alien de Loki.",
                imageResId = R.drawable.poster_avengers_1,
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_captain_america_1,
                    R.drawable.gallery_thor_1
                )
            ),
            Movies(
                name = "Iron Man 3",
                fullName = "Iron Man 3 (2013)",
                description = "La chute de Stark",
                phase = "Phase 2",
                bio = "Tony Stark, souffrant d'anxiété post-traumatique, fait face au Mandarin, un mystérieux terroriste qui s'en prend à tout ce qu'il aime.",
                imageResId = R.drawable.poster_iron_man_3,
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_iron_man_2,
                    R.drawable.gallery_iron_man_3
                )
            ),
            Movies(
                name = "Thor : Le Monde des Ténèbres",
                fullName = "Thor : The Dark World (2013)",
                description = "Les elfes noirs",
                phase = "Phase 2",
                bio = "Thor s'allie à Loki pour affronter Malekith et les Elfes Noirs qui menacent de plonger les Neuf Royaumes dans les ténèbres.",
                imageResId = R.drawable.poster_thor_2,
                gallery = listOf(
                    R.drawable.gallery_thor_1,
                    R.drawable.gallery_thor_2,
                    R.drawable.gallery_thor_3
                )
            ),
            Movies(
                name = "Captain America : Le Soldat de l'Hiver",
                fullName = "Captain America : The Winter Soldier (2014)",
                description = "Le complot du SHIELD",
                phase = "Phase 2",
                bio = "Steve Rogers découvre qu'HYDRA a infiltré le SHIELD. Il doit affronter le mystérieux Soldat de l'Hiver dont l'identité va le bouleverser.",
                imageResId = R.drawable.poster_captain_america_2,
                gallery = listOf(
                    R.drawable.gallery_captain_america_1,
                    R.drawable.gallery_captain_america_2,
                    R.drawable.gallery_captain_america_3
                )
            ),
            Movies(
                name = "Gardiens de la Galaxie",
                fullName = "Guardians of the Galaxy (2014)",
                description = "L'aventure spatiale",
                phase = "Phase 2",
                bio = "Peter Quill s'allie à un groupe de hors-la-loi pour former les Gardiens de la Galaxie et empêcher Ronan de détruire une planète.",
                imageResId = R.drawable.poster_guardians_of_the_galaxy,
                gallery = listOf(
                    R.drawable.gallery_thor_1,
                    R.drawable.gallery_thor_2,
                    R.drawable.gallery_thor_3
                )
            ),
            Movies(
                name = "Avengers : L'Ère d'Ultron",
                fullName = "Avengers : Age of Ultron (2015)",
                description = "La menace artificielle",
                phase = "Phase 2",
                bio = "Tony Stark crée Ultron, une IA censée protéger la Terre, qui se retourne contre l'humanité et force les Avengers à s'unir.",
                imageResId = R.drawable.poster_avengers_2,
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_captain_america_1,
                    R.drawable.gallery_thor_1
                )
            ),
            Movies(
                name = "Ant-Man",
                fullName = "Ant-Man (2015)",
                description = "Le plus petit des héros",
                phase = "Phase 2",
                bio = "Scott Lang hérite de la combinaison Ant-Man et doit réaliser un casse impossible pour sauver le monde d'une technologie dangereuse.",
                imageResId = R.drawable.poster_ant_man,
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_iron_man_2,
                    R.drawable.gallery_iron_man_3
                )
            ),
            Movies(
                name = "Captain America : Civil War",
                fullName = "Captain America : Civil War (2016)",
                description = "Les Avengers se divisent",
                phase = "Phase 3",
                bio = "Les Avengers se divisent après les Accords de Sokovie. Iron Man et Captain America s'affrontent, avec l'arrivée de Spider-Man et Black Panther.",
                imageResId = R.drawable.poster_captain_america_3,
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_captain_america_1,
                    R.drawable.gallery_black_widow_1
                )
            )
        ).sortedBy { it.phase }
    }
}