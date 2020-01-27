package org.azamat.controller;

import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.OrderStatus;
import org.azamat.service.OrderProductService;
import org.azamat.service.OrderService;
import org.azamat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    @Autowired
    public OrderController(ProductService productService,
                           OrderService orderService,
                           OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @GetMapping("/order")
    public String index() {
        return "order";
    }

    @GetMapping("/cart/buy/{id}")
    public String buy(@PathVariable("id") int id,
                      Model model,
                      HttpSession session) {
        Order order = new Order();
        order.setStatus(OrderStatus.INCART);
        order = this.orderService.create(order);

        List<OrderProduct> cart = new ArrayList<>();
        cart.add(new OrderProduct(order, productService.getProduct(id).orElse(null), 1));
        order.setOrderProducts(cart);

        this.orderService.update(order);


        session.setAttribute("cart", cart);

        return "redirect:/order";
    }

}
