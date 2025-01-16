package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ExperienceRepository : JpaRepository<Experience, Long> {

    @Query("SELECT e FROM Experience e LEFT JOIN FETCH e.details WHERE e.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Experience>

    @Query("SELECT e FROM Experience e LEFT JOIN FETCH e.details where e.id = :id")
    override fun findById(id: Long): Optional<Experience>
}