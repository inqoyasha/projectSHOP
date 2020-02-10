package org.azamat.controller;

import org.azamat.model.Product;
import org.azamat.service.OrderProductService;
import org.azamat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    private final ProductService productService;
    @Autowired
    OrderProductService orderProductService;

    @Autowired
    public WelcomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String welcome(Model model) {
        model.addAttribute("cartCount", orderProductService.size());

        return "welcome";
    }
}
