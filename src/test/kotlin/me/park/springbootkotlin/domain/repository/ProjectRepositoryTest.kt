package me.park.springbootkotlin.domain.repository

import io.github.oshai.kotlinlogging.KotlinLogging
import me.park.springbootkotlin.domain.constant.SkillType
import me.park.springbootkotlin.domain.entity.Project
import me.park.springbootkotlin.domain.entity.ProjectDetail
import me.park.springbootkotlin.domain.entity.ProjectSkill
import me.park.springbootkotlin.domain.entity.Skill
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

private val logger = KotlinLogging.logger {}

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProjectRepositoryTest(
    @Autowired val projectRepository: ProjectRepository,
    @Autowired val skillRepository: SkillRepository
) {
    val DATA_SIZE = 10

    private fun createProject(n: Int): Project {
        val project = Project(
            name = "${n}",
            description = "테스트 설명 ${n}",
            startYear = 2025,
            startMonth = 1,
            endYear = 2023,
            endMonth = 1,
            isActive = true
        )

        val details = mutableListOf<ProjectDetail>()
        for (i in 1..n) {
            val projectDetail = ProjectDetail(content = "테스트 ${i}", url = null, isActive = true)
            details.add(projectDetail)
        }
        project.addDetails(details)

        val skills = skillRepository.findAll()
        val skillsUsedInProject = skills.subList(0, n)
        for (skill in skillsUsedInProject) {
            val projectSkill = ProjectSkill(project = project, skill = skill)
            project.skills.add(projectSkill)
        }

        return project
    }

    @BeforeAll
    fun beforeAll() {

        logger.info { "스킬 데이터 초기화 시작" }

        val skills = mutableListOf<Skill>()
        for (i in 1..DATA_SIZE) {
            val skillTypes = SkillType.values()
            val skill = Skill(name = "테스트 ${i}", type = skillTypes[i % skillTypes.size].name, isActive = true)
            skills.add(skill)
        }

        skillRepository.saveAll(skills)

        logger.info { "스킬 데이터 초기화 종료" }

        logger.info { "데이터 초기화 이전 조회 시작" }

        val beforeInsert = projectRepository.findAll()
        assertThat(beforeInsert).hasSize(0)

        logger.info { "데이터 초기화 이전 조회 종료" }

        logger.info { "테스트 데이터 초기화 시작" }
        val projects = mutableListOf<Project>()
        for (i in 1..DATA_SIZE) {
            val project = createProject(i)
            projects.add(project)
        }
        projectRepository.saveAll(projects)
        logger.info { "테스트 데이터 초기화 종료" }
    }

    @Test
    fun testFindAll() {

        logger.info { "findAll 테스트 시작" }

        val projects = projectRepository.findAll()
        assertThat(projects).hasSize(DATA_SIZE)
        logger.info { "projects.size: ${projects.size}" }

        for (project in projects) {
            assertThat(project.details).hasSize(project.name.toInt())
            logger.info { "project.details.size: ${project.details.size}" }

            assertThat(project.skills).hasSize(project.name.toInt())
            logger.info { "project.skills.size: ${project.skills.size}" }
        }

        logger.info { "findAll 테스트 종료" }
    }

    @Test
    fun testFindAllByIsActive() {

        logger.info { "findAllByIsActive 테스트 시작" }
        val projects = projectRepository.findAllByIsActive(true)
        assertThat(projects).hasSize(DATA_SIZE)
        logger.info { "projects.size: ${projects.size}" }

        for (project in projects) {
            assertThat(project.details).hasSize(project.name.toInt())
            logger.info { "project.details.size: ${project.details.size}" }

            assertThat(project.skills).hasSize(project.name.toInt())
            logger.info { "project.skills.size: ${project.skills.size}" }
        }

        logger.info { "findAllByIsActive 테스트 종료" }
    }
}