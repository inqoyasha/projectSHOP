package org.azamat.controller;

import org.azamat.SpringBootStarter;
import org.azamat.model.Order;
import org.azamat.model.securitymodel.User;
import org.azamat.service.OrderProductService;
import org.azamat.service.OrderService;
import org.azamat.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);
    @Autowired
    HttpSession session;

    @Autowired
    public OrderController(ProductService productService,
                           OrderService orderService,
                           OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @GetMapping
    public String index(Model model) {
        User userSession = (User)session.getAttribute("connectedUser");
        Order order = userSession.getOrder();
        model.addAttribute("orderProducts", orderProductService.findAllByOrder(order));
        model.addAttribute("totalOrderPrice", order.getTotalOrderPrice());
        model.addAttribute("cartCount", orderProductService.size());

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
}
