package me.park.springbootkotlin.presentation.dto

data class AchievementDTO(
    val title: String,
    val description: String,
    val host: String,
    val achievedDate: String?
)
