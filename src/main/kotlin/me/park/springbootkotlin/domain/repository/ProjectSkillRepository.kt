package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Project
import me.park.springbootkotlin.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {
}