package com.example.engine.scenes

import com.example.model.StoryChoice
import com.example.model.StoryScene

object PrologueScenes {
    val scenes: Map<String, StoryScene> = mapOf(
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
        )
    )
}
