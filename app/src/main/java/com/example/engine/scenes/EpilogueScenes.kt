package com.example.engine.scenes

import com.example.model.StoryChoice
import com.example.model.StoryScene

object EpilogueScenes {
    val scenes: Map<String, StoryScene> = mapOf(
        "SCENE_EPILOGUE_BRANCH_HUB" to StoryScene(
            id = "SCENE_EPILOGUE_BRANCH_HUB",
            title = "EPÍLOGO: La Encrucijada de Oakhaven",
            narrativeTemplate = "Brutus yace derrotado en el suelo de *'La Jarra Mellada'*. El silencio cae sobre la aldea de Oakhaven. La noticia de la rebelión del joven **{HERO_NAME}** se extiende como pólvora por los caminos del Feudo.\n\nTienes 20 años, una mochila humilde y cuatro caminos totalmente diferentes ante ti. ¿Cuál será el primer gran capítulo de tu leyenda?",
            choices = listOf(
                StoryChoice(
                    id = "choice_epilogue_honor",
                    text = "🛡️ Camino 1: Permanecer en la aldea y jurar como Guardián de Oakhaven",
                    targetSceneId = "SCENE_EPILOGUE_HONOR_OAKHAVEN"
                ),
                StoryChoice(
                    id = "choice_epilogue_mercenary",
                    text = "⚔️ Camino 2: Aceptar la carta de Gideon e unirse a los 'Lobos de Hierro'",
                    targetSceneId = "SCENE_EPILOGUE_MERCENARY_GUILD"
                ),
                StoryChoice(
                    id = "choice_epilogue_outlaw",
                    text = "🌲 Camino 3: Tomar el cofre del recaudador y huir como Proscrito al Bosque",
                    targetSceneId = "SCENE_EPILOGUE_OUTLAW_ROAD"
                ),
                StoryChoice(
                    id = "choice_epilogue_shadows",
                    text = "🗡️ Camino 4: Forjar una alianza secreta con el Gremio de Contrabandistas",
                    targetSceneId = "SCENE_EPILOGUE_SHADOW_PACT"
                )
            )
        ),

        // --- RAMA 1: GUARDIÁN DE OAKHAVEN ---
        "SCENE_EPILOGUE_HONOR_OAKHAVEN" to StoryScene(
            id = "SCENE_EPILOGUE_HONOR_OAKHAVEN",
            title = "Epílogo Rama I: El Guardián del Pueblo",
            narrativeTemplate = "Decides no abandonar Oakhaven. Los aldeanos, cansados de los abusos del Feudo, ven en ti la chispa de la resistencia. Tu padre Garrick te entrega el escudo oxidado de su juventud con lágrimas en los ojos.\n\n—'Si te quedas, **{HERO_NAME}**, el Señor del Feudo enviará soldados de verdad. ¿Cómo prepararás la defensa de nuestra gente?'",
            choices = listOf(
                StoryChoice(
                    id = "choice_honor_militia",
                    text = "🪓 Reclutar a los campesinos y formar la Milicia de Oakhaven",
                    targetSceneId = "SCENE_EPILOGUE_HONOR_END",
                    goldReward = 25,
                    expReward = 75,
                    itemAdded = "Insignia de Capitán de Milicia"
                ),
                StoryChoice(
                    id = "choice_honor_fortify",
                    text = "🏰 Fortificar la Jarra Mellada como bastión defensivo de la aldea",
                    targetSceneId = "SCENE_EPILOGUE_FORTIFY_END",
                    hpChange = 15,
                    goldReward = 15,
                    expReward = 60,
                    itemAdded = "Estandarte de la Taberna"
                )
            )
        ),

        "SCENE_EPILOGUE_HONOR_END" to StoryScene(
            id = "SCENE_EPILOGUE_HONOR_END",
            title = "Final del Epílogo: El Capitán de la Milicia",
            narrativeTemplate = "A tus 20 años, has pasado de fregar jarras a comandar a 30 hombres armados con horcas y hachas. Oakhaven ya no es un feudo sometido; es un bastión de campesinos libres. Tu nombre, **{HERO_NAME}**, es susurrado con veneración.",
            choices = listOf(
                StoryChoice(
                    id = "choice_finish_honor",
                    text = "🚀 Comenzar Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                )
            )
        ),

        "SCENE_EPILOGUE_FORTIFY_END" to StoryScene(
            id = "SCENE_EPILOGUE_FORTIFY_END",
            title = "Final del Epílogo: La Fortaleza de la Jarra Mellada",
            narrativeTemplate = "Convertiste la taberna de tu padre en una fortaleza inexpugnable con vigas de roble y barricadas de barriles. Garrick atiende el mostrador mientras tú vigilas las troneras. Ningún recaudador volverá a pisar esta tierra sin pagar con sangre.",
            choices = listOf(
                StoryChoice(
                    id = "choice_finish_fortify",
                    text = "🚀 Comenzar Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                )
            )
        ),

        // --- RAMA 2: LOBOS DE HIERRO (MERCENARIO) ---
        "SCENE_EPILOGUE_MERCENARY_GUILD" to StoryScene(
            id = "SCENE_EPILOGUE_MERCENARY_GUILD",
            title = "Epílogo Rama II: La Compañía de los Lobos de Hierro",
            narrativeTemplate = "Gideon 'El Tuerto' te estrecha la mano con una sonrisa salvaje. Te firma un pergamino sellado con cera roja.\n\n—'Toma esto, chico. Es una recomendación para el Capitán Vane de la Compañía de los Lobos de Hierro. Acampan en las Tierras Bajas. Si sobrevives a su iniciación, ganarás más oro en un mes que frotando tablas toda tu vida'.",
            choices = listOf(
                StoryChoice(
                    id = "choice_merc_front",
                    text = "⚔️ Enrolarte en la infantería pesada de vanguardia",
                    targetSceneId = "SCENE_EPILOGUE_MERCENARY_END",
                    goldReward = 45,
                    expReward = 80,
                    itemAdded = "Contrato de los Lobos de Hierro"
                ),
                StoryChoice(
                    id = "choice_merc_duel",
                    text = "🤺 Desafiar al sargento reclutador a un duelo para demostrar valía",
                    targetSceneId = "SCENE_EPILOGUE_DUEL_END",
                    hpChange = -15,
                    goldReward = 60,
                    expReward = 95,
                    itemAdded = "Espada Bastarda de Acero"
                )
            )
        ),

        "SCENE_EPILOGUE_MERCENARY_END" to StoryScene(
            id = "SCENE_EPILOGUE_MERCENARY_END",
            title = "Final del Epílogo: El Mercenario Vástago",
            narrativeTemplate = "Marchas al amanecer junto a la columna de mercenarios. Atrás queda la calma de Oakhaven. Ahora eres un **{CLASS}** a sueldo de la Compañía de los Lobos de Hierro. Tu espada está lista para venderse al mejor postor.",
            choices = listOf(
                StoryChoice(
                    id = "choice_finish_merc",
                    text = "🚀 Comenzar Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                )
            )
        ),

        "SCENE_EPILOGUE_DUEL_END" to StoryScene(
            id = "SCENE_EPILOGUE_DUEL_END",
            title = "Final del Epílogo: Campeón de las Tierras Bajas",
            narrativeTemplate = "Tras un sangriento duelo de 10 minutos, logras romper la guardia del sargento reclutador. Sorprendido por tu ferocidad a tus 20 años, te nombra cabo de escuadra antes de pisar el campamento.",
            choices = listOf(
                StoryChoice(
                    id = "choice_finish_duel",
                    text = "🚀 Comenzar Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                )
            )
        ),

        // --- RAMA 3: PROSCRITO DEL BOSQUE ---
        "SCENE_EPILOGUE_OUTLAW_ROAD" to StoryScene(
            id = "SCENE_EPILOGUE_OUTLAW_ROAD",
            title = "Epílogo Rama III: El Proscrito del Bosque de las Brumas",
            narrativeTemplate = "Recoges el cofre de bronce de Brutus con 50 monedas de plata y el libro de contabilidad de extorsiones del Feudo. Sabes que la guardia del Conde te buscará para colgarte. Con la noche como aliada, te adentras en las brumas del Bosque de Oakhaven.",
            choices = listOf(
                StoryChoice(
                    id = "choice_outlaw_robin",
                    text = "🪙 Repartir el tributo robado entre los siervos arruinados",
                    targetSceneId = "SCENE_EPILOGUE_OUTLAW_HERO_END",
                    goldReward = 10,
                    expReward = 110,
                    itemAdded = "Manto del Vengador de las Brumas"
                ),
                StoryChoice(
                    id = "choice_outlaw_greed",
                    text = "💰 Guardar todo el tesoro para comprar armas en el Mercado Negro",
                    targetSceneId = "SCENE_EPILOGUE_OUTLAW_GREED_END",
                    goldReward = 80,
                    expReward = 70,
                    itemAdded = "Salvoconducto del Mercado Negro"
                )
            )
        ),

        "SCENE_EPILOGUE_OUTLAW_HERO_END" to StoryScene(
            id = "SCENE_EPILOGUE_OUTLAW_HERO_END",
            title = "Final del Epílogo: La Sombra Justiciera",
            narrativeTemplate = "Las familias de campesinos lloran de gratitud al recibir tus bolsas de monedas en silencio nocturno. Te has convertido en el héroe proscrito de las brumas. Los carteles de recompensa ofrecen 100 monedas de oro por tu cabeza.",
            choices = listOf(
                StoryChoice(
                    id = "choice_finish_outlaw_hero",
                    text = "🚀 Comenzar Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                )
            )
        ),

        "SCENE_EPILOGUE_OUTLAW_GREED_END" to StoryScene(
            id = "SCENE_EPILOGUE_OUTLAW_GREED_END",
            title = "Final del Epílogo: El Señor de los Caminos",
            narrativeTemplate = "Usas el oro para contratar a cinco proscritos del bosque. A tus 20 años, ya no eres un simple 'pelabola'; eres el temido líder de una banda de asaltantes en las rutas del Feudo.",
            choices = listOf(
                StoryChoice(
                    id = "choice_finish_outlaw_greed",
                    text = "🚀 Comenzar Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                )
            )
        ),

        // --- RAMA 4: GREMIO DE LAS SOMBRAS ---
        "SCENE_EPILOGUE_SHADOW_PACT" to StoryScene(
            id = "SCENE_EPILOGUE_SHADOW_PACT",
            title = "Epílogo Rama IV: El Pacto del Subsuelo",
            narrativeTemplate = "Mientras los matones de Brutus huyen, un encapuchado se aproxima desde un rincón oscuro. Es un emisario de la 'Red de las Sombras', el sindicato de contrabandistas que opera bajo Oakhaven.\n\n—'Impresionante exhibición, **{HERO_NAME}**. Si usas la bodega de la taberna para guardar nuestras mercancías furtivas, nos aseguraremos de que el Feudo jamás vuelva a tocar a tu padre'.",
            choices = listOf(
                StoryChoice(
                    id = "choice_shadow_vault",
                    text = "🔑 Aceptar el trato y convertir la bodega en un refugio clandestino",
                    targetSceneId = "SCENE_EPILOGUE_SHADOW_END",
                    goldReward = 50,
                    expReward = 75,
                    itemAdded = "Llave del Tunel Clandestino"
                ),
                StoryChoice(
                    id = "choice_shadow_boss",
                    text = "♟️ Exigir ser el lugarteniente del Gremio en todo el sector norte",
                    targetSceneId = "SCENE_EPILOGUE_BOSS_END",
                    goldReward = 70,
                    expReward = 90,
                    itemAdded = "Anillo de Cera de las Sombras"
                )
            )
        ),

        "SCENE_EPILOGUE_SHADOW_END" to StoryScene(
            id = "SCENE_EPILOGUE_SHADOW_END",
            title = "Final del Epílogo: El Ojo de la Red",
            narrativeTemplate = "Bajo los barriles de cerveza de Garrick ahora fluye oro furtivo, sedas robadas y venenos importados. La taberna es intocable y tú eres el intermediario secreto más influyente de la comarca.",
            choices = listOf(
                StoryChoice(
                    id = "choice_finish_shadow",
                    text = "🚀 Comenzar Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                )
            )
        ),

        "SCENE_EPILOGUE_BOSS_END" to StoryScene(
            id = "SCENE_EPILOGUE_BOSS_END",
            title = "Final del Epílogo: El Patrón del Submundo",
            narrativeTemplate = "Sorprendidos por tu fría ambición a tus 20 años, los líderes del sindicato aceptan tus términos. Dominas el contrabando de Oakhaven desde la sombra mientras tu padre atiende el mostrador sin sospechar nada.",
            choices = listOf(
                StoryChoice(
                    id = "choice_finish_boss",
                    text = "🚀 Comenzar Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                )
            )
        ),

        // --- CONCLUSIÓN / RECAPITULACIÓN DEL CAPÍTULO 1 ---
        "SCENE_VICTORY_DEMO" to StoryScene(
            id = "SCENE_VICTORY_DEMO",
            title = "Prólogo y Epílogo Completados: 'Cerveza, Sangre y Barro'",
            narrativeTemplate = "¡Felicidades, **{HERO_NAME}**! Has completado la totalidad del Prólogo y su Epílogo Ramificado. Comenzaste como un joven tabernero de 20 años en la miseria ('pelabola') y has forjado tu propio destino único a través del coraje, la astucia y el acero.\n\nEl Capítulo 1 te espera en los grandes caminos de Aethelgard. ¿Qué hazañas aguardan en tu diario de campaña?",
            choices = listOf(
                StoryChoice(
                    id = "choice_start_cap1_direct",
                    text = "🚀 Entrar al Capítulo 1: Viviendo la Vida Dura",
                    targetSceneId = "SCENE_CAP1_INTRO"
                ),
                StoryChoice(
                    id = "choice_restart_game",
                    text = "🔄 Reiniciar aventuras para probar otra rama del Epílogo",
                    targetSceneId = "SCENE_RESTART"
                )
            )
        )
    )
}
