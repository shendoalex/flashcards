package ru.shendo.flashcards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import ru.shendo.flashcards.entity.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        // Добавьте вашу логику входа здесь
        return "redirect:/home";
    }
}