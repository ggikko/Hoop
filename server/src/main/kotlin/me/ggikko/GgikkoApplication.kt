package me.ggikko

import me.ggikko.config.RestApplicationProperties
import me.ggikko.util.runWebflux
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean

typealias WebMvcHandlerMapping = org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
typealias WebFluxHandlerMapping = org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping

@SpringBootApplication
@EnableConfigurationProperties(RestApplicationProperties::class)
class GgikkoApplication {

    @Bean
    open fun init(
            ctx: ConfigurableApplicationContext,
            @Value("\${app.appName}") appName: String
    ) = CommandLineRunner {
        println("hello kakaobank $appName")
    }

    @Bean
    open fun webmvcRequestMappingHandlerMapping(
            webfluxMapping: WebFluxHandlerMapping
    ): WebMvcHandlerMapping {
        val mapping = WebMvcHandlerMapping()
        return mapping
    }
}

fun main(args: Array<String>) {
    runWebflux(GgikkoApplication::class, *args)
}
