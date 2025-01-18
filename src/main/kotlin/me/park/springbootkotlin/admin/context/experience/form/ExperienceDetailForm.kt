package me.park.springbootkotlin.admin.context.experience.form

import jakarta.validation.constraints.NotBlank
import me.park.springbootkotlin.domain.entity.ExperienceDetail

data class ExperienceDetailForm(

    val id: Long,

    @field:NotBlank(message = "필수값입니다.")
    val content: String,

    val isActive: Boolean
) {
    fun toEntity(): ExperienceDetail {
        return ExperienceDetail(
            content = this.content,
            isActive = this.isActive
        )
    }
}
