// QuizData.kt
package com.example.quizapp


data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)


data class DifficultyCategory(
    val name: String,
    val questions: List<Question>
)


object QuizData {

    val categories: List<DifficultyCategory> = listOf(
        DifficultyCategory(
            name = "Facile",
            questions = listOf(
                Question(
                    text = "Quelle est la capitale de la France ?",
                    options = listOf("Londres", "Berlin", "Paris", "Madrid"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le résultat de 2 + 2 ?",
                    options = listOf("3", "4", "5", "6"),
                    correctAnswerIndex = 1
                )















            )
        ),
        DifficultyCategory(
            name = "Moyen",
            questions = listOf(
                Question(
                    text = "Quel est le plus long fleuve du monde ?",
                    options = listOf("Nil", "Amazone", "Yangtsé", "Mississippi"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "En quelle année a eu lieu la Révolution française ?",
                    options = listOf("1789", "1899", "1492", "1917"),
                    correctAnswerIndex = 0
                )












            )
        ),
        DifficultyCategory(
            name = "Difficile",
            questions = listOf(
                Question(
                    text = "Quel élément chimique a pour symbole 'Au' ?",
                    options = listOf("Argent", "Or", "Aluminium", "Azote"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Qui a peint la Joconde ?",
                    options = listOf("Van Gogh", "Picasso", "Léonard de Vinci", "Monet"),
                    correctAnswerIndex = 2
                )











            )
        ),
        DifficultyCategory(
            name = "Impossible",
            questions = listOf(
                Question(
                    text = "Quel est le nom du premier satellite artificiel lancé dans l'espace ?",
                    options = listOf("Apollo 11", "Sputnik 1", "Voyager 1", "Hubble"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le plus grand océan du monde ?",
                    options = listOf("Océan Atlantique", "Océan Indien", "Océan Pacifique", "Océan Arctique"),
                    correctAnswerIndex = 2
                )










            )
        )
    )


    fun getCategoryByName(name: String): DifficultyCategory? {
        return categories.find { it.name == name }
    }
}