package me.ggikko.api.handler

import kotlinx.support.jdk8.streams.toList
import me.ggikko.domain.HireInfo
import me.ggikko.domain.HireInfoService
import me.ggikko.util.json
import me.ggikko.util.kabangBoard
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by ggikko.park on 2018. 3. 21..
 */
@Component
class HireInfoHandler(private val hireInfoService: HireInfoService) {

    data class AddRequest(val category: String,
                          val title: String,
                          val link: String,
                          val content: String)

    data class AddResponse(val id: String)
    data class HireInfoResponse(val infos: List<HireInfo>)

    fun update(req: ServerRequest): Mono<ServerResponse> {
        kabangBoard().forEach {
            hireInfoService.save(hireInfoService.create(it))
        }

        val infosResponse = HireInfoResponse(
                infos = hireInfoService
                        .getAll()
                        .toStream()
                        .toList()
        )

        return ServerResponse
                .ok()
                .json()
                .body(Mono.just(infosResponse))
    }

    fun addOne(req: ServerRequest): Mono<ServerResponse> {
        val addRequest: Mono<AddRequest> =
                req.bodyToMono(AddRequest::class.java)

        val addResponse: Mono<AddResponse> = addRequest
                .flatMap {
                    val hireInfo = hireInfoService
                            .add(category = it.category,
                                    title = it.title,
                                    link = it.link,
                                    content = it.content)
                    hireInfoService.save(hireInfo)
                    Flux.just(AddResponse(id = hireInfo.id))
                    Mono.just(AddResponse(id = hireInfo.id))
                }

        return ServerResponse
                .ok()
                .json()
                .body(addResponse)
    }

    fun findAll(req: ServerRequest): Mono<ServerResponse> {
        val infosResponse = HireInfoResponse(
                infos = hireInfoService
                        .getAll()
                        .toStream()
                        .toList()
        )

        return ServerResponse
                .ok()
                .json()
                .body(Mono.just(infosResponse))
    }

    fun findOne(req: ServerRequest): Mono<ServerResponse> {
        val hireInfo = hireInfoService.get(req.pathVariable("id"))

        return ServerResponse.ok()
                .json()
                .body(hireInfo)
    }

    fun removeAll(req: ServerRequest): Mono<ServerResponse> {
        hireInfoService.removeAll()
        return ServerResponse.ok()
                .json()
                .body(Mono.just(true))
    }
}