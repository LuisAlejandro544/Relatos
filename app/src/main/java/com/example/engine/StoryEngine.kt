package com.example.engine

import com.example.engine.scenes.Chapter1Scenes
import com.example.engine.scenes.EpilogueScenes
import com.example.engine.scenes.PrologueScenes
import com.example.model.CharacterClass
import com.example.model.StoryScene

object StoryEngine {

    private val scenes: Map<String, StoryScene> = PrologueScenes.scenes +
            EpilogueScenes.scenes +
            Chapter1Scenes.scenes

    fun getScene(id: String): StoryScene {
        return scenes[id] ?: scenes["SCENE_TAVERN_INTRO"]!!
    }

    fun formatNarrative(template: String, heroName: String, characterClass: CharacterClass): String {
        return template
            .replace("{HERO_NAME}", heroName.ifBlank { "Héroe Sin Nombre" })
            .replace("{CLASS}", characterClass.title)
            .replace("{WEAPON}", characterClass.weaponName)
            .replace("{ARMOR}", characterClass.armorName)
    }
}
