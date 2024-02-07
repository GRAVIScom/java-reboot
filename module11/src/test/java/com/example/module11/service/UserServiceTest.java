package com.example.module11.service;

import com.example.module11.entity.User;
import com.example.module11.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


class UserServiceTest {
    @Mock
    private UserRepository repository;

    @InjectMocks
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
    void getAllUsers() {
        Mockito.when(repository.findAll()).thenReturn(users);
        Assertions.assertEquals(users, userService.getAllUsers());
    }

    @Test
    public void getUserById() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(users.get(0)));
        Assertions.assertEquals(users.get(0), userService.getUserById(1L).get());
    }

    @Test
    public void createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Владимир");
        user.setAge(33);

        Mockito.when(repository.save(Mockito.any())).thenReturn(user);
    }

    @Test
    public void deleteById() {
        User user = new User();
        user.setId(1L);
        user.setName("Егор");
        user.setAge(18);

        userService.deleteById(user.getId());

        Mockito.verify(repository, Mockito.times(1)).deleteById(user.getId());
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1L);
        user.setName("Анатолий");
        user.setAge(61);

        Mockito.when(repository.save(Mockito.any())).thenReturn(user);

        User editedUser = userService.updateById(user);
        Assertions.assertEquals(editedUser.getId(), user.getId());
        Assertions.assertEquals(editedUser.getAge(), user.getAge());
        Assertions.assertEquals(editedUser.getName(), user.getName());
        Mockito.verify(repository, Mockito.times(1)).save(user);
    }
}