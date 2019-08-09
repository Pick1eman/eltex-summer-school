package ru.eltex;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/get_user")
    public User getUser(@RequestParam("id") Integer id){
        System.out.println(id);
        return new User(1,"Boris","900");
    }
    @RequestMapping("/get_user/{id}")
    public User getUser1(@PathVariable("id") Integer id){
        System.out.println(id);
        return new User(id,"Eugene","22321321");
    }
}
