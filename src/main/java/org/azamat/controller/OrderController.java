package org.azamat.controller;

import org.azamat.SpringBootStarter;
import org.azamat.service.*;
import org.azamat.service.impl.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final CheckoutService checkoutService;
    private final CheckoutProductService checkoutProductService;
    private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);

    @Autowired
    public OrderController(ProductService productService,
                           OrderService orderService,
                           OrderProductService orderProductService, CheckoutService checkoutService, CheckoutProductService checkoutProductService/*, HttpSession session*/) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.checkoutService = checkoutService;
        this.checkoutProductService = checkoutProductService;
    }

    @Autowired
    UserService userService;

    @GetMapping
    public String index(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("orderProducts", orderProductService.findAllByOrder(userService.findById(user.getId()).getOrder()));
        model.addAttribute("totalOrderPrice", userService.findById(user.getId()).getOrder().getTotalOrderPrice());
        System.out.println("totalOrderPrice: " + userService.findById(user.getId()).getOrder());
        model.addAttribute("cartCount", orderProductService.size()); //неправильно

        return "order";
    }

    @GetMapping("/buy/{productId}")
    public String buy(@PathVariable("productId") Integer id) {
        orderService.addOrderProduct(id);

        return "redirect:/cart";
    }

    @GetMapping("/remove/{orderProductId}")
    public String remove(@PathVariable("orderProductId") Integer id) {
        orderService.removeOrderProduct(id);

        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout() {
        checkoutService.addCheckout();
        orderProductService.removeAll();

        return "redirect:/cart";
    }
}
