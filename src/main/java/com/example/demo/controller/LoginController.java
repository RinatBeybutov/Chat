package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        UserEntity entity = new UserEntity();
        model.addAttribute("user", entity);
        return "register";
    }

    @PostMapping("/register")
    public String register(UserEntity u, Model model, BindingResult result) {
        try {
            userService.createUserByEntity(u);
        } catch (Exception e) {
            // Не работает!
            model.addAttribute("user", u);
            result.rejectValue("email", "error.email.invalid", e.getMessage());
            return "register";
        }
        return "redirect:/login";
    }
}
