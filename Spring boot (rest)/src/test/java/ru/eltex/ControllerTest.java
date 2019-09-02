package ru.eltex;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    private ArrayList<User> users = new ArrayList<User>();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() throws Exception {
        org.assertj.core.api.Assertions.assertThat(controller).isNotNull();
    }

    @Test
    public void getUsers() throws Exception {
        users.clear();
        users.add(new User(1, "Eugene", "233113"));
        users.add(new User(2, "Boris", "12121"));

        ObjectMapper mapper = new ObjectMapper();
        String expected = mapper.writeValueAsString(users);
        System.out.println(expected);
        this.mockMvc.perform(get("http://localhost:8081/get_users")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }
}