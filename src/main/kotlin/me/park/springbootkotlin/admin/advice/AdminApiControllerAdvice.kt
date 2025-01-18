package me.park.springbootkotlin.admin.advice

import io.github.oshai.kotlinlogging.KotlinLogging
import me.park.springbootkotlin.admin.exception.AdminException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val logger = KotlinLogging.logger {}

@RestControllerAdvice
class AdminApiControllerAdvice {

    @ExceptionHandler
    fun handleException(e: AdminException): ResponseEntity<String> {
        logger.info(e) { e.message }

        return ResponseEntity.status(e.httpStatus).body(e.message)
    }

    @ExceptionHandler
    fun handleException(e: MethodArgumentNotValidException): ResponseEntity<String> {
        logger.info(e) { e.message }

        val fieldError = e.bindingResult.fieldErrors[0]
        val message = "[${fieldError.field}] ${fieldError.defaultMessage}"

        return ResponseEntity.badRequest().body(message)
    }

    @ExceptionHandler
    fun handleException(e: Exception): ResponseEntity<String> {
        logger.info(e) { e.message }

        return ResponseEntity.internalServerError().body("시스템 오류가 발생했습니다.")
    }
}
