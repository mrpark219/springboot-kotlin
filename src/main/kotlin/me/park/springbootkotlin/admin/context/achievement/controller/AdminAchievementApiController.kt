package me.park.springbootkotlin.admin.context.achievement.controller

import me.park.springbootkotlin.admin.context.achievement.form.AchievementForm
import me.park.springbootkotlin.admin.context.achievement.service.AdminAchievementService
import me.park.springbootkotlin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/achievements")
class AdminAchievementApiController(
    private val adminAchievementService: AdminAchievementService
) {

    @PostMapping
    fun postAchievement(@RequestBody @Validated form: AchievementForm): ResponseEntity<Any> {
        adminAchievementService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putAchievement(@PathVariable id: Long, @RequestBody form: AchievementForm): ResponseEntity<Any> {
        adminAchievementService.update(id, form)

        return ApiResponse.successUpdate()
    }
}
