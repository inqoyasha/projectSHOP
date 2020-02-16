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
                                  @ModelAttribute(value = "productdata") Product product,
                                  Model model) {
        System.out.println(product);
        Product newProduct = new Product(product.getProductName(),
                                         product.getDescription(),
                                         product.getManufacturer(),
                                         product.getPictureURL(),
                                         product.getPrice(),
                                         product.getQuantity(),
                                         product.isActive(),
                                         product.getCategory());
        System.out.println(newProduct);
        productService.update(newProduct, p_id);

        return "editproduct";
    }
}
