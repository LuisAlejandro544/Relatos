package com.example.model

data class LogEntry(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val text: String,
    val choiceMadeText: String? = null,
    val isSystemNotice: Boolean = false
)
