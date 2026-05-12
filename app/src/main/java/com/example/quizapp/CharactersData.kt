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
                    R.drawable.poster_avengers_1,
                    R.drawable.poster_iron_man_2,
                    R.drawable.poster_iron_man_3
                ),
                gallery = listOf(
                    R.drawable.gallery_iron_man_1,
                    R.drawable.gallery_iron_man_2,
                    R.drawable.gallery_iron_man_3,
                    R.drawable.gallery_iron_man_4,
                    R.drawable.gallery_iron_man_5,
                    R.drawable.gallery_iron_man_6,
                    R.drawable.gallery_iron_man_7,
                    R.drawable.gallery_iron_man_8,
                    R.drawable.gallery_iron_man_9,
                    R.drawable.gallery_iron_man_10,
                    R.drawable.gallery_iron_man_11,
                    R.drawable.gallery_iron_man_12
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
                    R.drawable.gallery_thor_1,
                    R.drawable.gallery_thor_2,
                    R.drawable.gallery_thor_3,
                    R.drawable.gallery_thor_4,
                    R.drawable.gallery_thor_5,
                    R.drawable.gallery_thor_6,
                    R.drawable.gallery_thor_7,
                    R.drawable.gallery_thor_8,
                    R.drawable.gallery_thor_9,
                    R.drawable.gallery_thor_10,
                    R.drawable.gallery_thor_11,
                    R.drawable.gallery_thor_12
                )
            ),








            Character(
                name = "Black Widow",
                fullName = "Natasha Romanoff",
                description = "Espionne et membre des Avengers",
                bio = "Natasha Romanoff est une ancienne agente du KGB formée dans le programme Red Room. Recrutée par le SHIELD, elle devient l'une des membres les plus efficaces des Avengers grâce à ses compétences en arts martiaux et en espionnage.",
                imageResId = R.drawable.black_widow,
                movies = listOf(
                    R.drawable.poster_iron_man_2,
                    R.drawable.poster_avengers_1,
                    R.drawable.poster_captain_america_2
                ),
                gallery = listOf(
                    R.drawable.gallery_black_widow_1,
                    R.drawable.gallery_black_widow_2,
                    R.drawable.gallery_black_widow_3,
                    R.drawable.gallery_black_widow_4,
                    R.drawable.gallery_black_widow_5,
                    R.drawable.gallery_black_widow_6,
                    R.drawable.gallery_black_widow_7,
                    R.drawable.gallery_black_widow_8,
                    R.drawable.gallery_black_widow_9,
                    R.drawable.gallery_black_widow_10,
                    R.drawable.gallery_black_widow_11,
                    R.drawable.gallery_black_widow_12
                )
            ),




            Character(
                name = "Hawkeye",
                fullName = "Clinton Francis Barton",
                description = "Archer d'élite et membre des Avengers",
                bio = "Clint Barton est un archer d'une précision extraordinaire. Agent du SHIELD, il rejoint les Avengers et, malgré l'absence de superpouvoirs, s'impose comme l'un des membres les plus fiables de l'équipe grâce à son sang-froid et son expérience.",
                imageResId = R.drawable.hawkeye,
                movies = listOf(
                    R.drawable.poster_avengers_1,
                    R.drawable.poster_avengers_2
                ),
                gallery = listOf(
                    R.drawable.gallery_hawkeye_1,
                    R.drawable.gallery_hawkeye_2,
                    R.drawable.gallery_hawkeye_3,
                    R.drawable.gallery_hawkeye_4,
                    R.drawable.gallery_hawkeye_5,
                    R.drawable.gallery_hawkeye_6,
                    R.drawable.gallery_hawkeye_7,
                    R.drawable.gallery_hawkeye_8,
                    R.drawable.gallery_hawkeye_9,
                    R.drawable.gallery_hawkeye_10,
                    R.drawable.gallery_hawkeye_11,
                    R.drawable.gallery_hawkeye_12
                )
            ),




            Character(
                name = "Hulk",
                fullName = "Robert Bruce Banner",
                description = "Scientifique renommé abritant à l'intérieur de lui un monstre alimentée par la rage, Hulk",
                bio = "Le docteur Robert Bruce Banner, M.D., Ph.D., est un scientifique renommé et un membre fondateur des Avengers. En tant que personne très respectée pour son travail sur la biochimie, la physique nucléaire et le rayonnement gamma, Thaddeus Ross lui a demandé de recréer le sérum de super soldat qui a créé Captain America, bien que Ross ait choisi de ne pas informer Banner de ce qu'il créait. Cependant, quand une exposition à des niveaux élevés de rayons gamma au lieu de rayons vita a mal tourné, le scientifique aux manières douces a découvert que lorsqu'il était en colère, provoqué ou excité, il se transformerait en une énorme créature presque fougueuse, alimentée par la rage, connue sous le nom de Hulk.\n" +
                        "\n" +
                        "Craignant les dommages que Hulk pourrait infliger ainsi que sa fuite du gouvernement américain, Banner tenta de se suicider ; lorsque la tentative a échoué, il a choisi de vivre une vie discrète en Amérique du Sud tout en communiquant avec Samuel Sterns pour se guérir. Cependant, lorsque le général Ross a envoyé une équipe dirigée par Emil Blonsky pour appréhender Banner, il a ensuite été contraint de retourner à New York où il a recruté l'aide de Betty Ross et Sterns pour le guérir de son affliction. Banner a été appréhendé par les forces armées peu de temps après, mais Blonsky, qui avait reçu une variante du sérum du super soldat, a reçu du sang irradié aux rayons gamma de Banner, le transformant en Abomination et forçant Ross à permettre à Banner de se transformer en Hulk et de le combattre. avant de permettre à Hulk de s'échapper.\n" +
                        "\n" +
                        "Banner a fui les États-Unis et a consacré son temps à aider les malades et les pauvres. Lorsqu'une menace grandissante exigeait l'expertise scientifique spécialisée de Banner, le S.H.I.E.L.D. l'a recruté, sachant très bien que la force incroyable de l'alter égo de Banner, Hulk, serait un atout supplémentaire pour les Avengers. Banner a été chargé de retrouver le tesseract, en travaillant avec Tony Stark pour y parvenir. Bien qu'il ait presque causé un désastre quand il a été transformé de force en Hulk par Loki, Banner a rejoint les Avengers pendant la bataille de New York et les a aidés à vaincre Loki et son armée Chitauri. Une fois que les Avengers se sont séparés à la suite de la bataille, Banner était devenu un bon ami de Stark et a déménagé à la tour des Avengers, libre de vivre sa vie sans appréhension.\n" +
                        "\n" +
                        "Dans le sillage du soulèvement de HYDRA, les Avengers se sont regroupés une fois de plus pour combattre la menace toujours croissante d'HYDRA, capturant avec succès Wolfgang von Strucker et reprenant le sceptre. Afin de faire en sorte que la Terre puisse toujours être en sécurité sans avoir constamment besoin des Avengers pour la protéger, Banner a aidé Stark à créer Ultron, une intelligence artificielle. Ultron, programmé pour protéger la Terre à tout prix, considérait l'humanité et les Avengers comme leur plus grande menace et se concentrait sur leur annihilation. Banner a ensuite été enrôlée par Stark pour aider à créer Vision, puis a été persuadée par Black Widow de se transformer en Hulk et d'aider à vaincre Ultron. Après la défaite d'Ultron, Hulk a réquisitionné un Quinjet et a quitté la Terre, volant dans l'espace et traversant un trou de ver qui a provoqué le crash du Quinjet sur la planète Sakaar, où l'environnement stressant l'a empêché de revenir en arrière dans Banner, le faisant rester sous forme de Hulk pendant deux ans.\n" +
                        "\n" +
                        "À Sakaar, il est devenu un gladiateur pour le Grand maître et a rapidement été vénéré en tant que champion bien-aimé, choisissant de tourner le dos à la Terre et de profiter de la vie d'un guerrier admiré. Cependant, lorsque Thor est arrivé sur la planète, Hulk s'est battu contre son vieil ami dans l'arène. À la suite de leur combat, Thor a informé Hulk qu'Asgard était menacé en raison du retour d'Héla. Hulk a aidé les Asgardiens dans leur combat, en battant Fenris et en permettant aux Asgardiens de monter à bord du vaisseau Statesman, et alors que le Ragnarök était déchaîné, les a rejoints lors de leur voyage sur Terre.\n" +
                        "\n" +
                        "Sur le chemin du retour sur Terre, l'homme d'État a été attaqué par l'Ordre noir, qui a tué la moitié des Asgardiens. Hulk a défié leur chef, Thanos, qui l'a battu à fond. Il a ensuite été téléporté au Sanctuaire de New York par Heimdall, où Banner a averti Doctor Strange, Iron Man et plus tard Captain America de l'arrivée de Thanos. Se trouvant incapable de se transformer en Hulk, Banner a utilisé une armure Hulkbuster pour aider les Avengers dans la bataille du Wakanda. Bien que Banner et ses alliés aient réussi à tuer les forces de Thanos, Thanos est personnellement arrivé à Wakanda pour récupérer la pierre mentale. Il a maîtrisé sans effort Banner et les autres héros et a terminé le gant de l'infini, anéantissant la moitié de la population de l'univers, Banner étant l'un des survivants.\n" +
                        "\n" +
                        "Pendant l'éclipse, Banner est allé au Mexique et a travaillé avec Stark pour fusionner sa conscience avec le corps de Hulk pour devenir Smart Hulk, après quoi il est devenu une célébrité adorée. En 2023, il a rejoint les Avengers pour les aider à utiliser les particules de Pym et le royaume quantique pour voyager dans le temps vers des univers alternatifs. Après être retourné à la bataille de New York en 2012, Banner a réussi à acquérir la pierre du temps et est revenu dans le présent. En utilisant le Nano gantelet, Banner a utilisé les pierre pour claquer des doigts, ressuscitant toutes les vies revendiquées par l'éclipse, bien que blessant son bras droit dans le processus. Après avoir participé à la bataille de la Terre, il a assisté aux funérailles de Stark avant de renvoyer Captain America dans le temps pour ramener les pierres dans leurs univers respectifs.\n" +
                        "\n" +
                        "En 2024, Banner avait construit le dispositif inhibiteur de Hulk pour pouvoir reprendre forme humaine et ainsi permettre la guérison de son bras. Aux côtés de Captain Marvel, Banner a été appelé par Wong pour aider à enquêter sur les mystiques dix anneaux que Shang-Chi avait maîtrisés. Après que sa cousine Jennifer Walters ait été en contact avec son sang et ait acquis la capacité de se transformer en Miss Hulk, Banner lui a donné des conseils sur la façon de gérer ses nouvelles capacités avant de quitter la Terre à bord d'un vaisseau sakaarien. Il est ensuite retourné sur Terre pour présenter sa famille à son fils nouvellement découvert, Skaar.",
                imageResId = R.drawable.hulk,
                movies = listOf(
                    R.drawable.poster_avengers_1,
                    R.drawable.poster_avengers_2
                ),
                gallery = listOf(
                    R.drawable.gallery_hawkeye_1,
                    R.drawable.gallery_hawkeye_2,
                    R.drawable.gallery_hawkeye_3,
                    R.drawable.gallery_hawkeye_4,
                    R.drawable.gallery_hawkeye_5,
                    R.drawable.gallery_hawkeye_6,
                    R.drawable.gallery_hawkeye_7,
                    R.drawable.gallery_hawkeye_8,
                    R.drawable.gallery_hawkeye_9,
                    R.drawable.gallery_hawkeye_10,
                    R.drawable.gallery_hawkeye_11,
                    R.drawable.gallery_hawkeye_12
                )
        )







        )
    }
}




