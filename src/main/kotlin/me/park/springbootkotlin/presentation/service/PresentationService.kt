package me.park.springbootkotlin.presentation.service

import me.park.springbootkotlin.presentation.dto.IntroductionDTO
import me.park.springbootkotlin.presentation.dto.LinkDTO
import me.park.springbootkotlin.presentation.dto.ProjectDTO
import me.park.springbootkotlin.presentation.dto.ResumeDTO
import me.park.springbootkotlin.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {

    @Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDTO> {

        val introductions = presentationRepository.getActiveIntroductions()

        return introductions.map { IntroductionDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {

        val links = presentationRepository.getActiveLinks()

        return links.map { LinkDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {

        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills
        )
    }

    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {

        val projects = presentationRepository.getActiveProjects()

        return projects.map { ProjectDTO(it) }
    }

}
