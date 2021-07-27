package com.example.demo.controllers

import com.example.demo.entities.User
import com.example.demo.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/user")
class UserController(private val repository: UserRepository) {

    @PostConstruct
    fun initial() {
        repository.save(User("userNameCheckout","Juanito", "deLos", "Palotes"))
    }

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String): User {
        return repository.findByLogin(login) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This user does not exist"
        )
    }

}