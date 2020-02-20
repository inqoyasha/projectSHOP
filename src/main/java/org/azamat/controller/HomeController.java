package org.azamat.controller;

import org.azamat.model.Product;
import org.azamat.service.*;
import org.azamat.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value={"", "/", "/home"})
public class HomeController {

    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final CategoryService categoryService;
    private final UserService userService;
    @Autowired
    public HomeController(ProductService productService,
                          OrderService orderService,
                          OrderProductService orderProductService, CategoryService categoryService, UserService userService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping
    public String home(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cartCount", orderProductService.cartCount());
        model.addAttribute("categories", categoryService.getAllCategories());

        return "home";
    }

    @GetMapping("/info/{p_id}")
    public String viewProduct(@PathVariable("p_id") int p_id, Model model) {
        Product product = productService.getProduct(p_id).orElse(null);
        model.addAttribute("cartCount", orderProductService.cartCount());
        model.addAttribute("product", product);

        return "info";
    }

    @GetMapping("show/category/{c_id}")
    public String viewCategory(@PathVariable("c_id") int c_id, Model model) {
        model.addAttribute("products", productService.findAllByCategory(categoryService.getById(c_id).orElse(null)));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("cartCount", orderProductService.cartCount());

        return "home";
    }
}