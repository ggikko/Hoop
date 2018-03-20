package me.ggikko.api.routes

import me.ggikko.api.handler.HireInfoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.reactive.function.server.router

/**
 * Created by ggikko.park on 2018. 3. 21..
 */

@Configuration
open class ApiRoutes(private val hireInfoHandler: HireInfoHandler) {

    @Bean
    open fun apiHireRouter() = router {
        (accept(MediaType.APPLICATION_JSON) and "/hire").nest {
            "/info".nest {
                POST("/add", hireInfoHandler::addOne)
                GET("/remove", hireInfoHandler::removeAll) //TODO 그냥 다 GET :D
                GET("/", hireInfoHandler::findAll)
                GET("/update", hireInfoHandler::update)
                GET("/{id}", hireInfoHandler::findOne)
            }
        }
    }

    @Scheduled(fixedRate = 10000)
    fun getEmployeeInfoAndParse() {
        //TODO update 주기적으로 카뱅 채용정보 가져오기
    }
}