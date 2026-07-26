package com.example.model

enum class CharacterClass(
    val title: String,
    val description: String,
    val baseHp: Int,
    val weaponName: String,
    val armorName: String,
    val iconEmoji: String
) {
    GUERRERO(
        title = "Guerrero Novato",
        description = "20 años. Trabajaste años en la taberna familiar. Empiezas desde cero con valor y acero oxidado.",
        baseHp = 100,
        weaponName = "Espada Mella de Madera",
        armorName = "Peto de Cuero Desgastado",
        iconEmoji = "🗡️"
    ),
    MAGO(
        title = "Mago Arcano",
        description = "Erudito de las artes místicas. Lanza hechizos devastadores.",
        baseHp = 80,
        weaponName = "Báculo de Fuego",
        armorName = "Túnica de Seda Estelar",
        iconEmoji = "🪄"
    ),
    PICARO(
        title = "Pícaro",
        description = "Ágil y sigiloso. Experto en esquiva y golpes críticos.",
        baseHp = 95,
        weaponName = "Dagas Gemelas",
        armorName = "Capa de Cuero",
        iconEmoji = "🗡️"
    ),
    EXPLORADOR(
        title = "Explorador",
        description = "Rastreador astuto del bosque. Certero con el arco.",
        baseHp = 100,
        weaponName = "Arco de Roble",
        armorName = "Chaleco de Gran Espectro",
        iconEmoji = "🏹"
    )
}

data class StoryChoice(
    val id: String,
    val text: String,
    val targetSceneId: String,
    val hpChange: Int = 0,
    val goldReward: Int = 0,
    val expReward: Int = 0,
    val itemAdded: String? = null
)

data class StoryScene(
    val id: String,
    val title: String,
    val narrativeTemplate: String,
    val choices: List<StoryChoice>
)

data class LogEntry(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val text: String,
    val choiceMadeText: String? = null,
    val isSystemNotice: Boolean = false
)

data class GameState(
    val heroName: String = "",
    val characterClass: CharacterClass = CharacterClass.GUERRERO,
    val isGameStarted: Boolean = false,
    val currentHp: Int = 100,
    val maxHp: Int = 100,
    val gold: Int = 5,
    val experience: Int = 0,
    val level: Int = 1,
    val inventory: List<String> = listOf("Raciones de Viaje", "Antorcha de Resina"),
    val currentSceneId: String = "SCENE_TAVERN_INTRO",
    val storyLog: List<LogEntry> = emptyList()
)
