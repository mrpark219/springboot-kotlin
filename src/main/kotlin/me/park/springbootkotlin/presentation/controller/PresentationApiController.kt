package me.park.springbootkotlin.presentation.controller

import me.park.springbootkotlin.presentation.dto.IntroductionDTO
import me.park.springbootkotlin.presentation.dto.LinkDTO
import me.park.springbootkotlin.presentation.dto.ProjectDTO
import me.park.springbootkotlin.presentation.dto.ResumeDTO
import me.park.springbootkotlin.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String {
        return "OK"
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return presentationService.getIntroductions()
    }

    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO> {
        return presentationService.getLinks()
    }

    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO {
        return presentationService.getResume()
    }

    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO> {
        return presentationService.getProjects()
    }

}
