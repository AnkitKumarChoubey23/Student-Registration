package com.example.studentregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.studentregistration.model.User;
import com.example.studentregistration.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 🔹 Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 🔹 Process Login
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user = userService.validateUser(email, password);

        if (user != null) {
            session.setAttribute("loggedUser", user);
            session.setAttribute("role", user.getRole());
            return "redirect:/students";
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    // 🔹 Show User Registration Page
    @GetMapping("/register-user")
    public String showUserRegistration(Model model) {
        model.addAttribute("user", new User());
        return "register-user";
    }

    // 🔹 Save New User
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, Model model) {

        // Check duplicate email
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("error", "Email already registered");
            return "register-user";
        }

        userService.saveUser(user);
        model.addAttribute("message", "Registration successful. Please login.");
        return "login";
    }

    // 🔹 Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
