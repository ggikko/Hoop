package me.ggikko.domain

/**
 * Created by ggikko.park on 2018. 3. 21..
 */
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.BasicAuth
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * swagger api doc은 https://github.com/springfox/springfox/issues/1773
 * 아직 2.8
 * 2.9부터 webflux, spring5 지원함
 * TODO : API DOC 도 연동해보자 Webflux 가능?
 * 사실 다른 방법도 있음 (라이브러리..)
 */

//@Configuration
//@EnableSwagger2()
//open class SwaggerConfig(
//        @Value("\${app.appName}") appName: String
//) {
//    val API_ROUTE_SWAGGER_UI = "/apidoc.html"
//
//    private val apiInfo by lazy {
//        ApiInfoBuilder()
//                .title(appName)
//                .description("hello world!")
//                .build()
//    }
//
//    @Bean
//    open fun demoApiDocket(): Docket {
//        val groupName = "me.ggikko"
//        val basePackage = "me.ggikko.api.routes"
//
//        return Docket(DocumentationType.SWAGGER_2)
//                .groupName(groupName)
//                .apiInfo(apiInfo)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(basePackage))
//                .build()
//                .securitySchemes(
//                        arrayListOf(
//                                BasicAuth("basic-auth-realm")
//                        )
//                )
//    }
//}

