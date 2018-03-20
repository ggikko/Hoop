package me.ggikko.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Created by ggikko.park on 2018. 3. 21..
 */
@ConfigurationProperties("app")
class RestApplicationProperties {
    var appName: String? = null
}