package org.azamat.controller;

import io.swagger.annotations.ApiOperation;
import org.azamat.SpringBootStarter;
import org.azamat.service.CheckoutProductService;
import org.azamat.service.CheckoutService;
import org.azamat.service.ProductService;
import org.azamat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@ApiOperation("/admin")
public class UserOrdersController {

    private final ProductService productService;
    private final CheckoutService checkoutService;
    private final CheckoutProductService checkoutProductService;
    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);
    @Autowired
    public UserOrdersController (ProductService productService,
                                 CheckoutService checkoutService,
                                 CheckoutProductService checkoutProductService,
                                 UserService userService) {
        this.productService = productService;
        this.checkoutService = checkoutService;
        this.checkoutProductService = checkoutProductService;
        this.userService = userService;
    }

        @GetMapping("/users")
        @ApiOperation("Show list of users")
        public String viewUsers(Model model) {
            model.addAttribute("users", userService.getAll());

            return "users";
        }

        @GetMapping("/user-orders/{id}")
        @ApiOperation("Show user orders by user id")
        public String viewOrders(@PathVariable("id") int id,
                                 Model model) {
            model.addAttribute("orders", checkoutService.getAllByUser(id));

            return "userorders";
        }

        @GetMapping("/user-orders/{id}/info")
        @ApiOperation("Show order details by order id")
        public String viewOrderInfo(@PathVariable("id") int id,
                                    Model model) {
            model.addAttribute("orderDetails", checkoutProductService.getAllByCheckout(id));
            model.addAttribute("totalOrderPrice", checkoutProductService.getTotalPrice(checkoutProductService.getAllByCheckout(id)));

            return "userorderinfo";
        }
}


