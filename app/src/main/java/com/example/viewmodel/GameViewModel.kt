package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.engine.NativeEngineBridge
import com.example.engine.StoryEngine
import com.example.model.CharacterClass
import com.example.model.GameState
import com.example.model.LogEntry
import com.example.model.StoryChoice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameState())
    val uiState: StateFlow<GameState> = _uiState.asStateFlow()

    fun updateHeroName(name: String) {
        _uiState.update { it.copy(heroName = name) }
    }

    fun selectClass(characterClass: CharacterClass) {
        _uiState.update {
            it.copy(
                characterClass = characterClass,
                currentHp = characterClass.baseHp,
                maxHp = characterClass.baseHp,
                inventory = listOf(characterClass.weaponName, characterClass.armorName, "Raciones de Viaje")
            )
        }
    }

    fun startGame() {
        val currentState = _uiState.value
        val nameToUse = currentState.heroName.trim().ifBlank { "Aventurero" }
        val initialScene = StoryEngine.getScene("SCENE_TAVERN_INTRO")
        val formattedNarrative = StoryEngine.formatNarrative(
            initialScene.narrativeTemplate,
            nameToUse,
            currentState.characterClass
        )

        val firstEntry = LogEntry(
            title = initialScene.title,
            text = formattedNarrative,
            choiceMadeText = null
        )

        _uiState.update {
            it.copy(
                heroName = nameToUse,
                isGameStarted = true,
                currentSceneId = "SCENE_TAVERN_INTRO",
                storyLog = listOf(firstEntry)
            )
        }
    }

    fun makeChoice(choice: StoryChoice) {
        val currentState = _uiState.value

        if (choice.targetSceneId == "SCENE_RESTART") {
            resetGame()
            return
        }

        // Apply health change through Native Engine calculation if damage occurs
        val hpDelta = if (choice.hpChange < 0) {
            -NativeEngineBridge.calculateCombatDamage(
                baseDamage = kotlin.math.abs(choice.hpChange),
                defense = 0,
                seed = System.currentTimeMillis()
            )
        } else {
            choice.hpChange
        }

        var newHp = (currentState.currentHp + hpDelta).coerceIn(0, currentState.maxHp)
        var newGold = (currentState.gold + choice.goldReward).coerceAtLeast(0)
        var newExp = currentState.experience + choice.expReward
        var newLevel = currentState.level

        // Level up check
        if (newExp >= newLevel * 100) {
            newLevel += 1
            newExp -= (newLevel - 1) * 100
            val maxHpBonus = 20
            val newMaxHp = currentState.maxHp + maxHpBonus
            newHp = newMaxHp // Full heal on level up
            
            val levelNotice = LogEntry(
                title = "✨ ¡NIVEL DE HÉROE AUMENTADO!",
                text = "¡Has alcanzado el Nivel $newLevel! Tu vida máxima ha aumentado a $newMaxHp y te sientes lleno de energía.",
                isSystemNotice = true
            )
            _uiState.update { it.copy(storyLog = it.storyLog + levelNotice) }
        }

        // Inventory update
        val newInventory = currentState.inventory.toMutableList()
        choice.itemAdded?.let { item ->
            if (!newInventory.contains(item)) {
                newInventory.add(item)
            }
        }

        // Evaluate target scene (via NativeEngineBridge branch routing)
        val targetSceneIdToUse = NativeEngineBridge.evaluateEpilogueBranch(
            currentSceneId = currentState.currentSceneId,
            choiceId = choice.id,
            gold = newGold,
            heroLevel = newLevel
        ).ifBlank { choice.targetSceneId }

        val resolvedSceneId = if (targetSceneIdToUse != choice.targetSceneId && targetSceneIdToUse != "SCENE_VICTORY_DEMO") {
            targetSceneIdToUse
        } else {
            choice.targetSceneId
        }

        val nextScene = StoryEngine.getScene(resolvedSceneId)
        val formattedNarrative = StoryEngine.formatNarrative(
            nextScene.narrativeTemplate,
            currentState.heroName,
            currentState.characterClass
        )

        val newLogEntry = LogEntry(
            title = nextScene.title,
            text = formattedNarrative,
            choiceMadeText = choice.text
        )

        _uiState.update {
            it.copy(
                currentHp = newHp,
                gold = newGold,
                experience = newExp,
                level = newLevel,
                inventory = newInventory,
                currentSceneId = nextScene.id,
                storyLog = it.storyLog + newLogEntry
            )
        }
    }

    fun resetGame() {
        val defaultClass = CharacterClass.GUERRERO
        _uiState.update {
            GameState(
                heroName = "",
                characterClass = defaultClass,
                isGameStarted = false,
                currentHp = defaultClass.baseHp,
                maxHp = defaultClass.baseHp,
                gold = 5,
                experience = 0,
                level = 1,
                inventory = listOf(defaultClass.weaponName, defaultClass.armorName, "Raciones de Viaje"),
                currentSceneId = "SCENE_TAVERN_INTRO",
                storyLog = emptyList()
            )
        }
    }
}
