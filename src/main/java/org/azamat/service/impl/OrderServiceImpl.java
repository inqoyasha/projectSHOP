package org.azamat.service.impl;

import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.Product;
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
    private final HttpSession session;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderProductRepository orderProductRepository,
                            ProductRepository productRepository, HttpSession session) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
        this.session = session;
    }



    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public void addOrderProduct(Integer productId) {
        User userSession = (User)session.getAttribute("connectedUser");
        Order order = userSession.getOrder();
        OrderProduct orderProduct = orderProductRepository.findByOrderAndProduct(order, productRepository.findById(productId).orElse(new Product()));
        if (orderProduct == null) {
            orderProduct = new OrderProduct(order, productRepository.findById(productId).orElse(new Product()), 1, productRepository.findById(productId).orElse(new Product()).getPrice());
            List<OrderProduct> cart = new ArrayList<>();
            cart.add(orderProduct);
            orderProduct.setOrder(order);
            orderProduct.setProduct(productRepository.findById(productId).orElse(new Product()));
            orderProductRepository.save(orderProduct);
        } else {
            orderProduct.setQuantity(orderProduct.getQuantity()+1);
            orderProduct.setSubPrice(orderProduct.getSubPrice() + orderProduct.getProduct().getPrice());
            orderProductRepository.save(orderProduct);
        }
    }

    @Override
    public void removeOrderProduct(Integer orderProductId) {
        User userSession = (User)session.getAttribute("connectedUser");
        Order order = userSession.getOrder();
        for (OrderProduct op: orderProductRepository.findByOrder(order)) {
            OrderProduct orderProduct = orderProductRepository.findByOrderAndProduct(order, productRepository.findById(op.getProduct().getId()).orElse(new Product()));
             if (orderProduct.getId() == orderProductId) {
                if (orderProduct.getQuantity() > 1) {
                    orderProduct.setQuantity(orderProduct.getQuantity() - 1);
                    orderProduct.setSubPrice(orderProduct.getSubPrice() - orderProduct.getProduct().getPrice());
                    orderProductRepository.save(orderProduct);
                } else {
                    orderProductRepository.deleteById(orderProductId);
                }
            }
        }
    }
}