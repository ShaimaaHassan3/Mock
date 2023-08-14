package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepo;
import com.example.demo.services.UserServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


@ExtendWith(MockitoExtension.class)
public class UserServicesTest {
    @Mock
    UserRepo userRepoMock;
    @InjectMocks
    UserServices userServices;

    @BeforeEach
    void setUp() {
        userServices = new UserServices(userRepoMock);
    }

    @Test
    public void testAddNewUser() {

        userServices.add(new User(60,"Mostafaa", 12));
        verify(userRepoMock).save(Mockito.any(User.class));
//        verify(userRepoMock).save(new User("Shaimaa", 12));

    }

    @Test
    public void testRetrievingUser() {
        User user = new User(70,"Shaimaa",22);
        when(userRepoMock.findById(70)).thenReturn(user);
        String userName = userServices.getById(70);
        assertEquals(userName, "Shaimaa");

    }
}
