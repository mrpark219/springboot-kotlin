package me.park.springbootkotlin.admin.context.link.service

import me.park.springbootkotlin.admin.context.link.form.LinkForm
import me.park.springbootkotlin.admin.data.TableDTO
import me.park.springbootkotlin.domain.entity.Link
import me.park.springbootkotlin.domain.repository.LinkRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {

    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: LinkForm) {
        val link = form.toEntity()

        linkRepository.save(link)
    }

    @Transactional
    fun update(id: Long, form: LinkForm) {
        val link = form.toEntity(id)

        linkRepository.save(link)
    }
}
