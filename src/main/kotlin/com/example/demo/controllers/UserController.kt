package com.example.demo.controllers

import com.example.demo.entities.User
import com.example.demo.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.rmi.ServerException


@RestController
@RequestMapping("/user")
class UserController(private val repository: UserRepository) {

    @GetMapping
    fun findAll() = repository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String): User {
        return repository.findByLogin(login) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This user does not exist"
        )
    }

    @PostMapping
    fun addUser(@RequestBody newUser: User): ResponseEntity<User> {
        val user: User = repository.save(newUser)
        return ResponseEntity(user, HttpStatus.CREATED)
    }


}