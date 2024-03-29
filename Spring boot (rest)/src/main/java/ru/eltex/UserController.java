package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
    private ObjectMapper mapper = new ObjectMapper();
    public static ArrayList<User> users = new ArrayList<>();
//    @RequestMapping("/get_user")
//    public User getUser(@RequestParam("id") Integer id){
//        System.out.println(id);
//        return new User(1,"Boris","900");
//    }
//    @RequestMapping("/get_user/{id}")
//    public User getUser1(@PathVariable("id") Integer id){
//        System.out.println(id);
//        return new User(id,"Eugene","22321321");
//    }
    @RequestMapping("/get_users")
    public String getUsers() throws JsonProcessingException {
        users.clear();
        users.add(new User(1,"Eugene","233113"));
        users.add(new User(2,"Boris","12121"));
        return mapper.writeValueAsString(users);
    }

}
