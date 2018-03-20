package me.ggikko.domain

import java.time.Instant

/**
 * Created by ggikko.park on 2018. 3. 21..
 */
data class HireInfo(val id: String,
                    val createdAt: Instant,
                    val category: String,
                    val title: String,
                    val link: String,
                    val content: String)

