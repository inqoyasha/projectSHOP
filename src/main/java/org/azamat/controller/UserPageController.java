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
        model.addAttribute("userPage", new UserPage());
        return "userpage";
    }

    @PostMapping("/account")
    public String saveData(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String patronymic,
                           @RequestParam String email,
                           @RequestParam String address) {
        UserPage user = new UserPage(firstName,lastName,patronymic,email,address);
        userPageService.save(user);

        return "redirect:/result";
    }
    @GetMapping("/result")
    public String printData(Model model) {
        UserPage user = userPageService.findById(1);
        model.addAttribute("userPage", user);
        return "result";
    }
}
