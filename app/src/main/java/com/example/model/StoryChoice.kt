package com.example.model

data class StoryChoice(
    val id: String,
    val text: String,
    val targetSceneId: String,
    val hpChange: Int = 0,
    val goldReward: Int = 0,
    val expReward: Int = 0,
    val itemAdded: String? = null
)
