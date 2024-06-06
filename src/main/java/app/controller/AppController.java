package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String contact(Model model) {
        model.addAttribute("first_name", "Tom");
        model.addAttribute("last_Name", "Green");
        model.addAttribute("phone","555 777 999");
        return "layout";
    }
}
