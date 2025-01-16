package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Project
import me.park.springbootkotlin.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {

    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long): Optional<ProjectSkill>
}