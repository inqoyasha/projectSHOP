package org.azamat.controller;

import org.azamat.model.Product;
import org.azamat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/store")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "products";
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