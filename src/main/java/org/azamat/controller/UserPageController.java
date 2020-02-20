package org.azamat.controller;

import io.swagger.annotations.ApiOperation;
import org.azamat.model.securitymodel.User;
import org.azamat.service.CheckoutProductService;
import org.azamat.service.OrderProductService;
import org.azamat.service.UserService;
import org.azamat.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserPageController {

    @Autowired
    private UserService userService;
    @Autowired
    private CheckoutProductService checkoutProductService;

    @Autowired
    OrderProductService orderProductService;


    @GetMapping("/account")
    @ApiOperation("View user page")
    public String account(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("userPage", userService.findById(user.getId()));
        model.addAttribute("orders", checkoutProductService.findAll());
        model.addAttribute("cartCount", orderProductService.cartCount());

        return "userpage";
    }

    @PutMapping("/account")
    @ApiOperation("Edit user data")
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

