package me.ggikko.domain

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import org.jsoup.nodes.Element
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.Instant
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by ggikko.park on 2018. 3. 21..
 */
data class HireInfo(val id: String,
                    val createdAt: Instant,
                    val category: String,
                    val title: String,
                    val link: String,
                    val content: String)

@Component
class HireInfoService(private val repository: HireInfoRepository) {

    fun create(document: Element) = HireInfo(
            id = "${System.nanoTime()}-${UUID.randomUUID()}",
            createdAt = Instant.now(),
            category = document.getElementsByClass("txt_cate").get(0).text(),
            title = document.getElementsByClass("tit_board").get(0).text(),
            link = document.getElementsByClass("link_board").get(0).attr("href"),
            content = document.getElementsByClass("info_cont").get(0).select("p").text()
    )

    fun add(category: String, title: String, link: String, content: String) = HireInfo(
            id = "${System.nanoTime()}-${UUID.randomUUID()}",
            createdAt = Instant.now(),
            category = category,
            title = title,
            link = link,
            content = content
    )

    fun save(info: HireInfo) = repository.add(info)
    fun get(infoId: String) = repository.getOrNull(infoId)
    fun removeAll() = repository.removeAll()
    fun getAll() = repository.getItems()
}

typealias HireInfoRepositoryCache = Cache<String, HireInfo>
@Component
class HireInfoRepository {
    private val cache: HireInfoRepositoryCache by lazy {
        val expiry = Duration.ofDays(10)

        //TODO : levelDB(for Block Chain), Cassandra(for Async DB), 지금은 임시 memory cache
        Caffeine
                .newBuilder()
                .maximumSize(1_000_000)
                .expireAfterWrite(expiry.seconds, TimeUnit.SECONDS)
                .build<String, HireInfo>()
    }

    fun add(item: HireInfo) {
        cache.put(item.id, item)
    }

    fun getOrNull(itemId: String): Mono<HireInfo> = Mono.justOrEmpty(cache.getIfPresent(itemId))

    fun getItems(): Flux<HireInfo> = Flux.fromIterable(cache.asMap().values)

    fun removeAll() = cache.cleanUp()
}
