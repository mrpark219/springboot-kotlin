package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long> {
}