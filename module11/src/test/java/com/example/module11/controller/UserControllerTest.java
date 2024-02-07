package com.example.module11.controller;

import com.example.module11.entity.User;
import com.example.module11.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    List<User> users;

    @BeforeEach
    public void setup() {
        List<User> users = new ArrayList<>();
        User firstUser = new User();
        firstUser.setAge(23);
        firstUser.setName("Алексей");
        firstUser.setId(1L);
        User secondUser = new User();
        secondUser.setAge(55);
        secondUser.setName("Иван");
        secondUser.setId(2L);
        users.add(firstUser);
        users.add(secondUser);
        this.users = users;
    }
    @Test
    void whenAnonymousUser() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @WithMockUser(username = "user", password = "654321", roles = "USER")
    void whenAuthorityUser() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("showAllUsers"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect(MockMvcResultMatchers.model().attribute("users", users))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @WithMockUser(username = "admin", password = "123456", roles = {"USER", "ADMIN"})
    void whenAuthorityAdmin() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("showAllUsers"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect(MockMvcResultMatchers.model().attribute("users", users))
                .andDo(MockMvcResultHandlers.print());
    }
}