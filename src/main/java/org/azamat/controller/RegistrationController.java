package org.azamat.controller;

import io.swagger.annotations.ApiOperation;
import org.azamat.model.securitymodel.User;
import org.azamat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    @ApiOperation("View registration form")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
    @PostMapping("/registration")
    @ApiOperation("Register new user")
    public String addUser(@ModelAttribute("userForm") User user, Model model) {
        User userDB = userService.findByUsername(user.getUsername());

        if (userDB != null) {
            model.addAttribute("message", "Username already in use, try a different one.");
            return "registration";
        }

         userService.registerUser(user);

        return "redirect:/login";
    }
}
