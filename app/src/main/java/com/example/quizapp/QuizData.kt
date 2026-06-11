// QuizData.kt
package com.example.quizapp


data class Question(
    val id: Int = 0,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val category: String = ""
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
                    text = "Quel est le vrai nom d'Iron Man ?",
                    options = listOf("Steve Rogers", "Tony Stark", "Bruce Banner", "Clint Barton"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom du marteau de Thor ?",
                    options = listOf("Stormbreaker", "Mjolnir", "Gungnir", "Excalibur"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "De quelle couleur est l'armure de base d'Iron Man ?",
                    options = listOf("Bleue et or", "Rouge et or", "Noire et argent", "Verte et or"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel héros utilise un bouclier en Vibranium ?",
                    options = listOf("Thor", "Iron Man", "Captain America", "Hawkeye"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Comment s'appelle le royaume d'où vient Thor ?",
                    options = listOf("Wakanda", "Asgard", "Xandar", "Sakaar"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel scientifique se transforme en Hulk ?",
                    options = listOf("Tony Stark", "Hank Pym", "Bruce Banner", "Reed Richards"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Comment s'appelle la sœur de Thor ?",
                    options = listOf("Sif", "Hela", "Frigga", "Valkyrie"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel pays dirige Black Panther ?",
                    options = listOf("Nigeria", "Kenya", "Wakanda", "Zamunda"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le vrai nom de Black Widow ?",
                    options = listOf("Natasha Romanoff", "Wanda Maximoff", "Maria Hill", "Sharon Carter"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Qui est le père adoptif de Thor ?",
                    options = listOf("Heimdall", "Loki", "Odin", "Bor"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel Avenger est un archer ?",
                    options = listOf("War Machine", "Hawkeye", "Falcon", "Vision"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Comment s'appelle l'assistant IA de Tony Stark ?",
                    options = listOf("JARVIS", "FRIDAY", "HOMER", "ZEUS"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel métal rare est exclusif au Wakanda ?",
                    options = listOf("Adamantium", "Titane", "Vibranium", "Palladium"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Qui a créé les Avengers ?",
                    options = listOf("Tony Stark", "Nick Fury", "Steve Rogers", "Phil Coulson"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le vrai nom de Spider-Man dans le MCU ?",
                    options = listOf("Miles Morales", "Peter Parker", "Ben Reilly", "Miguel O'Hara"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans quelle ville vit Peter Parker ?",
                    options = listOf("Gotham", "Metropolis", "New York", "Chicago"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel personnage dit 'Je suis Iron Man' à la fin d'Endgame ?",
                    options = listOf("Steve Rogers", "Thor", "Tony Stark", "Nick Fury"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Comment s'appelle le frère adoptif de Thor ?",
                    options = listOf("Balder", "Loki", "Tyr", "Vidar"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel film MCU est sorti en premier ?",
                    options = listOf("Thor", "Iron Man", "The Incredible Hulk", "Captain America"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quelle pierre de l'infini est de couleur verte ?",
                    options = listOf("Pierre du temps", "Pierre de l'espace", "Pierre de la réalité", "Pierre du temps"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Comment s'appelle la combinaison d'Ant-Man ?",
                    options = listOf("Pym Suit", "Ant Suit", "Yellowjacket", "Scott Suit"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Qui joue Thor dans le MCU ?",
                    options = listOf("Chris Evans", "Chris Pratt", "Chris Hemsworth", "Chris Pine"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Qui joue Captain America dans le MCU ?",
                    options = listOf("Chris Hemsworth", "Chris Evans", "Chris Pratt", "Jeremy Renner"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom du chien de Hawkeye ?",
                    options = listOf("Lucky", "Buddy", "Max", "Rex"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quelle organisation secrète emploie Black Widow ?",
                    options = listOf("HYDRA", "AIM", "SHIELD", "SWORD"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel héros peut rétrécir et grandir à volonté ?",
                    options = listOf("Wasp", "Ant-Man", "Les deux", "Hawkeye"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Comment s'appelle la ville où se trouve le Sanctum Sanctorum ?",
                    options = listOf("Los Angeles", "Chicago", "New York", "Boston"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quelle pierre de l'infini était dans le Tesseract ?",
                    options = listOf("Pierre du pouvoir", "Pierre de l'espace", "Pierre du temps", "Pierre de l'âme"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Qui est Groot ?",
                    options = listOf("Un robot", "Un humain mutant", "Un être de Sakaar", "Un être arboricole extraterrestre"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Quel est le surnom de Rocket dans les Gardiens de la Galaxie ?",
                    options = listOf("Rocket le raton laveur", "Rocket le renard", "Rocket le robot", "Rocket l'alien"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Comment s'appelle la mère de Peter Parker ?",
                    options = listOf("Mary Parker", "May Parker", "Martha Parker", "Margaret Parker"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Qui est l'ennemi principal dans The Avengers (2012) ?",
                    options = listOf("Thanos", "Ultron", "Loki", "Ronan"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quelle est la couleur de la pierre de l'infini du pouvoir ?",
                    options = listOf("Bleue", "Rouge", "Violette", "Jaune"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel héros MCU est médecin avant de devenir super-héros ?",
                    options = listOf("Bruce Banner", "Doctor Strange", "Hank Pym", "Les deux premiers"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Comment s'appelle le vaisseau des Gardiens de la Galaxie ?",
                    options = listOf("Le Destroyer", "Le Milano", "L'Espace", "Le Benatar"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel métal compose les griffes de Wolverine ? (pas MCU mais Marvel)",
                    options = listOf("Vibranium", "Titane", "Adamantium", "Acier"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Qui est la tante de Peter Parker ?",
                    options = listOf("Tante May", "Tante Anna", "Tante June", "Tante Mary"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel acteur joue Nick Fury ?",
                    options = listOf("Idris Elba", "Samuel L. Jackson", "Chiwetel Ejiofor", "Mahershala Ali"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Combien y a-t-il de pierres de l'infini ?",
                    options = listOf("4", "5", "6", "7"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le vrai nom de War Machine ?",
                    options = listOf("James Rhodes", "Sam Wilson", "Bucky Barnes", "Scott Lang"),
                    correctAnswerIndex = 0
                )
            )
        ),
        DifficultyCategory(
            name = "Moyen",
            questions = listOf(
                Question(
                    text = "Quel est le nom de l'organisation terroriste ennemie du SHIELD ?",
                    options = listOf("AIM", "HYDRA", "SWORD", "HAMMER"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans quel film apparaît le personnage de Shang-Chi pour la première fois ?",
                    options = listOf("Doctor Strange", "Black Panther", "Shang-Chi et la Légende des Dix Anneaux", "Eternals"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quelle pierre de l'infini Doctor Strange possède-t-il ?",
                    options = listOf("Pierre du pouvoir", "Pierre de l'âme", "Pierre du temps", "Pierre de l'espace"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Comment s'appelle le père de Peter Quill (Star-Lord) ?",
                    options = listOf("Thanos", "Ego", "Yondu", "Ronan"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel personnage dit 'We don't trade lives' ?",
                    options = listOf("Thor", "Iron Man", "Captain America", "Vision"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans quel pays se déroule principalement Black Panther ?",
                    options = listOf("Nigeria", "Kenya", "Wakanda", "Éthiopie"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Qui a forgé Stormbreaker ?",
                    options = listOf("Les nains de Nidavellir", "Les elfes noirs", "Tony Stark", "Odin"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quelle est la phrase signature de Groot ?",
                    options = listOf("Je suis Groot", "I am Groot", "Nous sommes Groot", "Groot"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Qui est Thanos dans l'univers Marvel ?",
                    options = listOf("Un dieu asgardien", "Un titan fou", "Un Kree", "Un Skrull"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel héros a été congelé pendant 70 ans ?",
                    options = listOf("Iron Man", "Thor", "Captain America", "Hawkeye"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Comment s'appelle le mentor de Doctor Strange ?",
                    options = listOf("Agatha Harkness", "L'Ancien", "Wong", "Mordo"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans Infinity War, où se trouve la pierre de l'âme ?",
                    options = listOf("Vormir", "Xandar", "Asgard", "La Terre"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel personnage sacrifie sa vie pour obtenir la pierre de l'âme dans Endgame ?",
                    options = listOf("Thor", "Captain America", "Black Widow", "Hawkeye"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Comment s'appelle le plan de Tony Stark pour protéger la Terre dans Avengers 2 ?",
                    options = listOf("Project Insight", "Project Ultron", "Ultron Program", "Iron Legion"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Qui est le Mandarin dans Iron Man 3 ?",
                    options = listOf("Un vrai terroriste", "Un acteur nommé Trevor Slattery", "Aldrich Killian", "Ho Yinsen"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel héros MCU vient de Nouvelle-Zélande (Kiwi) dans la vraie vie ?",
                    options = listOf("Chris Evans", "Chris Pratt", "Chris Hemsworth", "Tom Holland"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Comment s'appelle la version féminine de Thor dans Love and Thunder ?",
                    options = listOf("Lady Thor", "Mighty Thor", "Jane Thor", "Thor Girl"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom du cheval de Thor dans Love and Thunder ?",
                    options = listOf("Sleipnir", "Toothgrinder", "Arvak", "Shadowmere"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Qui est Mysterio dans Spider-Man Far From Home ?",
                    options = listOf("Un vrai héros", "Un villain déguisé en héros", "Un alien", "Un robot"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le vrai nom de Falcon ?",
                    options = listOf("James Rhodes", "Sam Wilson", "Bucky Barnes", "Scott Lang"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans quel film Tony Stark dit-il 'I am Iron Man' pour la première fois publiquement ?",
                    options = listOf("Iron Man 2", "The Avengers", "Iron Man", "Captain America Civil War"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le nom du programme qui a créé Captain America ?",
                    options = listOf("Operation Rebirth", "Super Soldier Program", "Project Erskine", "Vita Ray Program"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Combien de temps dure le snap de Thanos avant d'être inversé ?",
                    options = listOf("3 ans", "5 ans", "10 ans", "1 an"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Qui est le premier personnage à soulever Mjolnir en dehors de Thor dans le MCU ?",
                    options = listOf("Iron Man", "Vision", "Captain America", "Hulk"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans quel film apparaissent les Eternals ?",
                    options = listOf("Eternals (2021)", "Infinity War", "Endgame", "Doctor Strange 2"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Qui joue Black Panther dans le MCU ?",
                    options = listOf("Idris Elba", "Michael B. Jordan", "Chadwick Boseman", "Lupita Nyong'o"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le nom du méchant dans Black Panther ?",
                    options = listOf("Killmonger", "Klaw", "M'Baku", "Zemo"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Qui est le vrai Spider-Man que Peter Parker rencontre dans No Way Home ?",
                    options = listOf("Miles Morales", "Ben Reilly", "Tobey Maguire et Andrew Garfield", "Miguel O'Hara"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quelle est la capacité principale de Wanda Maximoff ?",
                    options = listOf("Télépathie uniquement", "Magie du chaos et télékinésie", "Super force", "Contrôle du temps"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom de la ville fictive de WandaVision ?",
                    options = listOf("Westfield", "Westview", "Westbrook", "Westhaven"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Qui est Agatha Harkness dans WandaVision ?",
                    options = listOf("Une voisine innocente", "Une sorcière manipulatrice", "Une agente du SHIELD", "La mère de Wanda"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans quel film Captain America dit-il 'Avengers Assemble' pour la première fois clairement ?",
                    options = listOf("Avengers 2012", "Infinity War", "Endgame", "Civil War"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le vrai nom de Hawkeye ?",
                    options = listOf("Clint Barton", "Phil Coulson", "Nick Fury", "Brock Rumlow"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Qui est la fille adoptive de Thanos ?",
                    options = listOf("Nebula", "Gamora", "Les deux", "Mantis"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le nom du village natal de Black Widow ?",
                    options = listOf("Stalingrad", "Volgograd", "Elle n'a pas de village natal connu", "Moscou"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel personnage MCU est un ancien militaire devenu Faucon puis Captain America ?",
                    options = listOf("Rhodey", "Bucky", "Sam Wilson", "Nick Fury"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le nom de l'intelligence artificielle dans la série WandaVision ?",
                    options = listOf("JARVIS", "FRIDAY", "VISION", "Il n'y en a pas"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Dans Guardians of the Galaxy, quelle cassette Peter Quill écoute-t-il ?",
                    options = listOf("Awesome Mix Vol. 1", "Awesome Mix Vol. 2", "Star-Lord's Mix", "Galaxy Mix"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Qui est le grand méchant dans Thor Ragnarok ?",
                    options = listOf("Loki", "Surtur", "Hela", "Grand Maître"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel acteur joue Loki dans le MCU ?",
                    options = listOf("Benedict Cumberbatch", "Tom Hiddleston", "Chris Hemsworth", "Idris Elba"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quelle est la couleur de la pierre de l'infini du temps ?",
                    options = listOf("Verte", "Bleue", "Rouge", "Jaune"),
                    correctAnswerIndex = 0
                )
            )
        ),
        DifficultyCategory(
            name = "Difficile",
            questions = listOf(
                Question(
                    text = "Quel est le numéro de la variante de Loki dans la série Loki ?",
                    options = listOf("L1130", "L1130", "L6661", "D-90"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Doctor Strange, quel est le nom du tome de magie interdit ?",
                    options = listOf("Darkhold", "Vishanti Book", "Tome of Agamotto", "Book of Shadows"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Combien de futurs Doctor Strange voit-il dans lesquels les Avengers gagnent ?",
                    options = listOf("1 sur 14 millions", "1 sur 10 millions", "2 sur 14 millions", "0"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le vrai nom de Yellowjacket dans Ant-Man ?",
                    options = listOf("Bill Foster", "Darren Cross", "Elihas Starr", "Mitchell Carson"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom du TVA dans la série Loki ?",
                    options = listOf("Time Variance Agency", "Time Variance Authority", "Temporal Variance Authority", "Timeline Variance Administration"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans quel ordre chronologique se passe Endgame par rapport à Infinity War ?",
                    options = listOf("Même année", "3 ans après", "5 ans après", "10 ans après"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Qui est He Who Remains dans la série Loki ?",
                    options = listOf("Kang le Conquérant", "Une variante de Kang", "Loki du futur", "Un gardien du temps"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le vrai nom de Ronan dans Guardians of the Galaxy ?",
                    options = listOf("Ronan le Conquérant", "Ronan l'Accusateur", "Ronan le Destructeur", "Ronan le Kree"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quelle est la vraie identité de l'Élu dans Shang-Chi ?",
                    options = listOf("Wenwu", "Shang-Chi lui-même", "Xu Xialing", "Morris"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Captain America Civil War, combien d'États ont signé les Accords de Sokovie ?",
                    options = listOf("100", "117", "150", "196"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom du programme secret russe qui a formé Black Widow ?",
                    options = listOf("Red Room", "Black Room", "Winter Program", "Red Ledger"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Thor Dark World, quel est le nom de l'arme de Malekith ?",
                    options = listOf("Aether", "Ether", "Éther noir", "Dark Matter"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le vrai nom de Nébula avant d'être modifiée par Thanos ?",
                    options = listOf("Son vrai nom n'est jamais révélé", "Luphomoid", "Xandarian", "Kree"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quelle technologie Tony Stark invente-t-il dans Endgame pour le voyage temporel ?",
                    options = listOf("Tunnel quantique portable", "Arc temporel", "Vortex GPS", "Time GPS"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Qui est le vrai fondateur d'HYDRA dans le MCU ?",
                    options = listOf("Red Skull", "MODOK", "Arnim Zola", "Pierce"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le nom de la planète natale de Thanos ?",
                    options = listOf("Xandar", "Titan", "Sakaar", "Vormir"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans Iron Man 3, quel est le nom du virus/sérum utilisé par Killian ?",
                    options = listOf("Extremis", "Centipede", "GH325", "Neurotoxin"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le nom de l'agent SHIELD qui meurt dans The Avengers et motive les héros ?",
                    options = listOf("Nick Fury", "Maria Hill", "Phil Coulson", "Jasper Sitwell"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Combien de personnalités Bruce Banner avait-il dans She-Hulk ?",
                    options = listOf("2", "3", "7", "Illimité"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le nom du village sokovien détruit dans Age of Ultron ?",
                    options = listOf("Novi Grad", "Sokovia City", "Sikovian", "Strucker"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Captain Marvel, quel est le vrai nom de Captain Marvel ?",
                    options = listOf("Carol Danvers", "Monica Rambeau", "Maria Rambeau", "Vers"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel Éternel a le pouvoir de projeter des rayons cosmiques par les yeux ?",
                    options = listOf("Ikaris", "Ajak", "Gilgamesh", "Kingo"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le nom de la prison de haute sécurité dans le MCU où sont envoyés les super-vilains ?",
                    options = listOf("The Raft", "The Vault", "The Cube", "The Sandbox"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Ant-Man and the Wasp, qui est Ghost ?",
                    options = listOf("Ava Starr", "Janet Van Dyne", "Cassie Lang", "Hannah Pym"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le surnom donné à la bataille de New York dans le MCU ?",
                    options = listOf("La Catastrophe", "L'Incident", "La Guerre", "Le Chaos"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans Thor Ragnarok, qui est le Grand Maître ?",
                    options = listOf("Jeff Goldblum", "Benicio del Toro", "Kurt Russell", "Taika Waititi"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quelle est la source des pouvoirs de Wanda selon Doctor Strange 2 ?",
                    options = listOf("Magie du chaos naturelle", "Pierres de l'infini", "Darkhold", "HYDRA"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le nom du satellite SHIELD détruit dans Captain America 2 ?",
                    options = listOf("Insight", "Project Insight - Héliporteur", "Helicarrier Alpha", "Project Shield"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Qui a tué les parents de Tony Stark en réalité ?",
                    options = listOf("Red Skull", "HYDRA directement", "Le Soldat de l'Hiver / Bucky Barnes", "Ivan Vanko"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel personnage de la bande dessinée est joué par Stan Lee dans Iron Man ?",
                    options = listOf("Hugh Hefner", "Larry King", "Bob Hope", "Lui-même"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Eternals, combien d'Éternels sont envoyés sur Terre ?",
                    options = listOf("8", "10", "12", "7"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom du Déviant principal dans Eternals ?",
                    options = listOf("Kro", "Tiamut", "Arishem", "Druig"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Falcon and the Winter Soldier, qui devient le nouveau Captain America au début ?",
                    options = listOf("Sam Wilson", "John Walker", "Bucky Barnes", "Steve Rogers"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le vrai nom de l'actrice qui joue Scarlet Witch ?",
                    options = listOf("Elizabeth Olsen", "Emma Stone", "Emily Blunt", "Eva Green"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans quel film voit-on pour la première fois Thanos avec le gant complet ?",
                    options = listOf("Age of Ultron post-credits", "Infinity War", "Endgame", "Guardians 2"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Qui est Talos dans Captain Marvel ?",
                    options = listOf("Un Kree", "Un Skrull leader", "Un agent SHIELD", "Un Titan"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le pouvoir principal d'Ikaris parmi les Éternels ?",
                    options = listOf("Vol et rayons cosmiques", "Télépathie", "Super force uniquement", "Manipulation de matière"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le nom du dirigeant des Célestes dans Eternals ?",
                    options = listOf("Tiamut", "Arishem", "Ego", "Galactus"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans No Way Home, combien de Spider-Men apparaissent ?",
                    options = listOf("1", "2", "3", "4"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Qui est Maya Lopez dans la série Hawkeye ?",
                    options = listOf("Echo", "White Tiger", "Silk", "Spider-Woman"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le nom du programme de super-soldats soviétiques dans Black Widow ?",
                    options = listOf("Red Guardian Program", "Red Room / Widow Program", "Winter Soldier Program", "Soviet Avengers"),
                    correctAnswerIndex = 1
                )
            )
        ),
        DifficultyCategory(
            name = "Impossible",
            questions = listOf(
                Question(
                    text = "Quel est le numéro de la timeline sacrée dans la série Loki selon le TVA ?",
                    options = listOf("Il n'y a qu'une seule timeline", "Timeline Alpha-1", "La Sacrée Timeline", "Timeline Principale"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans les comics, qui est le créateur original de l'Infinity Gauntlet ?",
                    options = listOf("Thanos lui-même", "Les nains de Nidavellir", "Les Célestes", "Eitri"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le vrai nom de l'acteur qui joue Thanos en motion capture ?",
                    options = listOf("Andy Serkis", "Josh Brolin", "James Spader", "Vin Diesel"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Combien de post-credit scenes y a-t-il dans le premier Avengers ?",
                    options = listOf("1", "2", "3", "0"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom exact du sort utilisé par Doctor Strange dans No Way Home pour que tout le monde oublie Peter Parker ?",
                    options = listOf("Tabula Rasa", "Mundus Tollens", "Le sort n'a pas de nom officiel dans le film", "Obliviate"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans Infinity War, dans quel ordre exact Thanos récupère-t-il les pierres ?",
                    options = listOf("Espace, Réalité, Pouvoir, Âme, Temps, Mental", "Pouvoir, Espace, Réalité, Âme, Temps, Mental", "Espace, Mental, Réalité, Âme, Temps, Pouvoir", "Réalité, Pouvoir, Espace, Âme, Temps, Mental"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le matricule exact de Captain America dans l'armée américaine ?",
                    options = listOf("29557038", "11B-1-2834-A", "1-A-1918-R", "Rogers-S-1918"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Combien de variantes de Loki apparaissent dans la série Loki saison 1 ?",
                    options = listOf("3", "4", "5", "6"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le nom complet de l'organisation derrière la création de HYDRA dans le MCU ?",
                    options = listOf("HYDRA n'a pas de nom complet", "Wissenschaft Abteilung", "Hydra Terroristen Organisation", "HYDRA est déjà un acronyme non développé dans le MCU"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Dans quel épisode précis de WandaVision Agatha révèle-t-elle sa vraie nature ?",
                    options = listOf("Épisode 6", "Épisode 7", "Épisode 8", "Épisode 9"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quelle est la fréquence exacte de la balise utilisée par Nick Fury à la fin d'Infinity War ?",
                    options = listOf("Elle n'est pas précisée", "87.4 MHz", "Shield Frequency Alpha", "Frequency Captain Marvel"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel réalisateur a failli diriger Avengers avant Joss Whedon ?",
                    options = listOf("Jon Favreau", "Edgar Wright", "Zak Penn", "Kenneth Branagh"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans Iron Man, quel est le nom exact de la réacteur arc original de Tony Stark (modèle) ?",
                    options = listOf("Arc Reactor Mark I", "Palladium Arc Reactor", "Stark Arc Reactor v1", "Il n'a pas de nom officiel dans le film"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Combien de fois Tony Stark meurt-il ou failli mourir dans les films MCU ?",
                    options = listOf("3", "5", "7", "Plus de 8"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Quel est le nom du projet secret du SHIELD qui a ressuscité Coulson ?",
                    options = listOf("Project T.A.H.I.T.I.", "Project Lazarus", "Project Phoenix", "Project Rebirth"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans The Incredible Hulk, quelle université Bruce Banner visite-t-il au Brésil ?",
                    options = listOf("Universidade Estadual de Campinas", "Universidade Federal do Rio", "Universidade de Brasília", "Il travaille dans une usine, pas une université"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Quelle est la durée exacte du film le plus long du MCU ?",
                    options = listOf("Avengers Endgame - 3h01", "Avengers Infinity War - 2h49", "Avengers Endgame - 3h02", "Avengers Endgame - 2h59"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel est le numéro de chambre dans lequel Tony Stark est hospitalisé dans Iron Man 3 ?",
                    options = listOf("Il n'est pas hospitalisé", "Chambre 42", "Il n'y a pas de numéro précisé", "Chambre 1"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans Guardians of the Galaxy, combien valent les 4 milliards de crédits de la prime sur Peter Quill ?",
                    options = listOf("C'est une petite somme dans l'univers", "C'est une fortune astronomique", "Équivalent à 40 000 dollars", "La valeur n'est jamais comparée"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Quel est le nom de la technique de combat que Natasha Romanoff utilise le plus souvent ?",
                    options = listOf("Krav Maga uniquement", "Sambo russe combiné à plusieurs arts martiaux", "Jiu-jitsu brésilien", "Taekwondo"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans Age of Ultron, quel compositeur a créé le thème musical d'Ultron ?",
                    options = listOf("Alan Silvestri", "Brian Tyler et Danny Elfman", "Hans Zimmer", "John Williams"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Combien de scènes post-générique contient Thor Love and Thunder ?",
                    options = listOf("0", "1", "2", "3"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans Captain America First Avenger, quel est le nom du scientifique qui a créé le sérum du super-soldat ?",
                    options = listOf("Howard Stark", "Abraham Erskine", "Arnim Zola", "Johann Schmidt"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le poids approximatif de Mjolnir selon les déclarations dans le MCU ?",
                    options = listOf("Il est sans poids pour celui qui en est digne", "42.3 livres", "Il n'a pas de poids physique défini dans le MCU", "Infini"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans quel film MCU voit-on pour la première fois la salle du trône d'Asgard en détail ?",
                    options = listOf("Thor (2011)", "Thor Dark World", "Thor Ragnarok", "Avengers Endgame"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Quel acteur devait initialement jouer Iron Man avant Robert Downey Jr ?",
                    options = listOf("Tom Cruise", "Nicolas Cage", "Plusieurs acteurs ont été considérés dont Tom Cruise", "Hugh Jackman"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans Eternals, combien d'années les Éternels ont-ils passé sur Terre ?",
                    options = listOf("1000 ans", "5000 ans", "7000 ans", "10 000 ans"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le nom du bar dans lequel Steve Rogers retrouve Peggy Carter à la fin d'Endgame ?",
                    options = listOf("Il n'y a pas de bar, c'est chez Peggy", "Un bal de l'époque", "Le Stork Club", "Il n'y a pas de lieu précisé"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Combien de films le MCU comptait-il officiellement à la fin de la Phase 4 ?",
                    options = listOf("23", "28", "30", "33"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le nom du réalisateur de la série complète Avengers (tous les films) ?",
                    options = listOf("Joss Whedon pour tous", "Les frères Russo pour tous", "Personne n'a réalisé tous les films Avengers", "Kevin Feige"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans Doctor Strange in the Multiverse of Madness, quel est le nom de la terre alternative principale visitée ?",
                    options = listOf("Earth-616", "Earth-838", "Earth-199999", "Earth-1"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quelle est la seule pierre de l'infini qui n'apparaît pas physiquement dans un film Phase 1 du MCU ?",
                    options = listOf("Pierre de l'âme", "Pierre du temps", "Pierre du pouvoir", "Pierre de la réalité"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Infinity War, combien de temps Doctor Strange a-t-il regardé dans l'avenir ?",
                    options = listOf("Quelques secondes", "1 heure dans sa tête", "Il a vu 14 005 605 futurs possibles", "Il ne précise pas la durée"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Quel est le nom exact de la combinaison de Spider-Man faite par Tony Stark ?",
                    options = listOf("Iron Spider", "Stark Spider Suit", "Spider Armor Mark IV", "Advanced Tech Suit"),
                    correctAnswerIndex = 0
                ),
                Question(
                    text = "Dans Hawkeye, quel est le nom de la montre retrouvée dans le bunker des Avengers ?",
                    options = listOf("La montre de Natasha", "La montre de Laura Barton / Agent 19", "La montre de Nick Fury", "La montre de Coulson"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Quel est le vrai nom de Crossbones dans Captain America Civil War ?",
                    options = listOf("Jack Rollins", "Brock Rumlow", "Jasper Sitwell", "Rumlow Brock"),
                    correctAnswerIndex = 1
                ),
                Question(
                    text = "Dans Thor, quel est le nom du garde du corps de Thor qui reste sur Terre ?",
                    options = listOf("Volstagg", "Fandral", "Hogun", "Sif"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Quel est le budget de production estimé d'Avengers Endgame ?",
                    options = listOf("200 millions", "300 millions", "356 millions", "400 millions"),
                    correctAnswerIndex = 2
                ),
                Question(
                    text = "Dans quel ordre exact les Gardiens de la Galaxie originaux se rejoignent-ils dans le premier film ?",
                    options = listOf("Peter, Gamora, Rocket, Groot, Drax", "Peter, Rocket, Groot, Gamora, Drax", "Gamora, Peter, Drax, Rocket, Groot", "Tous en même temps en prison"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Quel est le nom du navire amiral de Thanos dans Infinity War ?",
                    options = listOf("Le Sanctuaire II", "Le Titan II", "Le Leviathan", "Le Sanctuary II"),
                    correctAnswerIndex = 3
                ),
                Question(
                    text = "Combien de post-credits scenes y a-t-il au total dans tous les films MCU Phase 1 ?",
                    options = listOf("5", "7", "9", "11"),
                    correctAnswerIndex = 2
                )
            )
        )








    )


    fun getCategoryByName(name: String): DifficultyCategory? {
        return categories.find { it.name == name }
    }
}