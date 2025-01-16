package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Experience
import me.park.springbootkotlin.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ProjectRepository : JpaRepository<Project, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Project>
}