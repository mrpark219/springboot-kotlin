package me.park.springbootkotlin.presentation.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import me.park.springbootkotlin.domain.entity.HttpInterface
import me.park.springbootkotlin.domain.repository.HttpInterfaceRepository
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class PresentationInterceptor(
    private val httpInterfaceRepository: HttpInterfaceRepository
) : HandlerInterceptor {

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        val httpInterface = HttpInterface(request)
        httpInterfaceRepository.save(httpInterface)
    }

}
