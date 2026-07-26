package com.example.model

data class StoryScene(
    val id: String,
    val title: String,
    val narrativeTemplate: String,
    val choices: List<StoryChoice>
)
