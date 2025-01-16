package me.park.springbootkotlin.domain.repository

import me.park.springbootkotlin.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {
}