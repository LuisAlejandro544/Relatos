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
        ),

        // =========================================================================
        // CAPÍTULO 1: VIVIENDO LA VIDA DURA
        // =========================================================================

        "SCENE_CAP1_INTRO" to StoryScene(
            id = "SCENE_CAP1_INTRO",
            title = "CAPÍTULO 1: Viviendo la Vida Dura - La Cruda Realidad",
            narrativeTemplate = "Han transcurrido 7 días exactos desde los acontecimientos en *'La Jarra Mellada'*. Tienes 20 años y tus manos arden llenas de ampollas. Sostienes una rama gruesa de roble tallada a cuchillo, tratando de repetir las estocadas que aprendiste solo.\n\nLlevas una semana comiendo pan duro y caldo de cebollas en un cobertizo abandonado junto al viejo molino. Al pasar frente a la taberna, ves a tu padre **Garrick** cargando un barril. Te mira fijamente durante tres segundos agonizantes... luego escupe al suelo con rencor y cierra la puerta de un portazo.\n\nMientras caminas con el estómago rugiendo hacia la plaza del mercado, el galope de tres caballos y el ladrido sordo de un perro de caza hacen eco en las calles empedradas...",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_advance_bounty",
                    text = "🐺 Avanzar hacia la plaza y enfrentar a los jinetes",
                    targetSceneId = "SCENE_CAP1_BOUNTY_HUNTERS"
                )
            )
        ),

        "SCENE_CAP1_BOUNTY_HUNTERS" to StoryScene(
            id = "SCENE_CAP1_BOUNTY_HUNTERS",
            title = "Capítulo 1: Los Cazarrecompensas de la Compañía",
            narrativeTemplate = "Tres jinetes con capas llenas de barro de viaje te cierran el paso. El hombre del centro, alto, con una cota de malla desgastada y la mirada dura de quien ha matado por monedas, desmonta lentamente.\n\n—'Atento, muchacho' —dice con voz rasposa—. 'Soy el **Capitán Valerius**, de la Compañía del Perro Hambriento. A mi izquierda está **Kaelen \"Dedos Fríos\"**, que no duda en poner un virote entre los ojos de los curiosos, y ella es **Dara \"La Tuerta\"**. Buscamos a una alimaña llamado **Vance \"Mano de Humo\"**. Robó una espada corta de acero en la forja de Olaf y las joyas del intendente'.\n\nDara tira de la cadena del sabueso *'Muerdecapas'*, que olfatea el aire cerca de tus botas desgastadas.\n\n—'La guardia del feudo paga 40 monedas de plata por él. Tú tienes cara de vagabundear por todos los rincones de este pueblo de mala muerte. **Vance era cliente habitual de la taberna y sabemos que solían beber juntos.** ¿Lo has visto o no, **{HERO_NAME}**?'",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_sell_info",
                    text = "🪙 Traicionar a tu viejo amigo Vance: \"Sé dónde se oculta Vance... les diré por 5 monedas de plata.\"",
                    targetSceneId = "SCENE_CAP1_SELL_OUT",
                    goldReward = 5,
                    expReward = 20,
                    itemAdded = "Monedas del Perro Hambriento"
                ),
                StoryChoice(
                    id = "choice_cap1_stubborn_refuse",
                    text = "🛡️ Desafío Defensivo: \"Atrás, comadrejas de camino. Vance comió en mi mesa y no seré el perro faldero de unos tragabarros del feudo. Apártense o les haré tragar sus virotes.\"",
                    targetSceneId = "SCENE_CAP1_STUBBORN_STAND",
                    expReward = 30,
                    itemAdded = "Respeto de los Aldeanos"
                ),
                StoryChoice(
                    id = "choice_cap1_trick_and_hunt",
                    text = "🏹 Dar pista falsa: \"Lo vi ir hacia el sur...\" (Mientes para ir tú solo al viejo molino norte).",
                    targetSceneId = "SCENE_CAP1_SOLO_HUNT",
                    expReward = 40,
                    itemAdded = "Mapa del Viejo Molino"
                ),
                StoryChoice(
                    id = "choice_cap1_shadow_alliance",
                    text = "🤝 Postularte como Mediador: \"Vance no entregará las joyas sin luchar. Déjenme ir al frente con ustedes.\"",
                    targetSceneId = "SCENE_CAP1_MEDIATOR_PACT",
                    goldReward = 10,
                    expReward = 35,
                    itemAdded = "Salvoconducto de Valerius"
                )
            )
        ),

        "SCENE_CAP1_SELL_OUT" to StoryScene(
            id = "SCENE_CAP1_SELL_OUT",
            title = "El Precio de la Lealtad",
            narrativeTemplate = "El Capitán Valerius sonríe con frialdad y lanza un saquito con 5 monedas de plata a tus pies.\n\n—'Me gusta la gente pragmática, **{HERO_NAME}**.'\n\nRecoges las monedas del barro y les revelas que Vance solía esconderse en el sótano del viejo molino abandonado al norte. Tienes suficiente dinero para comer caliente por una semana, pero el remordimiento por vender a tu viejo compañero de cerveza pesa en tu pecho mientras la patrulla parte al galope...",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_part1",
                    text = "📜 Continuar la aventura en la siguiente etapa del Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_STUBBORN_STAND" to StoryScene(
            id = "SCENE_CAP1_STUBBORN_STAND",
            title = "Desafío en la Plaza de Oakhaven",
            narrativeTemplate = "Tus palabras resonando con veneno hacen que Kaelen encaje el virote en su ballesta con un chasquido metálico seco. Dara suelta medio metro de cadena del rabioso sabueso *'Muerdecapas'*, que te enseña sus colmillos ensangrentados. El Capitán Valerius desmonta despacio, acariciando la empuñadura de su espada ancha.\n\n—'¿Comadrejas de camino? Te falta mucho acero en el cinto para escupir tanta baba, estúpido cachorro de tabernero' —gruñe Valerius con una sonrisa sanguinaria—. 'O abres esa boca mugrienta para decirnos dónde se oculta Vance, o te enseñamos modales a garrotazos en mitad del barro.'\n\nLos campesinos se refugian tras las ventanas. Tienes a la patrulla encima y las manos apretadas sobre tu garrote de roble.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_attack_valerius",
                    text = "🗡️ Embestida Sorpresa: \"¡El único que aprenderá modales eres tú!\" (Golpear a Valerius con el garrote)",
                    targetSceneId = "SCENE_CAP1_FIGHT_VALERIUS",
                    expReward = 50,
                    itemAdded = "Sangre de Valerius"
                ),
                StoryChoice(
                    id = "choice_cap1_taunt_dog",
                    text = "🐕 Provocar al Perro: Lanzar una piedra pesada a Muerdecapas para desorganizar a los cazarrecompensas",
                    targetSceneId = "SCENE_CAP1_FIGHT_DOG_CHAOS",
                    expReward = 45,
                    itemAdded = "Colmillo de Sabueso"
                ),
                StoryChoice(
                    id = "choice_cap1_call_villagers",
                    text = "🗣️ Clamor Popular: \"¡Gente de Oakhaven, miren cómo estos mercenarios amenazan a un muchacho del pueblo!\"",
                    targetSceneId = "SCENE_CAP1_FIGHT_ALLEY_BRAWL",
                    expReward = 40,
                    itemAdded = "Cerveza de Parroquiano"
                ),
                StoryChoice(
                    id = "choice_cap1_grudge_retreat",
                    text = "⚖️ Retroceso con Retintín: \"Tranquilos... si tanto les pican las manos, miren en el molino norte antes de que pierda la paciencia.\"",
                    targetSceneId = "SCENE_CAP1_STUBBORN_GRUDGE",
                    expReward = 20,
                    itemAdded = "Rencor de Valerius"
                )
            )
        ),

        "SCENE_CAP1_FIGHT_VALERIUS" to StoryScene(
            id = "SCENE_CAP1_FIGHT_VALERIUS",
            title = "Pelea de Callejón: Embestida a Valerius",
            narrativeTemplate = "Antes de que Valerius termine de desenfundar, avanzas un paso y le asestas un garrotazo seco en el labio. El capitán cae hacia atrás escupiendo sangre y moliendas de diente.\n\n—'¡Maldito engendro!' —grita Dara soltando al perro.\n\nEsquivas por instinto hacia un callejón estrecho. El virote de Kaelen zumba rozándote la oreja e impacta contra un poste de madera. Gracias a tu agilidad de muchacho de 20 años acostumbrado a esquivar borrachos en la taberna, logras perderlos entre las muelas de heno del pueblo, dejando a Valerius furioso y herido.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_fight_valerius",
                    text = "📜 Escapar victorioso hacia la siguiente etapa del Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_FIGHT_DOG_CHAOS" to StoryScene(
            id = "SCENE_CAP1_FIGHT_DOG_CHAOS",
            title = "Pelea de Callejón: El Caos de Muerdecapas",
            narrativeTemplate = "Rápidamente recoges un guijarro afilado y se lo asestas en el hocico al sabueso. *Muerdecapas* aúlla de dolor, se da la vuelta enloquecido y le hinca los dientes en la bota de cuero a Dara.\n\n—'¡Suéltame, perro del demonio!' —chilla la rastreadora intentando zafarse.\n\nLa yegua de Kaelen se encabrita ante los ladridos y patea el poste de la tienda de frutas. Aprovechas la trifulca y el descontrol general para asestarle un fuerte garrotazo en la rodilla al ballestero antes de desaparecer corriendo hacia las afueras.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_fight_dog",
                    text = "📜 Escapar en medio del caos hacia la siguiente etapa del Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_FIGHT_ALLEY_BRAWL" to StoryScene(
            id = "SCENE_CAP1_FIGHT_ALLEY_BRAWL",
            title = "Pelea de Callejón: La Revuelta de los Parroquianos",
            narrativeTemplate = "Tu grito hace eco en la plaza. Dos viejos parroquianos de la taberna de tu padre, agradecidos por cómo defendiste *'La Jarra Mellada'* hace una semana, salen del callejón y vuelcan un carro lleno de toneles de cerveza vacíos sobre el caballo de Kaelen.\n\nSe arma una trifulca comunitaria. Intercambias puñetazos pesados con Valerius, encajando un nudillazo en el pómulo pero devolviéndole un codazo en la garganta. La gente del pueblo abuchea a los mercenarios hasta que la patrulla se ve obligada a replegarse temporalmente.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_fight_brawl",
                    text = "📜 Celebrar con los vecinos y avanzar en el Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_STUBBORN_GRUDGE" to StoryScene(
            id = "SCENE_CAP1_STUBBORN_GRUDGE",
            title = "Desescalada con Rencor",
            narrativeTemplate = "Viendo el virote de Kaelen apuntando directo a tu frente, te tragas el orgullo pero mantienes el tono desafiante:\n\n—'Si tanto les pican las manos, vayan al molino abandonado del norte a buscar a Vance antes de que pierda la paciencia con ustedes.'\n\nValerius se limpia el barro de las botas y te señala con el dedo índice amenazadoramente.\n\n—'Si nos mentiste, volveré por tu cabeza, mocoso.'\n\nLa patrulla parte al galope dejando una nube de polvo en la plaza.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_stubborn_grudge",
                    text = "📜 Continuar la aventura en la siguiente etapa del Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_SOLO_HUNT" to StoryScene(
            id = "SCENE_CAP1_SOLO_HUNT",
            title = "La Carrera hacia el Molino",
            narrativeTemplate = "Engañas con destreza al Capitán Valerius indicándole el camino del sur. Los tres jinetes parten al galope hacia la dirección equivocada.\n\nCon el corazón latiéndote a mil por hora, te adentras apresuradamente por los matorrales del norte rumbo al viejo molino abandonado. Debes encontrar a tu amigo Vance, advertirle de los cazarrecompensas y decidir qué hacer con la espada de acero de la forja de Olaf...",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_part1_3",
                    text = "📜 Continuar la aventura en la siguiente etapa del Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_MEDIATOR_PACT" to StoryScene(
            id = "SCENE_CAP1_MEDIATOR_PACT",
            title = "El Mediador de Oakhaven - Negociación",
            narrativeTemplate = "El Capitán Valerius evalúa tu propuesta en silencio durante largos segundos mientras Kaelen y Dara te observan con recelo.\n\n—'Dices que conoces a Vance y que puedes hacer que se rinda sin derramar sangre de mis hombres' —dice Valerius acariciándose la barbilla—. 'Pero en esta compañía no marchamos con cualquiera que hable bonito. Si vas a acompañarnos como mediador, debes dejar claras tus intenciones, **{HERO_NAME}**.'\n\n¿Cómo decides negociar las condiciones con la patrulla?",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_duel_kaelen",
                    text = "⚔️ Duelo de Prueba (Tutorial de Combate): \"No soy solo palabras. Prueben mi brazo si dudan de mí.\" (Luchar contra Kaelen)",
                    targetSceneId = "SCENE_CAP1_TUTORIAL_COMBAT",
                    expReward = 50,
                    itemAdded = "Respeto de Kaelen"
                ),
                StoryChoice(
                    id = "choice_cap1_demand_share",
                    text = "💰 Exigir Reparto Equitativo: \"Iré al frente, pero exijo 15 monedas de plata de la recompensa y hablar a solas con Vance primero.\"",
                    targetSceneId = "SCENE_CAP1_MEDIATOR_SHARE",
                    goldReward = 15,
                    expReward = 35,
                    itemAdded = "Contrato de la Compañía"
                ),
                StoryChoice(
                    id = "choice_cap1_double_agent",
                    text = "🗝️ Infiltración Clandestina: \"Me adelantaré 2 minutos al molino para asegurar que no destruya las joyas al vernos llegar.\"",
                    targetSceneId = "SCENE_CAP1_MEDIATOR_DOUBLE_AGENT",
                    expReward = 40,
                    itemAdded = "Ganzúa Furtiva"
                ),
                StoryChoice(
                    id = "choice_cap1_refuse_pact",
                    text = "🛑 Arrepentirse del Pacto: \"Pensándolo bien, no voy a arriesgar mi cuello por las monedas de un señor feudal.\"",
                    targetSceneId = "SCENE_CAP1_BOUNTY_HUNTERS"
                )
            )
        ),

        "SCENE_CAP1_TUTORIAL_COMBAT" to StoryScene(
            id = "SCENE_CAP1_TUTORIAL_COMBAT",
            title = "Tutorial de Combate: Duelo de Prueba contra Kaelen",
            narrativeTemplate = "Valerius asiente con una sonrisa fría. Kaelen deja su ballesta a un lado y desenfunda una daga pesada de duelo.\n\n—'Veamos de qué estás hecho, muchacho' —gruñe Kaelen.\n\n⚔️ **[APRENDIENDO EL SISTEMA DE COMBATE TÁCTICO]**\nEn *Aethelgard RPG*, los combates utilizan un motor determinista en C++ y Rust que calcula cada impacto según tus estadísticas de Fuerza, Agilidad y el estado de tu equipo:\n\n1. **Guardia & Postura:** Usar tu garrote para desviar ataques reduce el daño en un 50% y recarga tu energía de contraataque.\n2. **Puntos de Vida (HP):** Cada golpe recibido descuenta HP directamente de tu estado global. Gestionar tus pociones e inventario es vital.\n3. **Cálculo Nativo (Rust RNG Seed):** La precisión y los golpes críticos dependen de tiradas de destreza no manipulables.\n\n¡Intercambias tres embestidas feroces! Desvías el estacazo de Kaelen con tu garrote de roble y le asestas un fuerte barrido en el tobillo. Kaelen cae de rodillas sobre la tierra dura, respirando agitado. Valerius aplaude lentamente.\n\n—'Suficiente. Tienes madera de guerrero, **{HERO_NAME}**. Bien planificado.'",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_tutorial",
                    text = "📜 Demostración completada: Avanzar en la misión con la patrulla",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_MEDIATOR_SHARE" to StoryScene(
            id = "SCENE_CAP1_MEDIATOR_SHARE",
            title = "Pacto de Sangre y Plata",
            narrativeTemplate = "Valerius entorna los ojos al escuchar tu demanda económica de 15 monedas de plata.\n\n—'Tienes la boca grande y los bolsillos vacíos, muchacho. Pero si nos entregas a Vance intacto con las joyas del intendente, tendrás tus 15 monedas de plata y derecho a hablar con él primero. Si falla tu negociación, la plata será para pagar tu entierro.'\n\nCierran el pacto estrechando las manos sucias de barro. Has asegurado una paga importante si la misión triunfa.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_share",
                    text = "📜 Continuar la marcha hacia el molino abandonado",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_MEDIATOR_DOUBLE_AGENT" to StoryScene(
            id = "SCENE_CAP1_MEDIATOR_DOUBLE_AGENT",
            title = "Infiltración Furtiva en el Molino",
            narrativeTemplate = "Propones correr hacia el molino norte dos minutos antes que la caballería para evitar que Vance se acorrale o destruya el botín.\n\n—'De acuerdo' —consiente Valerius—. 'Tendrás 120 segundos de ventaja antes de que rodeemos la estructura. Si intentas huir con él, Dara soltará a Muerdecapas.'\n\nAvanzas a paso ligero entre las sombras del sotobosque, ganando terreno táctico para reencontrarte con tu viejo amigo Vance antes que nadie.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_double_agent",
                    text = "📜 Adentrarte en el sotobosque hacia la siguiente etapa del Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_SUMMARY_DEMO" to StoryScene(
            id = "SCENE_CAP1_SUMMARY_DEMO",
            title = "Capítulo 1: 'Viviendo la Vida Dura' - Avance Guardado",
            narrativeTemplate = "¡Excelente progreso, **{HERO_NAME}**! Has completado el inicio del Capítulo 1: 'Viviendo la Vida Dura'.\n\nEnfrentaste la miseria, la mirada fría de tu padre Garrick y la llegada de la Compañía del Perro Hambriento (Capitán Valerius, Kaelen y Dara). Tus decisiones respecto a tu viejo amigo Vance 'Mano de Humo' han marcado el tono de tu reputación moral en Oakhaven.\n\n¿Qué acción deseas realizar ahora?",
            choices = listOf(
                StoryChoice(
                    id = "choice_stay_cap1_bounty",
                    text = "🔄 Repetir el encuentro con los cazarrecompensas",
                    targetSceneId = "SCENE_CAP1_BOUNTY_HUNTERS"
                ),
                StoryChoice(
                    id = "choice_return_epilogue_hub",
                    text = "📜 Volver a la Encrucijada del Epílogo",
                    targetSceneId = "SCENE_EPILOGUE_BRANCH_HUB"
                ),
                StoryChoice(
                    id = "choice_restart_all",
                    text = "🏰 Reiniciar desde el Prólogo en la Taberna",
                    targetSceneId = "SCENE_RESTART"
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
