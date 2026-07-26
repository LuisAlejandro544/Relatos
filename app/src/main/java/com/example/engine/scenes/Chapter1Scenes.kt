package com.example.engine.scenes

import com.example.model.StoryChoice
import com.example.model.StoryScene

object Chapter1Scenes {
    val scenes: Map<String, StoryScene> = mapOf(
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
            title = "La Carrera hacia el Viejo Molino",
            narrativeTemplate = "Engañas con gran astucia al Capitán Valerius señalando hacia los senderos embarrados del sur. El cazarrecompensas asiente con frialdad y hace una señal a Kaelen y Dara, quienes parten al galope en la dirección equivocada haciendo resonar los cascos de sus monturas.\n\nCon el corazón latiéndote a mil por hora y los pulmones ardiendo, aprovechas el despiste para correr hacia el norte entre los espesos matorrales de roble. Tras veinte minutos de veloz caminata, divisas la gran rueda podrida del **Viejo Molino Abandonado** recortada contra el cielo gris.\n\nSabes que Vance 'Mano de Humo' se oculta adentro con la espada de acero de la forja de Olaf y las joyas del intendente. Pero Valerius no tardará en darse cuenta del engaño... ¿Cómo decides aproximarte al edificio?",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_solo_call_vance",
                    text = "🗣️ Llamar a Vance con la silbida de la taberna: \"¡Vance, soy yo, {HERO_NAME}! ¡No dispares, viejo borracho!\"",
                    targetSceneId = "SCENE_CAP1_SOLO_VANCE_MEETING",
                    expReward = 20
                ),
                StoryChoice(
                    id = "choice_cap1_solo_sneak_wheel",
                    text = "🥷 Infiltración Sigilosa: Colarse por la rueda de madera podrida del molino para tomar posición de ventaja",
                    targetSceneId = "SCENE_CAP1_SOLO_SNEAK_MILL",
                    expReward = 25,
                    itemAdded = "Pasos Silenciosos"
                ),
                StoryChoice(
                    id = "choice_cap1_solo_scout",
                    text = "🔍 Inspeccionar el Terreno: Reconocer el perímetro en busca de trampas o huellas antes de entrar",
                    targetSceneId = "SCENE_CAP1_SOLO_SCOUT_MILL",
                    expReward = 30
                )
            )
        ),

        "SCENE_CAP1_SOLO_VANCE_MEETING" to StoryScene(
            id = "SCENE_CAP1_SOLO_VANCE_MEETING",
            title = "Reencuentro en las Sombras: Vance 'Mano de Humo'",
            narrativeTemplate = "Tu silbida característica retumba en el interior del molino. Tras unos segundos de tenso silencio, la figura de un joven de 22 años emerge de entre los sacos de harina. Lleva la cara manchada de hollín y sostiene con manos temblorosas la brillante **Espada Corta de Acero de la forja de Olaf**.\n\n—'¡{HERO_NAME}! ¡Por todos los demonios, casi te atravieso el cuello con este pedazo de acero!' —exclama Vance bajando el arma mientras respira agitado—. '¿Qué haces aquí? ¿Cómo supiste que me ocultaba en este hoyo?'\n\nLe explicas rápidamente que la Compañía del Perro Hambriento te acorraló en la plaza y que engañaste al Capitán Valerius desviándolo hacia el sur.\n\n—'Esos malditos sabuesos...' —gruñe Vance abrazándote con fuerza—. 'Tengo la espada corta de acero y el cofre con las joyas del intendente. Pero Valerius descubrirá el engaño tarde o temprano. ¿Qué sugerencias me traes, hermano?'",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_solo_partner",
                    text = "🤝 Propuesta de Alianza: \"Huyamos juntos al norte. Tú tienes el acero y yo conozco los atajos. Nos repartiremos el botín.\"",
                    targetSceneId = "SCENE_CAP1_SOLO_PARTNER_ESCAPE",
                    goldReward = 20,
                    expReward = 60,
                    itemAdded = "Dagas de Lanzamiento de Vance"
                ),
                StoryChoice(
                    id = "choice_cap1_solo_convince_jewels",
                    text = "📜 Vía Diplomática: \"Escúchame, Vance. Si devuelves las joyas del intendente, retirarán la orden de ejecución. Quédate la espada y sal de Oakhaven.\"",
                    targetSceneId = "SCENE_CAP1_SOLO_REDEEM_VANCE",
                    goldReward = 15,
                    expReward = 70,
                    itemAdded = "Joyero del Intendente"
                ),
                StoryChoice(
                    id = "choice_cap1_solo_demand_sword",
                    text = "⚔️ Exigir la Espada: \"Esa espada es del viejo Olaf. No dejaré que arruines tu vida ni la de la comarca. Entrégame el acero.\"",
                    targetSceneId = "SCENE_CAP1_SOLO_DUEL_VANCE",
                    expReward = 80,
                    itemAdded = "Espada Corta de Acero de Olaf"
                ),
                StoryChoice(
                    id = "choice_cap1_solo_ambush",
                    text = "🏹 Preparar Trampa Explosiva: \"Valerius vendrá furioso al darse cuenta de la mentira. Preparemos una trampa con los sacos de harina y la rueda.\"",
                    targetSceneId = "SCENE_CAP1_SOLO_MILL_TRAP",
                    goldReward = 30,
                    expReward = 100,
                    itemAdded = "Capa Calcinada de Valerius"
                )
            )
        ),

        "SCENE_CAP1_SOLO_SNEAK_MILL" to StoryScene(
            id = "SCENE_CAP1_SOLO_SNEAK_MILL",
            title = "Infiltración Furtiva en el Molino",
            narrativeTemplate = "Te cuelas en total silencio por el hueco engranado de la rueda de agua. Avanzas agazapado entre las vigas carcomidas hasta posicionarte justo encima de la estancia principal.\n\nAbajo, Vance guarda febrilmente las joyas del intendente en una bolsa de lona. Al sentir el crujido de una madera, se gira bruscamente desenfundando la espada de acero con un destello metálico.\n\n—'¡Muestra la cara o te desentraño!' —chilla aterrorizado.\n\nSaltas con agilidad a su espalda y le inmovilizas el brazo armado en un segundo.\n\n—'¡Cálmate, Vance, soy yo, **{HERO_NAME}**!' —le susurras al oído. Vance se desploma de alivio—. 'Los cazarrecompensas van al sur, pero regresarán pronto. ¿Cómo resolvemos esto?'",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_solo_partner_sneak",
                    text = "🤝 Pacto de Sombras: \"Aprovechemos nuestro sigilo: huyamos juntos antes de que la patrulla regrese del sur.\"",
                    targetSceneId = "SCENE_CAP1_SOLO_PARTNER_ESCAPE",
                    goldReward = 25,
                    expReward = 65,
                    itemAdded = "Pacto de Sangre con Vance"
                ),
                StoryChoice(
                    id = "choice_cap1_solo_steal_jewels",
                    text = "🗝️ Desarme Furtivo: Arrebatarle el joyero del intendente al descuido y huir para entregarlo a las autoridades",
                    targetSceneId = "SCENE_CAP1_SOLO_STEAL_JEWELS",
                    goldReward = 40,
                    expReward = 65,
                    itemAdded = "Joyero del Intendente Robado"
                ),
                StoryChoice(
                    id = "choice_cap1_solo_ambush_sneak",
                    text = "🏹 Trampa de Harina: \"Usemos esta posición elevada para esparcir harina y emboscar a los mercenarios si vienen.\"",
                    targetSceneId = "SCENE_CAP1_SOLO_MILL_TRAP",
                    goldReward = 30,
                    expReward = 100,
                    itemAdded = "Insignia de Estratega del Molino"
                )
            )
        ),

        "SCENE_CAP1_SOLO_SCOUT_MILL" to StoryScene(
            id = "SCENE_CAP1_SOLO_SCOUT_MILL",
            title = "Reconocimiento Táctico del Perímetro",
            narrativeTemplate = "Rodeas el molino inspeccionando la maleza. Encuentras un trozo de tela de la capa de Vance enganchado en una zarza y una vieja trampa para osos colocada torpemente cerca de la puerta trasera.\n\nCon paciencia de cazador, usas una rama pesada para accionar el cepo metálico, evitando caer en una emboscada mortal. Entras por la trastienda donde Vance te espera con la espada en ristre.\n\n—'¡Vaya, desactivaste la trampa que puse para los lobos, **{HERO_NAME}**!' —dice Vance rascándose la nuca—. 'Veo que vienes preparado. ¿Qué plan tienes para salvarme el pellejo?'",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_solo_partner_scout",
                    text = "🤝 Escape Guiado: \"Desactivé las trampas del exterior. El camino del norte está despejado, vámonos juntos.\"",
                    targetSceneId = "SCENE_CAP1_SOLO_PARTNER_ESCAPE",
                    goldReward = 20,
                    expReward = 60,
                    itemAdded = "Guía del Bosque Norte"
                ),
                StoryChoice(
                    id = "choice_cap1_solo_convince_scout",
                    text = "📜 Mediación Honesta: \"Las trampas no te salvarán de Valerius. Devuelve las joyas y sal del feudo como hombre libre.\"",
                    targetSceneId = "SCENE_CAP1_SOLO_REDEEM_VANCE",
                    goldReward = 15,
                    expReward = 70,
                    itemAdded = "Joyero del Intendente"
                ),
                StoryChoice(
                    id = "choice_cap1_solo_ambush_scout",
                    text = "🏹 Reutilizar la Trampa: Reinstalar la trampa de osos en la entrada principal para recibir a la patrulla",
                    targetSceneId = "SCENE_CAP1_SOLO_MILL_TRAP",
                    goldReward = 35,
                    expReward = 105,
                    itemAdded = "Cepa Metálica del Molino"
                )
            )
        ),

        "SCENE_CAP1_SOLO_PARTNER_ESCAPE" to StoryScene(
            id = "SCENE_CAP1_SOLO_PARTNER_ESCAPE",
            title = "Final de Ruta: El Dúo Proscrito de Oakhaven",
            narrativeTemplate = "Vance lanza una carcajada de alivio y aprieta tu hombro con fraternidad.\n\n—'¡Sabía que podía contar contigo, **{HERO_NAME}**! Dos muchachos de taberna con acero en la mano pueden conquistar las rutas del norte.'\n\nVance te entrega un par de dagas de lanzamiento de precisión de la forja de Olaf y reparten las monedas del botín. Antes de que Valerius y sus hombres regresen del sur frustrados, ustedes dos se adentran en las profundidades del Bosque de las Brumas, iniciando su leyenda como el Dúo Proscrito de Aethelgard.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_partner_escape",
                    text = "📜 Registrar victoria y avanzar en la bitácora del Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_SOLO_REDEEM_VANCE" to StoryScene(
            id = "SCENE_CAP1_SOLO_REDEEM_VANCE",
            title = "Final de Ruta: La Redención de Vance",
            narrativeTemplate = "Tu mirada serena y tus palabras directas hacen mella en el corazón de tu amigo. Vance contempla el cofre de joyas doradas y suspira profundamente.\n\n—'Tienes razón, **{HERO_NAME}**. No quiero pasar el resto de mi vida huyendo como una rata apestosa por unas cuantas piedras brillantes de un noble.'\n\nVance te entrega el cofre de joyas para que lo devuelvas anónimamente al feudo, guardándose únicamente la espada corta de acero para protegerse en los caminos. Te abraza emotivamente y parte hacia el este a rehacer su vida como herrero itinerante.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_redeem_vance",
                    text = "📜 Registrar desenlace noble y avanzar en el Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_SOLO_DUEL_VANCE" to StoryScene(
            id = "SCENE_CAP1_SOLO_DUEL_VANCE",
            title = "Final de Ruta: Duelo de Acero y Garrote",
            narrativeTemplate = "Vance niega con la cabeza, cegado por la desesperación. Empuña la espada corta de acero y te lanza una estocada salvaje.\n\n—'¡No voy a volver a frotar el yunque de Olaf ni a pudrirme en el calabozo!' —grita emocionado.\n\nEntablan un duelo brutal en mitad del molino. Desvías sus estocadas atolondradas con tu garrote de roble, usando la agilidad de tus 20 años. Con un barrido certero a las muñecas, le haces soltar el arma de acero. Vance cae de rodillas en el polvo, derrotado pero ileso.\n\nComprendiendo que has actuado para salvarlo de sí mismo, te cede la **Espada Corta de Acero de Olaf** y huye antes de que llegue la patrulla.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_duel_vance",
                    text = "📜 Tomar la espada de acero y continuar el viaje",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_SOLO_MILL_TRAP" to StoryScene(
            id = "SCENE_CAP1_SOLO_MILL_TRAP",
            title = "Final de Ruta: La Deflagración del Molino",
            narrativeTemplate = "Trabajan con la precisión de dos veteranos. Entre los dos esparcen sacos enteros de harina en el aire cerrado del molino, creando una densa suspensión de polvo combustible, y colocan la trampa en el umbral.\n\nVeinte minutos después, el Capitán Valerius, Kaelen y Dara irrumpen furiosos en la estancia tras descubrir el engaño del camino del sur. Al cruzar la puerta, lanzas una antorcha encendida al aire saturado de harina:\n\n¡BOOOOM! ¡Una deflagración ensordecedora estalla dentro del molino! La onda expansiva tumba a los cazarrecompensas contra el barro y calcina la capa del Capitán Valerius. En medio del humo y la confusión, tú y Vance escapan victoriosos con el botín intacto.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_mill_trap",
                    text = "📜 Celebrar la gran victoria táctica y avanzar en el Capítulo 1",
                    targetSceneId = "SCENE_CAP1_SUMMARY_DEMO"
                )
            )
        ),

        "SCENE_CAP1_SOLO_STEAL_JEWELS" to StoryScene(
            id = "SCENE_CAP1_SOLO_STEAL_JEWELS",
            title = "Final de Ruta: La Recuperación del Botín",
            narrativeTemplate = "Con un movimiento rápido e imprevisto de lucha libre, inmovilizas a Vance contra el suelo, le arrebatas el joyero del intendente y te lanzas por el hueco de la rueda de agua hacia el canal del río.\n\nSurgiendo del agua helada con el joyero en tu poder, escuchas a Vance gritar incrédulo desde la ventana del molino. Has asegurado una enorme recompensa por devolver las joyas al feudo, demostrando que tu lealtad está con el deber y la justicia.",
            choices = listOf(
                StoryChoice(
                    id = "choice_cap1_finish_steal_jewels",
                    text = "📜 Entregar las joyas y registrar el avance en la bitácora",
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
}
