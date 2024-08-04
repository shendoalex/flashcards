package ru.shendo.flashcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shendo.flashcards.dto.UserRegistrationDto;
import ru.shendo.flashcards.service.CustomUserDetailsService;

@Controller
public class RegistrationController {

    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public RegistrationController(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userDetailsService.registerNewUser(registrationDto);
        return "redirect:/login"; // Перенаправление на страницу авторизации после успешной регистрации
    }
}