package com.example.demo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("demo")
data class DemoProperties(var title: String, val banner: Banner) {
    data class Banner(val title: String? = null, val content: String)
}