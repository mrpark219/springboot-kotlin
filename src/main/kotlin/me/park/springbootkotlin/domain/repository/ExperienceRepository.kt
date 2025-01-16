package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long> {
}