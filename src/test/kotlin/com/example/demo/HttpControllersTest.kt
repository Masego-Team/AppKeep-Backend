package com.example.demo

import com.example.demo.entities.User
import com.example.demo.repositories.UserRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class HttpControllersTest(@Autowired val mockMvc: MockMvc) {

        @MockkBean
        private lateinit var userRepository: UserRepository

        @Test
        fun `Unauthorized request`() {
                mockMvc.perform(get("/api/user/").accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isUnauthorized)
        }

        @Test
        @Disabled("Disabled until @WithMockUser is implemented")
        fun `List users`() {
                val juergen = User("springjuergen", "Juergen", "Hoeller")
                val smaldini = User( "smaldini", "Stéphane", "Maldini")

                every { userRepository.findAll() } returns listOf(juergen, smaldini)
                mockMvc.perform(get("/api/user/").accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk)
                        .andExpect(jsonPath("\$.[0].login").value(juergen.login))
                        .andExpect(jsonPath("\$.[1].login").value(smaldini.login))
        }



}