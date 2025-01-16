package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long> {
}