package com.nagp.devops.assignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nagp.devops.assignment.resource.User;
import com.nagp.devops.assignment.resource.UserRepository;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserApplicationUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @Test
    public void getUsersTest() throws Exception {
        when(userRepository.findAll()).thenReturn(
                Collections.emptyList()
        );
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/users/")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();
        System.out.println(mvcResult.getResponse());
        verify(userRepository).findAll();
    }
    
    @Test
    public void getUserByIdTest() throws Exception {
        when(userRepository.findById(1)).thenReturn(createUser());
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/users/1")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();
        System.out.println(mvcResult.getResponse());
        verify(userRepository).findById(1);
    }
    
	private User createUser() {
		User user = new User();
		user.setId(1);
		user.setName("Rohit Kumar");
		user.setEmail("rohit.chhonker@gmail.com");
		user.setJobTitle("Business Analyst");
		user.setPhone("9768987642");
		user.setImageUrl("profile.jpg");
		return user;
	}
}
