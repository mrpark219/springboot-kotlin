package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository:JpaRepository<Link, Long> {
}