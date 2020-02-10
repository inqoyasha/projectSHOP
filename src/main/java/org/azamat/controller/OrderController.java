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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);
    @Autowired
    private HttpSession session;

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
        model.addAttribute("cartCount", orderProductService.size());

        return "order";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable("id") int id,
                      Model model,
                      HttpSession session) {

        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id,
                         HttpSession session) {

        List<OrderProduct> cart = (List<OrderProduct>) session.getAttribute("cart");
        int index = isExists(id, cart);
        for (Order order : orderService.getAllOrders()) {

            if (cart.get(index).getQuantity() != 1) {
                cart.get(index).setQuantity(cart.get(index).getQuantity() - 1);
            } else {
                cart.remove(index);
            }

            System.out.println("cart: ");
            cart.forEach(System.out::println);

            order.setOrderProducts(cart);

            System.out.println("order:" + order.toString());
            orderService.update(order);
        }

/*            session.setAttribute("cart", cart);*/

        return "redirect:/cart";
    }

    private int isExists(int id, List<OrderProduct> cart) {
        for (int i=0; i < cart.size(); ++i){
            if(cart.get(i).getProduct().getP_id() == id)
                return i;
        }
        return -1;
    }

}
