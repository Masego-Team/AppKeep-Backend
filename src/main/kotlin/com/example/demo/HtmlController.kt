package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController (private val properties: DemoProperties){

    @GetMapping("/")
    fun demo(model: Model): String {
        model["title"] = properties.title
        model["banner"] = properties.banner
        return "demo"
    }

    @GetMapping("/authenticated")
    fun authenticated(model: Model): String {
        model["title"] = properties.title
        return "test"
    }

    @GetMapping("/login")
    fun login(model: Model): String {
        return "login"
    }

}