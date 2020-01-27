package org.azamat.controller;

import org.azamat.SpringBootStarter;
import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.OrderStatus;
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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);
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
        if(session.getAttribute("cart") == null) {
            Order order = new Order();
            order.setStatus(OrderStatus.INCART);
            order = this.orderService.create(order);
            List<OrderProduct> cart = new ArrayList<>();
            cart.add(new OrderProduct(order, productService.getProduct(id).orElse(null), 1));
            order.setOrderProducts(cart);

            log.info("buy method: cart: {} ", cart);

            this.orderService.update(order);
            session.setAttribute("cart", cart);
        } else {
            List<OrderProduct> cart = (List<OrderProduct>) session.getAttribute("cart");
            for (Order order : orderService.getAllOrders()) {
                int index = isExists(id, cart);
                if (index == -1) {
                    cart.add(new OrderProduct(order, productService.getProduct(id).orElse(null), 1));
                    session.setAttribute("cart", cart);
                } else {
                    cart.get(index).setQuantity(cart.get(index).getQuantity()+1);
                    order.setOrderProducts(cart);
                    orderService.update(order);
                    session.setAttribute("cart", cart);
                }
            }
        }
        return "redirect:/order";
    }

    private int isExists(int id, List<OrderProduct> cart) {
        for (int i=0;i<cart.size();++i){
            if(cart.get(i).getProduct().getP_id() == id)
                return i;
        }
        return -1;
    }




}
