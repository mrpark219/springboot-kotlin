package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Experience
import me.park.springbootkotlin.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface ProjectRepository : JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.skills s LEFT JOIN FETCH s.skill WHERE p.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Project>

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>
}