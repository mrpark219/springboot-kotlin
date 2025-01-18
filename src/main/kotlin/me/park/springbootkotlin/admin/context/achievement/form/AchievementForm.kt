package me.park.springbootkotlin.admin.context.achievement.form

import jakarta.validation.constraints.NotBlank
import me.park.springbootkotlin.domain.entity.Achievement
import java.time.LocalDate

data class AchievementForm(

    @field:NotBlank(message = "필수값입니다.")
    val title: String,

    @field:NotBlank(message = "필수값입니다.")
    val description: String,

    @field:NotBlank(message = "필수값입니다.")
    val host: String,

    @field:NotBlank(message = "필수값입니다.")
    val achievedDate: String,

    val isActive: Boolean

) {
    fun toEntity(): Achievement {
        return Achievement(
            title = this.title,
            description = this.description,
            host = this.host,
            achievedDate = LocalDate.parse(this.achievedDate),
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): Achievement {
        val achievement = this.toEntity()
        achievement.id = id

        return achievement
    }
}
