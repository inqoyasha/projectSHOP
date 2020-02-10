package org.azamat.controller;

import org.azamat.model.securitymodel.User;
import org.azamat.service.OrderProductService;
import org.azamat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserPageController {

    @Autowired
    private UserService userService;

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    HttpSession session;

    @GetMapping("/account")
    public String account(Model model) {
        User userSession = (User)session.getAttribute("connectedUser");
        userService.findById(userSession.getId());
        model.addAttribute("userPage", userSession);
        model.addAttribute("cartCount", orderProductService.size());

        return "userpage";
    }

    @PostMapping("/account")
    public String saveData(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName,
                           @RequestParam(value = "patronymic", required = false) String patronymic,
                           @RequestParam(value = "email", required = false) String email,
                           @RequestParam(value = "address", required = false) String address,
                           Model model) {
        User newUser = new User(firstName,lastName,patronymic,email,address);
        userService.update(newUser);

        model.addAttribute("userPage", newUser);

        return "userpage";
    }
}

