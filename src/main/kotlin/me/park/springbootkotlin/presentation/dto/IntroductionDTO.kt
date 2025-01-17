package me.park.springbootkotlin.presentation.dto

import me.park.springbootkotlin.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}
