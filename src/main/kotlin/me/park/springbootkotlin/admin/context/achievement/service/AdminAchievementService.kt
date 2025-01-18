package me.park.springbootkotlin.admin.context.achievement.service

import me.park.springbootkotlin.admin.context.achievement.form.AchievementForm
import me.park.springbootkotlin.admin.data.TableDTO
import me.park.springbootkotlin.domain.entity.Achievement
import me.park.springbootkotlin.domain.repository.AchievementRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: AchievementForm) {
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    @Transactional
    fun update(id: Long, form: AchievementForm) {
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }
}
