package me.park.springbootkotlin.admin.context.project.form

import jakarta.validation.constraints.NotBlank
import me.park.springbootkotlin.domain.entity.ProjectDetail

data class ProjectDetailForm(

    val id: Long,

    @field:NotBlank(message = "필수값입니다.")
    val content: String,

    val url: String?,

    val isActive: Boolean
) {
    fun toEntity(): ProjectDetail {
        return ProjectDetail(
            content = this.content,
            url = this.url,
            isActive = this.isActive
        )
    }
}
