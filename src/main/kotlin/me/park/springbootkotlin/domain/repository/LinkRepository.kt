package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Introduction
import me.park.springbootkotlin.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository:JpaRepository<Link, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Link>
}