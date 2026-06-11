package com.example.quizapp

/**
 * Un realisateur. Un film est realise par un seul realisateur,
 * un realisateur peut avoir realise plusieurs films (relation 1 -> N).
 *
 * dateDeces est facultative (vide = encore en vie).
 */
data class Realisateur(
    val id: Int = 0,
    val prenom: String,
    val nom: String,
    val dateNaissance: String = "",
    val dateDeces: String = "",        // vide = encore en vie
    val nationalite: String = "",
    val imageResId: Int = 0,
    val imageUri: String = ""
) {
    /** Nom complet, sert aussi de cle de liaison avec le champ "director" des films. */
    val nomComplet: String
        get() = "$prenom $nom".trim()
}
