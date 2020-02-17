package org.azamat.service.impl;

import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.OrderProductRepository;
import org.azamat.repository.OrderRepository;
import org.azamat.repository.ProductRepository;
import org.azamat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderProductRepository orderProductRepository,
                            ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
    }

    @Autowired
    private HttpSession session;

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public void remove(int id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public void addOrderProduct(Integer p_id) {
        User userSession = (User)session.getAttribute("connectedUser");
        Order order = userSession.getOrder();
        OrderProduct orderProduct = orderProductRepository.findByOrderAndProduct(order, productRepository.findById(p_id).orElse(null));
        if (orderProduct == null) {
            orderProduct = new OrderProduct(order, productRepository.findById(p_id).orElse(null), 1, productRepository.findById(p_id).orElse(null).getPrice());
            List<OrderProduct> cart = new ArrayList<>();
            cart.add(orderProduct);
/*            order.setOrderProducts(cart);*/

            orderProduct.setOrder(order);
            orderProduct.setProduct(productRepository.findById(p_id).orElse(null));
            orderProductRepository.save(orderProduct);
        } else {
            orderProduct.setQuantity(orderProduct.getQuantity()+1);
            orderProduct.setSubPrice(orderProduct.getSubPrice() + orderProduct.getProduct().getPrice());
            orderProductRepository.save(orderProduct);
        }
    }

    @Override
    public void removeOrderProduct(Integer op_id) {
        User userSession = (User)session.getAttribute("connectedUser");
        Order order = userSession.getOrder();
        for (OrderProduct op: orderProductRepository.findByOrder(order)) {
            OrderProduct orderProduct = orderProductRepository.findByOrderAndProduct(order, productRepository.findById(op.getProduct().getP_id()).orElse(null));
             if (orderProduct.getOp_id() == op_id) {
                if (orderProduct.getQuantity() > 1) {
                    orderProduct.setQuantity(orderProduct.getQuantity() - 1);
                    orderProduct.setSubPrice(orderProduct.getSubPrice() - orderProduct.getProduct().getPrice());
                    orderProductRepository.save(orderProduct);
                } else {
                    orderProductRepository.deleteById(op_id);
                    System.out.println("delete:"+ op_id);
                }
            }
        }
    }
}