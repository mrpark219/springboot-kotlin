package me.park.springbootkotlin.admin.context.introduction.form

import jakarta.validation.constraints.NotBlank
import me.park.springbootkotlin.domain.entity.Introduction

data class IntroductionForm(

    @field:NotBlank(message = "필수값입니다.")
    val content: String,

    val isActive: Boolean
) {
    fun toEntity(): Introduction {
        return Introduction(
            content = this.content,
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): Introduction {
        val introduction = this.toEntity()
        introduction.id = id

        return introduction
    }
}
