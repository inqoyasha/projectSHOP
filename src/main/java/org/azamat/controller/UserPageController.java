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
        model.addAttribute("userPage", user);
        return "userpage";
    }

    @PostMapping("/account")
    public String saveData(@RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam(value = "patronymic") String patronymic,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "address") String address) {
        UserPage user = new UserPage(firstName,lastName,patronymic,email,address);
        userPageService.save(user);

        return "userpage";
    }
    @GetMapping("/result")
    public String printData(Model model) {
        UserPage user = userPageService.findById(1);
        model.addAttribute("userPage", user);
        return "result";
    }

    @PutMapping("/result")
    public String updateData(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String patronymic,
                             @RequestParam String email,
                             @RequestParam String address,
                             Model model) {
        UserPage user = new UserPage(firstName,lastName,patronymic,email,address);
        userPageService.update(user);
        model.addAttribute("userPage", user);
        return "result";
    }



}

