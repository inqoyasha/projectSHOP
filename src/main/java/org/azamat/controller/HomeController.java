package org.azamat.controller;

import org.azamat.model.OrderProduct;
import org.azamat.model.Product;
import org.azamat.service.OrderProductService;
import org.azamat.service.OrderService;
import org.azamat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value={"", "/", "home", "/home"})
public class HomeController {

    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    @Autowired
    public HomeController(ProductService productService,
                          OrderService orderService,
                          OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cartCount", orderProductService.size());

        return "home";
    }

    @GetMapping("/info/{p_id}")
    public String viewProduct(@PathVariable("p_id") int p_id, Model model) {
        Product product = productService.getProduct(p_id).orElse(null);
        model.addAttribute("product", product);

        return "info";
    }
}