package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long> {
}