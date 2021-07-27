package com.example.demo.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User (
    val login: String,
    val firstName: String,
    val lastname: String,
    val description: String? = null,
    @Id @GeneratedValue val id: Long? = null)

