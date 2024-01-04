package org.learning.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class YearController {
    @GetMapping
    public String home() {
        return "home";
    }
@GetMapping("home")
    public String nameYear(Model model) {
        model.addAttribute("name", "Valerio");
        model.addAttribute("year", "2023");
        return "home";
    }
}
