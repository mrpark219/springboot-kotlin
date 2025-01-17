package me.park.springbootkotlin.presentation.dto

import me.park.springbootkotlin.domain.entity.Link

data class LinkDTO(
    val name: String,
    val content: String
) {
    constructor(link: Link) : this(
        name = link.name.lowercase(),
        content = link.content
    )
}
