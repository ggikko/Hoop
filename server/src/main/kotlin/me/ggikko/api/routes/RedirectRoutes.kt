package me.ggikko.api.routes

import me.ggikko.api.handler.HireInfoHandler
import me.ggikko.util.permanentRedirect
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

/**
 * Created by ggikko.park on 2018. 3. 21..
 */
@Component
class RedirectRoutes(private val hireInfoHandler: HireInfoHandler) {

    @Bean
    fun redirectRouter() = router {
        accept(MediaType.TEXT_HTML).nest {
            "/hire".nest {
                GET("/") { permanentRedirect("/hire/info") }
                (GET("/{id}") or GET("/{id}/")).invoke(hireInfoHandler::findOne)
            }
        }
    }
}