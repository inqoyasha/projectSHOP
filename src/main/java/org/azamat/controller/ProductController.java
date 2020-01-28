package org.azamat.controller;

import org.azamat.model.Product;
import org.azamat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value={"", "/", "store"})
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "home";
    }

    @GetMapping("/info")
    public String info() {
        return "info";
    }

    @GetMapping("/info/{p_id}")
    public String viewProduct(@PathVariable Integer p_id, HttpSession session) {
        Product product = productService.getProduct(p_id).orElse(null);
        session.setAttribute("product", product);

        return "redirect:/info";
    }
}