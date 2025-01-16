package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.constant.SkillType
import me.park.springbootkotlin.domain.entity.Introduction
import me.park.springbootkotlin.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository : JpaRepository<Skill, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Skill>

    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>
}