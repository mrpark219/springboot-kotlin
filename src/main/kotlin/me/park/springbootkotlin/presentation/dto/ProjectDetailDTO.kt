package me.park.springbootkotlin.presentation.dto

import me.park.springbootkotlin.domain.entity.ProjectDetail


data class ProjectDetailDTO(
    val content: String,
    val url: String?
) {
    constructor(projectDetail: ProjectDetail) : this(
        content = projectDetail.content,
        url = projectDetail.url
    )
}
