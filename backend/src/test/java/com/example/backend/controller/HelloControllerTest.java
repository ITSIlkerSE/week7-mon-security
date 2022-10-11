package com.example.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturn_Hello_When_RequestWithoutLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
                .andExpect(status().isOk());


    }

    @Test
    @WithMockUser(username = "Ilker", password = "test1234")
    void shouldReturn_Hello_When_RequestWithLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
                .andExpect(status().isOk());


    }


}