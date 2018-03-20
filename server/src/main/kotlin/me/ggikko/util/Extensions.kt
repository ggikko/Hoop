package me.ggikko.util

import org.jsoup.Jsoup
import org.springframework.boot.WebApplicationType
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse
import java.net.URI
import kotlin.reflect.KClass

/**
 * Created by ggikko.park on 2018. 3. 21..
 */

fun runWebflux(type: KClass<*>, vararg args: String) = SpringApplicationBuilder()
        .sources(type.java)
        .web(WebApplicationType.REACTIVE)
        .run(*args)

fun ServerResponse.BodyBuilder.json() = contentType(MediaType.APPLICATION_JSON_UTF8)

fun ServerResponse.BodyBuilder.xml() = contentType(MediaType.APPLICATION_XML)

fun ServerResponse.BodyBuilder.html() = contentType(MediaType.TEXT_HTML)

fun permanentRedirect(uri: String) = ServerResponse.permanentRedirect(URI(uri)).build()

//temporary...
fun kabangBoard() = Jsoup.connect("https://www.kakaobank.com/Corp/Recruit/CurrentOpportunities")
        .header("Accept-Encoding", "gzip, deflate")
        .userAgent("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
        .header("Accept-Language", "en-US")
        .header("Accept-Encoding", "gzip,deflate,sdch")
        .maxBodySize(0)
        .timeout(600000)
        //.cookies(response.cookies()) //임시
        .get()
        .getElementsByClass("board_accordion")[0]
        .children()
