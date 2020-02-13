package org.azamat.controller;

import org.azamat.model.Product;
import org.azamat.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manage")
public class ManageController {

    private final ProductService productService;

    public ManageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/show/all")
    public String viewProduct(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "/manage";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int p_id, Model model) {
        Product product = productService.getProduct(p_id).orElse(null);
        model.addAttribute("product", product);

        return "editproduct";
    }

    @PostMapping("/edit/{id}")
    public String saveEditProduct(@PathVariable("id") int p_id,
                                  @RequestParam(value = "productName", required = false) String productName,
                                  @RequestParam(value = "pictureURL", required = false) String pictureURL,
                                  @RequestParam(value = "price", required = false) double price,
                                  Model model) {
        Product product = new Product(productName, pictureURL, price);
        productService.update(product, p_id);

        return "editproduct";
    }
}
