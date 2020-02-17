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
    private final  UserService userService;
    private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);
    @Autowired
    public OrderController(ProductService productService,
                           OrderService orderService,
                           OrderProductService orderProductService, CheckoutService checkoutService, CheckoutProductService checkoutProductService, UserService userService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.checkoutService = checkoutService;
        this.checkoutProductService = checkoutProductService;
        this.userService = userService;
    }



    @GetMapping
    public String index(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("orderProducts", orderProductService.findAllByOrder(userService.findById(user.getId()).getOrder()));
        model.addAttribute("totalOrderPrice", orderProductService.getTotalPrice(orderProductService.findAllByOrder(userService.findById(user.getId()).getOrder())));
        model.addAttribute("cartCount", orderProductService.cartCount());

        return "order";
    }

    @GetMapping("/buy/{p_id}")
    public String buy(@PathVariable("p_id") Integer id) {
        orderService.addOrderProduct(id);

        return "redirect:/cart";
    }

    @GetMapping("/remove/{op_id}")
    public String remove(@PathVariable("op_id") Integer id) {
        orderService.removeOrderProduct(id);

        return "redirect:/cart";
    }

    @GetMapping("/create/checkout")
    public String createCheckout(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("userPage", userService.findById(user.getId()));

        return "checkoutinfo";
    }

    @GetMapping("/checkout")
    public String checkout(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        checkoutService.addCheckout();
        model.addAttribute("orderProducts", orderProductService.findAllByOrder(userService.findById(user.getId()).getOrder()));
        model.addAttribute("totalOrderPrice", orderProductService.getTotalPrice(orderProductService.findAllByOrder(userService.findById(user.getId()).getOrder())));
        orderProductService.removeAll();

        return "success";
    }
}
