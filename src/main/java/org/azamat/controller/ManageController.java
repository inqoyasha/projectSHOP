package org.azamat.controller;

import org.azamat.model.Category;
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

        return "manage";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int p_id, Model model) {
        Product product = productService.getProduct(p_id).orElse(null);
        model.addAttribute("product", product);

        return "editproduct";
    }

    @PutMapping("/edit/{id}")
    public String saveEditProduct(@PathVariable("id") int p_id,
                                  @ModelAttribute(value = "product") Product product,
/*                                  @RequestParam(value = "productName", required = false) String productName,
                                  @RequestParam(value = "pictureURL", required = false) String pictureURL,
                                  @RequestParam(value = "price", required = false) int price,
                                  @RequestParam(value = "quantity", required = false) int quantity,
                                  @RequestParam(value = "description", required = false) String description,
                                  @RequestParam(value = "manufacturer", required = false) String manufacturer,
                                  @RequestParam(value = "active", required = false) boolean active,
                                  @RequestParam(value = "category", required = false) Category category,*/
                                  Model model) {
        System.out.println("product 1 "+ product);
        Product newProduct = new Product(product.getProductName(),
                                         product.getDescription(),
                                         product.getManufacturer(),
                                         product.getPictureURL(),
                                         product.getPrice(),
                                         product.getQuantity(),
                                         product.isActive(),
                                         product.getCategory());
        System.out.println("product 2 "+newProduct);
/*        Product newProduct = new Product(productName, description, manufacturer, pictureURL, price, quantity, active, category);*/
        productService.update(newProduct, p_id);
        model.addAttribute("product", newProduct);

        return "editproduct";
    }
}
