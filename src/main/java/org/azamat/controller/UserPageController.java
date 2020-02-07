package org.azamat.controller;

import org.azamat.model.UserPage;
import org.azamat.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPageController {

    private final UserPageService userPageService;
    @Autowired
    public UserPageController(UserPageService userPageService) {
        this.userPageService = userPageService;
    }

    @GetMapping("/account")
    public String account(Model model) {
        UserPage user = userPageService.findById(1);
        if (user == null) {
            userPageService.save(new UserPage("","","","",""));
            user = userPageService.findById(1);
        }
        model.addAttribute("userPage", user);
        return "userpage";
    }

    @PostMapping("/account")
    public String saveData(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName,
                           @RequestParam(value = "patronymic", required = false) String patronymic,
                           @RequestParam(value = "email", required = false) String email,
                           @RequestParam(value = "address", required = false) String address,
                           Model model) {
        UserPage user = new UserPage(firstName,lastName,patronymic,email,address);
        userPageService.update(user);

        model.addAttribute("userPage", user);

        return "userpage";
    }
}

