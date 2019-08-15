package ru.eltex;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {
    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("user1",new User(1,"Eugene","900"));
        model.addAttribute("user2",new User(2,"Alexey","872140"));
        return "index";
    }
    @RequestMapping("/admin")
    public String admin(Model model) {
        return "";
    }
}
