package org.azamat.controller;

import org.azamat.model.securitymodel.User;
import org.azamat.model.securitymodel.Role;
import org.azamat.service.OrderProductService;
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

    @Autowired
    OrderProductService orderProductService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
/*        model.addAttribute("cartCount", orderProductService.size());*/

        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User user, Model model) {
        User userDB = userService.findByUsername(user.getUsername());

        if (userDB != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
         userService.registerUser(user);

        return "redirect:/login";
    }
}
