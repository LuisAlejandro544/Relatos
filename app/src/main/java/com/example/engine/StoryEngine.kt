package com.example.engine

import com.example.model.StoryChoice
import com.example.model.StoryScene

object StoryEngine {

    private val scenes = mapOf(
        "SCENE_TAVERN_INTRO" to StoryScene(
            id = "SCENE_TAVERN_INTRO",
            title = "PRÓLOGO: Cerveza, Sangre y Barro",
            narrativeTemplate = "Tienes 20 años y sostienes una bayeta mugrienta. Toda tu vida has soñado con empuñar acero y ser un gran guerrero, pero tu padre, **Garrick**, jamás lo permitió. Te obligó a fregar el suelo de la taberna *'La Jarra Mellada'* en Oakhaven.\n\nDe pronto, la puerta de roble se abre de un golpe. Entra **Brutus 'El Recaudador'** flanqueado por dos matones armados.\n\n—'¡Garrick, viejo tacaño! 50 monedas de plata por el tributo del feudo o quemamos esta pocilga hoy mismo' —amenaza Brutus golpeando la barra.\n\nTu padre tiembla sin poder defenderse. En la esquina, el viejo mercenario **Gideon 'El Tuerto'** apura su jarra de ale...",
            choices = listOf(
                StoryChoice(
                    id = "choice_face_brutus",
                    text = "🛡️ Intervenir y plantar cara a Brutus con tu {WEAPON}",
                    targetSceneId = "SCENE_BRUTUS_FACE"
                ),
                StoryChoice(
                    id = "choice_talk_gideon",
                    text = "🍺 Pedir consejo a Gideon el veterano borrachín",
                    targetSceneId = "SCENE_GIDEON_TALK"
                ),
                StoryChoice(
                    id = "choice_talk_garrick",
                    text = "📜 Hablar con tu padre Garrick para protegerlo",
                    targetSceneId = "SCENE_GARRICK_TALK"
                ),
                StoryChoice(
                    id = "choice_check_inv",
                    text = "🎒 Inspeccionar tus pocas pertenencias de pelabola",
                    targetSceneId = "SCENE_CHECK_INVENTORY"
                )
            )
        ),

        "SCENE_BRUTUS_FACE" to StoryScene(
            id = "SCENE_BRUTUS_FACE",
            title = "El Desafío del Novato",
            narrativeTemplate = "Avanzas colocándote entre Brutus y tu padre. Empuñas tu **{WEAPON}** con manos temblorosas pero llenas de coraje.\n\nBrutus ríe a carcajadas: '¡Miren al friegaplatos jugando a ser caballero! ¿Vas a limpiarme las botas con ese pedazo de madera, **{HERO_NAME}**?'",
            choices = listOf(
                StoryChoice(
                    id = "choice_attack_brutus",
                    text = "⚔️ Atacar a Brutus con el impulso del coraje acumulado",
                    targetSceneId = "SCENE_COMBAT_BRUTUS",
                    hpChange = -10,
                    goldReward = 15,
                    expReward = 35,
                    itemAdded = "Daga de Brutus"
                ),
                StoryChoice(
                    id = "choice_throw_ale",
                    text = "💥 Lanzar una jarra de hidromiel hirviendo a la cara de Brutus",
                    targetSceneId = "SCENE_COMBAT_TRICK",
                    goldReward = 20,
                    expReward = 40,
                    itemAdded = "Bolsa de Cobre del Recaudador"
                )
            )
        ),

        "SCENE_GIDEON_TALK" to StoryScene(
            id = "SCENE_GIDEON_TALK",
            title = "El Consejo del Veterano - Gideon",
            narrativeTemplate = "Gideon escupe al suelo y sonríe con sorna. 'Esos matones son pura bocaza, chico. Apunta al tobillo con esa espada de madera y caerá como un saco de patatas. Demuéstrale a tu viejo que sirves para algo más que fregar vasos'.",
            choices = listOf(
                StoryChoice(
                    id = "choice_gideon_trick",
                    text = "⚔️ Aplicar la finta de Gideon y embestir a Brutus",
                    targetSceneId = "SCENE_COMBAT_BRUTUS",
                    goldReward = 10,
                    expReward = 45,
                    itemAdded = "Consejo de Mercenario"
                ),
                StoryChoice(
                    id = "choice_back_intro",
                    text = "🛡️ Regresar a defender el mostrador de la taberna",
                    targetSceneId = "SCENE_TAVERN_INTRO"
                )
            )
        ),

        "SCENE_GARRICK_TALK" to StoryScene(
            id = "SCENE_GARRICK_TALK",
            title = "El Dilema Familiar - Garrick",
            narrativeTemplate = "Tu padre te agarra del hombro con firmeza. '¡Apártate, **{HERO_NAME}**! Esto es entre la taberna y el Feudo. No quiero que salgas herido... ¡siempre quisiste irte a la guerra y morir como un iluso!'",
            choices = listOf(
                StoryChoice(
                    id = "choice_rebel_father",
                    text = "💥 'Tengo 20 años, padre. Es hora de luchar.' (Encarar a Brutus)",
                    targetSceneId = "SCENE_BRUTUS_FACE"
                ),
                StoryChoice(
                    id = "choice_give_copper",
                    text = "🪙 Ofrecer tus últimas 5 monedas de cobre para calmar el ambiente",
                    targetSceneId = "SCENE_BRUTUS_FACE"
                )
            )
        ),

        "SCENE_CHECK_INVENTORY" to StoryScene(
            id = "SCENE_CHECK_INVENTORY",
            title = "Mochila de Pelabola",
            narrativeTemplate = "Revisas tu saco mugriento. Como **{CLASS}**, solo posees tu **{WEAPON}** y tu **{ARMOR}**. No tienes oro ni renombre, pero tus 20 años rebosan ambición de convertirte en leyenda.",
            choices = listOf(
                StoryChoice(
                    id = "choice_return_tavern_2",
                    text = "🏰 Volver a la taberna 'La Jarra Mellada'",
                    targetSceneId = "SCENE_TAVERN_INTRO"
                ),
                StoryChoice(
                    id = "choice_direct_fight_2",
                    text = "⚔️ Encarar a Brutus inmediatamente",
                    targetSceneId = "SCENE_BRUTUS_FACE"
                )
            )
        ),

        "SCENE_COMBAT_BRUTUS" to StoryScene(
            id = "SCENE_COMBAT_BRUTUS",
            title = "La Caída del Recaudador",
            narrativeTemplate = "¡El combate es encarnizado! Das un golpe certero que desarma a Brutus y lo derriba sobre una mesa de roble. Los matones huyen aterrorizados al ver tu feroz determinación.\n\nTu padre Garrick contempla la escena en atónito silencio. Se acerca, limpia la barra con su propio trapo y suspira profundamente...\n\n—'Veo que la sangre de guerrero no se borra frotando jarras, **{HERO_NAME}**. Tu victoria resonará en Oakhaven... pero ahora debes decidir cuál será tu destino definitivo'.",
            choices = listOf(
                StoryChoice(
                    id = "choice_go_epilogue_hub",
                    text = "📜 Avanzar al Epílogo Ramificado: La Encrucijada de Oakhaven",
                    targetSceneId = "SCENE_EPILOGUE_BRANCH_HUB"
                )
            )
        ),

        "SCENE_COMBAT_TRICK" to StoryScene(
            id = "SCENE_COMBAT_TRICK",
            title = "Astucia de Taberna",
            narrativeTemplate = "La jarra de hidromiel estalla en el rostro de Brutus. Gideon aprovecha el desconcierto para zancadillear al segundo matón. Entre el caos, logras reducir a los cobradores sin recibir un solo rasguño.\n\nTu padre Garrick niega con la cabeza pero sonríe con orgullo torpe.\n\n—'No eres un tabernero, **{HERO_NAME}**. Eres un estratega nato. El pueblo entero observará los pasos que des a partir de hoy'.",
            choices = listOf(
                StoryChoice(
                    id = "choice_go_epilogue_hub_2",
                    text = "📜 Avanzar al Epílogo Ramificado: La Encrucijada de Oakhaven",
                    targetSceneId = "SCENE_EPILOGUE_BRANCH_HUB"
                )
            )
        ),

        // =========================================================================
        // EPÍLOGO EXTENSO Y RAMIFICADO (EPILOGUE BRANCHING HUBS & DECISION PATHS)
        // =========================================================================

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
                    text = "👑 Completar Epílogo (Título: Guardián del Feudo) e ir al Cap. 1",
                    targetSceneId = "SCENE_VICTORY_DEMO"
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
                    text = "🛡️ Completar Epílogo (Título: Defensor de la Taberna) e ir al Cap. 1",
                    targetSceneId = "SCENE_VICTORY_DEMO"
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
                    text = "🏆 Completar Epílogo (Título: Espada a Sueldo) e ir al Cap. 1",
                    targetSceneId = "SCENE_VICTORY_DEMO"
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
                    text = "⚔️ Completar Epílogo (Título: Cabo de Vanguardia) e ir al Cap. 1",
                    targetSceneId = "SCENE_VICTORY_DEMO"
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
                    text = "🌲 Completar Epílogo (Título: Fantasma de Oakhaven) e ir al Cap. 1",
                    targetSceneId = "SCENE_VICTORY_DEMO"
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
                    text = "💰 Completar Epílogo (Título: Rey de los Proscritos) e ir al Cap. 1",
                    targetSceneId = "SCENE_VICTORY_DEMO"
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
                    text = "🗝️ Completar Epílogo (Título: Agente Clandestino) e ir al Cap. 1",
                    targetSceneId = "SCENE_VICTORY_DEMO"
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
                    text = "♟️ Completar Epílogo (Título: Señor de las Sombras) e ir al Cap. 1",
                    targetSceneId = "SCENE_VICTORY_DEMO"
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
                    id = "choice_restart_game",
                    text = "🔄 Reiniciar aventuras para probar otra rama del Epílogo",
                    targetSceneId = "SCENE_RESTART"
                ),
                StoryChoice(
                    id = "choice_stay_log",
                    text = "📜 Repasar la encrucijada inicial en la Taberna",
                    targetSceneId = "SCENE_TAVERN_INTRO"
                )
            )
        )
    )

    fun getScene(id: String): StoryScene {
        return scenes[id] ?: scenes["SCENE_TAVERN_INTRO"]!!
    }

    fun formatNarrative(template: String, heroName: String, characterClass: com.example.model.CharacterClass): String {
        return template
            .replace("{HERO_NAME}", heroName.ifBlank { "Héroe Sin Nombre" })
            .replace("{CLASS}", characterClass.title)
            .replace("{WEAPON}", characterClass.weaponName)
            .replace("{ARMOR}", characterClass.armorName)
    }
}
