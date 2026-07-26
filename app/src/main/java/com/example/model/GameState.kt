package com.example.model

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
