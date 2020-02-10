package org.azamat.service.impl;

import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.OrderProductRepository;
import org.azamat.repository.OrderRepository;
import org.azamat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
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
    public String addOrderProduct(int p_id) {
        String response = null;
        User userSession = (User)session.getAttribute("connectedUser");
        Order order = userSession.getOrder();
        OrderProduct orderProduct = orderProductRepository.findByOrderAndProduct(order.getO_id(), p_id);

        return response;
    }
}